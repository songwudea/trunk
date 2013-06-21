package com.babailiren.ec.web.controller.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.constants.Constants;
import com.babailiren.ec.enumeration.OrderDispatchEnum;
import com.babailiren.ec.enumeration.OrderEnum;
import com.babailiren.ec.enumeration.OrderPayEnum;
import com.babailiren.ec.enumeration.ShipInfoEnum;
import com.babailiren.ec.model.Employee;
import com.babailiren.ec.model.OrderDetail;
import com.babailiren.ec.model.OrderDispatch;
import com.babailiren.ec.model.OrderPay;
import com.babailiren.ec.model.Orders;
import com.babailiren.ec.model.User;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.EmployeeService;
import com.babailiren.ec.service.OrderDispatchService;
import com.babailiren.ec.service.OrderPayService;
import com.babailiren.ec.service.OrderService;
import com.babailiren.ec.service.RefundService;
import com.babailiren.ec.service.UserService;
import com.babailiren.ec.web.common.Pager;
import com.babailiren.ec.web.session.BackSession;
import com.babailiren.ec.web.vo.OrderInfo;
import com.babailiren.ec.web.vo.OrderVo;
import com.babailiren.thirdpart.alipay.services.AlipayService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/admin/order")
public class BackOrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderPayService orderPayService;
	
	@Autowired
	private OrderDispatchService orderDispatchService ;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RefundService refundService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Orders orders ,HttpServletRequest request) {
		request.setAttribute("status", OrderEnum.values());
		return "admin/order/index";
	}
	
	@RequestMapping(value = "createRenderBill.html", method = RequestMethod.POST)
	public  @ResponseBody 
	String createRenderBill(String orderNumber, HttpServletRequest request) {
		// 1. 生成退款单
		// 2. 更新订单的状态   (退款中)
		// 3. 更新付款单的状态 (退款中)
		try {
			BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
			List<OrderPay> orderPays = orderPayService.findOrderPayByOrderNumber(orderNumber);
			OrderPay orderPay = orderPays.get(0);
			Orders order = orderService.getOrder(orderNumber);
			if(refundService.checkRefundOnly(order.getOrderNumber()) == false) {
				return "已存在整单退款记录,不能再次生成";
			}
			
			refundService.createRefund(order, orderPays.get(0), backSession.getEmployeeId(), backSession.getAccount() ,backSession.getSiteId());
			orderService.updateStatus(orderNumber, OrderEnum.ORDER_STATUS_REFUND);
			orderPayService.updateStatus(orderPay.getTradeNumber(), orderPay.getPayNumber(), OrderPayEnum.ORDER_PAY_STATUS_RENDER);
			return "退款单生成成功";
		} catch(Exception e) {
			e.printStackTrace();
			return "退款单生成失败";
		}
		
	}
	
	/**
	 * 生成退款单
	 * @return
	 */
	@RequestMapping(value = "createRenderBill.html", method = RequestMethod.GET)
	public String createRenderBill(Orders order, HttpServletRequest request) {
		List<OrderDetail> orderDetail = orderService.findOrderDetailByOrderNumber(order.getOrderNumber());
		
		List<OrderPay> orderPays = orderPayService.findOrderPayByOrderNumber(order.getOrderNumber());
		
		List<OrderDispatch> orderDispatchs = orderDispatchService.findOrderDispatchByOrderNumber(order.getOrderNumber());
		
		order = orderService.getOrder(order.getOrderNumber());
		User user = userService.getUser(order.getUserId());
		
		// 物流类型
		ShipInfoEnum[] values = ShipInfoEnum.values();
		request.setAttribute("shipInfos", values);
		request.setAttribute("order", order);
		request.setAttribute("user", user);
		request.setAttribute("orderDetail", orderDetail);
		request.setAttribute("orderPay", orderPays);
		request.setAttribute("orderDispatch", orderDispatchs);
		
		return "admin/order/refund";
	}
	
	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(Orders order, Page<Orders> page,String pageNo,String rows,HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		order.setSiteId(backSession.getSiteId());
		page = orderService.list(page, order);
		String orderJson = new Pager<Orders>().getJsonPagerData(page);
		request.setAttribute("order", order);
		request.setAttribute("status", OrderEnum.values());
		request.setAttribute("statuss", order.getStatus());
		return orderJson;
	}
	@RequestMapping(value = "orderdetail.html", method = RequestMethod.POST)
	public @ResponseBody
	String orderdetail(Integer orderId) {
		Gson gson = new Gson();
		OrderInfo orderInfo = orderService.getOrderInfo(orderId);
		List<OrderDetail> orderDetail = orderInfo.getOrderDetail();
		return gson.toJson(orderDetail);
	}

	@RequestMapping(value = "view.html", method = RequestMethod.GET)
	public String view(Orders order,HttpServletRequest request) {
		
		List<OrderDetail> orderDetail = orderService.findOrderDetailByOrderNumber(order.getOrderNumber());
		
		List<OrderPay> orderPays = orderPayService.findOrderPayByOrderNumber(order.getOrderNumber());
		
		List<OrderDispatch> orderDispatchs = orderDispatchService.findOrderDispatchByOrderNumber(order.getOrderNumber());
		
		order = orderService.getOrder(order.getOrderNumber());
		User user = userService.getUser(order.getUserId());
		
		// 物流类型
		ShipInfoEnum[] values = ShipInfoEnum.values();
		request.setAttribute("shipInfos", values);
		request.setAttribute("order", order);
		request.setAttribute("user", user);
		request.setAttribute("orderDetail", orderDetail);
		request.setAttribute("orderPay", orderPays);
		request.setAttribute("orderDispatch", orderDispatchs);
		return "/admin/order/view";
	}
	
	/**
	 * 确认付款,生成发货单,不调用支付宝任何方法,调用则在发货这里调用
	 * @param orderNumber
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "confirmPay.html", method = RequestMethod.POST)
	public String confirmPay(String orderNumber, HttpServletRequest request) {
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		Employee employee = employeeService.getEmployee(backSession.getEmployeeId());
		
		
		List<OrderPay> orderPays = orderPayService.findOrderPayByOrderNumber(orderNumber);
		OrderPay orderPay = orderPays.get(0);
		
		
		// 保存确认人,状态改为支付完成
		orderPayService.updateStatusWithConfirm(orderPay.getPayNumber(), OrderPayEnum.ORDER_PAY_FINISH, employee.getName());
		orderService.updateStatus(orderNumber, OrderEnum.ORDER_STATUS_DISPATCH);
		
		// TODO 订单状态 进入到发货流程
		
		// 验证重复提交
		List<OrderDispatch> list = orderDispatchService.findOrderDispatchByOrderNumber(orderNumber);
		if(list == null || list.size() == 0) {
			orderDispatchService.createDispatch(orderNumber);
		}
		
		// 创建发货单
		Orders order = new Orders();
		order.setOrderNumber(orderNumber);
		return view(order, request);
	}
	
	
	/**
	 * 确认发货,调用支付宝接口,并且填入发货单号和物流信息
	 * @param orderNumber
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "confirmDispath.html", method = RequestMethod.POST)
	public String confirmDispath(String orderNumber, String shipInfo, String dispatchNumber, HttpServletRequest request) throws Exception {
		
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
		return view(order, request);
	}
	
	@RequestMapping(value = "downorder.html", method = RequestMethod.POST)
	@ResponseBody
	public String downorder(String orderNumber,String status,String userName,String shiptel, String site ,HttpServletRequest request,
			HttpServletResponse response) throws ParsePropertyException, InvalidFormatException, IOException {
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		Orders order = new  Orders();
		order.setOrderNumber(orderNumber);
		order.setStatus(status);
		order.setUserName(userName);
		order.setShiptel(shiptel);
		order.setSiteId(backSession.getSiteId());
		String templateFileName = request.getSession().getServletContext().getRealPath("/downtemplate/Order.xls");
		List<OrderVo> orderVos = orderService.findOrderVos(order);
		List<OrderDetail> detailVos = orderService.findOrderDetailByOrderNumber(); 
		
		for(int i = 0; i < orderVos.size(); i++) {
			OrderVo orderVo = orderVos.get(i);
			String  orderNumber1 = orderVo.getOrderNumber();
			OrderDispatch dispatch =orderDispatchService.getOrderDispatchByOrderNumber(orderNumber1);
			if (dispatch != null  && dispatch.getStatus() != null && !"".equals(dispatch.getStatus())) {
				if(dispatch.getStatus().equals("ORDER_DISPATCH_STATUS_SELLER_WAIT")){
					dispatch.setStatus("等待卖家发货");
				}else if(dispatch.getStatus().equals("ORDER_DISPATCH_STATUS_CANEL")){
					dispatch.setStatus("取消发货");
				}else if(dispatch.getStatus().equals("ORDER_DISPATCH_STATUS_BUYER_CONFIRM")){
					dispatch.setStatus("已发货等待买家确认");
				}else if(dispatch.getStatus().equals("ORDER_DISPATCH_STATUS_FINISH")){
					dispatch.setStatus("发货完成");
				}			
			}
			orderVo.setDispatch(dispatch);
			orderVo.setCreatedAtS(orderVo.getCreatedAt());
			if (orderVo != null && orderVo.getStatus() != null && !"".equals(orderVo.getStatus())) {
				if(orderVo.getStatus().equals("ORDER_STATUS_PAY")){
					orderVo.setStatus("支付中");
				}else if(orderVo.getStatus().equals("ORDER_STATUS_DISPATCH")){
					orderVo.setStatus("发货中");
				}else if(orderVo.getStatus().equals("ORDER_STATUS_FINISH")){
					orderVo.setStatus("发货完成");
				}else if(orderVo.getStatus().equals("ORDER_STATUS_REFUND")){
					orderVo.setStatus("退款中");
				}else{
					orderVo.setStatus("交易取消");
				}				
			}
			for (int j = 0; j < detailVos.size(); j++) {
				OrderDetail orderDetail = detailVos.get(j);
				if(orderNumber1.equals(orderDetail.getOrderNumber())) {
					orderVo.getDetails().add(orderDetail);
				}
			}
		}
		
		Map<String, List<OrderVo>> beans = new HashMap<String, List<OrderVo>>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String datePath = dateFormat.format(new Date());
		String destFileName ="/downfile/"+ datePath +"Order.xls";
		String downFileName = request.getSession().getServletContext().getRealPath(destFileName);
		beans.put("orderdown", orderVos);
        XLSTransformer transformer = new XLSTransformer();
        transformer.transformXLS(templateFileName, beans, downFileName);
     System.out.println("ok");
        return destFileName;
	}
	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}*/
}
