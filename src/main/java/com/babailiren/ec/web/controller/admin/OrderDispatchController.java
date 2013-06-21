package com.babailiren.ec.web.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.constants.Constants;
import com.babailiren.ec.enumeration.OrderDispatchEnum;
import com.babailiren.ec.enumeration.ShipInfoEnum;
import com.babailiren.ec.model.OrderDetail;
import com.babailiren.ec.model.OrderDispatch;
import com.babailiren.ec.model.OrderDispatchDetail;
import com.babailiren.ec.model.OrderPay;
import com.babailiren.ec.model.Orders;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.OrderDispatchDetailDao;
import com.babailiren.ec.service.OrderDispatchService;
import com.babailiren.ec.service.OrderPayService;
import com.babailiren.ec.web.common.Pager;
import com.babailiren.ec.web.session.BackSession;
import com.babailiren.ec.web.vo.OrderInfo;
import com.babailiren.thirdpart.alipay.services.AlipayService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/admin/orderdispatch")
public class OrderDispatchController {

	@Autowired
	private OrderDispatchService orderDispatchService;
	
	@Autowired
	private OrderPayService orderPayService;
	
	@Autowired
	private OrderDispatchDetailDao orderDispatchDetailDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		// 状态
		request.setAttribute("status", OrderDispatchEnum.values());
		return "/admin/orderdispatch/index";
	}
	
	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(OrderDispatch orderDispatch, Page<OrderDispatch> page,
			HttpServletRequest request, HttpServletResponse response) {
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		Integer siteId = backSession.getSiteId();
		page = orderDispatchService.list(page, orderDispatch, siteId);
		return new Pager<OrderDispatch>().getJsonPagerData(page);
	}
	@RequestMapping(value = "orderdispatchdetail.html", method = RequestMethod.POST)
	public @ResponseBody
	String orderdetail(Integer orderDispathId) {
		Gson gson = new Gson();
		List<OrderDispatchDetail> dispatchDetails = orderDispatchService.findOrderDispatchDetailByOrderNumber(orderDispathId);
		return gson.toJson(dispatchDetails);
	}
	/**
	 * 确认付款,生成发货单,不调用支付宝任何方法,调用则在发货这里调用
	 * @param orderNumber
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "view.html", method = RequestMethod.GET)
	public String dispatchdetail(Integer orderDispathId, HttpServletRequest request) {
		List<OrderDispatchDetail> orderDispatchDetails = orderDispatchDetailDao.findOrderDispatchDetailByOrderDispathId(orderDispathId);
		OrderDispatch orderDispatch = orderDispatchService.getOrderDispatchById(orderDispathId);
		request.setAttribute("orderDispatchDetails", orderDispatchDetails);
		request.setAttribute("orderDispatch", orderDispatch);
		ShipInfoEnum[] values = ShipInfoEnum.values();
		request.setAttribute("shipInfos", values);
		return "/admin/orderdispatch/view";
	}
	
	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public String confirmDispatch(Integer orderDispathId, HttpServletRequest request) {
		List<OrderDispatchDetail> orderDispatchDetails = orderDispatchDetailDao.findOrderDispatchDetailByOrderDispathId(orderDispathId);
		OrderDispatch orderDispatch = orderDispatchService.getOrderDispatchById(orderDispathId);
		request.setAttribute("orderDispatch", orderDispatch);
		request.setAttribute("orderDispatchDetails", orderDispatchDetails);
		ShipInfoEnum[] values = ShipInfoEnum.values();
		request.setAttribute("shipInfos", values);
		return "/admin/orderdispatch/edit";
	}
	
	/**
	 * 确认发货,调用支付宝接口,并且填入发货单号和物流信息
	 * @param orderNumber
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "confirmDispatch.html", method = RequestMethod.POST)
	public String confirmDispatch(String orderNumber, String shipInfo, String dispatchNumber, HttpServletRequest request) throws Exception {
		
		// 更新发货单 发货单号 物流信息, 已发货等待买家确认
		orderDispatchService.update(orderNumber, OrderDispatchEnum.ORDER_DISPATCH_STATUS_BUYER_CONFIRM, dispatchNumber, shipInfo);
		List<OrderPay> orderPays = orderPayService.findOrderPayByOrderNumber(orderNumber);
		List<OrderDispatch> orderDispatchs = orderDispatchService.findOrderDispatchByOrderNumber(orderNumber);
		OrderPay orderPay = orderPays.get(0);
		OrderDispatch orderDispatch = orderDispatchs.get(0);
		
		//必填参数//
		//支付宝交易号
		String trade_no = orderPay.getTradeNumber();
		
		//物流公司名称
		String logistics_name = orderDispatch.getExpressDeliveryName();
		
		//发货时的运输类型
		String transport_type = "EXPRESS";
		
		//选填参数
		
        //物流发货单号
		String invoice_no = orderDispatch.getOrderDispatchNumber();
		//////////////////////////////////////////////////////////////////////////////////
		
		//把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("trade_no", trade_no);
        sParaTemp.put("logistics_name", logistics_name);
		sParaTemp.put("invoice_no", invoice_no);
		sParaTemp.put("transport_type", transport_type);
		//构造函数，生成请求URL  
		String sHtmlText = AlipayService.send_goods_confirm_by_platform(sParaTemp);
		request.setAttribute("sHtmlText", sHtmlText);
		
		Orders order = new Orders();
		order.setOrderNumber(orderNumber);
		return confirmDispatch(orderDispatch.getId(), request);
	}
}
