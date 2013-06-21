package com.babailiren.ec.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.babailiren.ec.enumeration.OrderEnum;
import com.babailiren.ec.enumeration.OrderPayEnum;
import com.babailiren.ec.enumeration.SessionName;
import com.babailiren.ec.model.Address;
import com.babailiren.ec.model.Cart;
import com.babailiren.ec.model.Employee;
import com.babailiren.ec.model.OrderDetail;
import com.babailiren.ec.model.OrderDispatch;
import com.babailiren.ec.model.OrderPay;
import com.babailiren.ec.model.Orders;
import com.babailiren.ec.model.Site;
import com.babailiren.ec.model.User;
import com.babailiren.ec.service.AddressService;
import com.babailiren.ec.service.CartService;
import com.babailiren.ec.service.DispatchService;
import com.babailiren.ec.service.OrderDispatchService;
import com.babailiren.ec.service.OrderPayService;
import com.babailiren.ec.service.OrderService;
import com.babailiren.ec.service.UserService;
import com.babailiren.ec.web.common.WebCache;
import com.babailiren.ec.web.common.WebUtils;
import com.babailiren.ec.web.vo.OrderInfo;
import com.babailiren.thirdpart.alipay.util.UtilDate;

@Controller
public class OrderController {
	
	@Autowired
	private WebCache webCache;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderPayService orderPayService;
	
	@Autowired
	private OrderDispatchService orderDispatchService;
	@Autowired
	private UserService userService;
	@Autowired
	private DispatchService dispatchService;
	@RequestMapping(value="/order/createorder.html",method = RequestMethod.POST)
	public String createorder(HttpServletRequest request,HttpServletResponse response, String site, Integer addressId, String invoice, String invoiceType, String invoiceTitle,Integer ifdemand){
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		Integer userId = (Integer)request.getSession().getAttribute(SessionName.USER_ID.toString());
		String guestId = WebUtils.getGuestID(request,response);
		List<Cart> orderCarts = cartService.findAll(userId, guestId);
		User user = userService.getUser(userId);
		
		if(orderCarts != null && orderCarts.size() > 0) {
			Address address = addressService.getAddress(addressId);
			// 发票信息 和 备注 前台穿过来
			OrderInfo orderInfo = orderService.createOrderInfo(address, orderCarts, currentSite.getId(), userId, invoice, invoiceType, invoiceTitle);
			// 订单
			Orders order = orderInfo.getOrder();
			// 订单明细
			List<OrderDetail> orderDetail = orderInfo.getOrderDetail();
			if (ifdemand != null && ifdemand == 0) {
				order.setStatus(OrderEnum.ORDER_STATUS_DISPATCH.toString());
			}
			// 保存订单
			orderService.saveOrder(order);
			// 保存订单明细
			orderService.saveDetailOrder(orderDetail);
			//如果是索取小样的订单
			if (ifdemand != null && ifdemand == 0 && order.getPrice() == 0) {
				user.setIfdemand(1);
				userService.update(user);
				//根据订单编号  改变支付单的状态以及确认状态
				/*ORDER_PAY_FINISH*/
				String out_trade_no = UtilDate.getOrderNum();
				//生成支付单
				orderPayService.createSamplePay(order.getOrderNumber(),out_trade_no);
				//生成发货单
				List<OrderPay> orderPays = orderPayService.findOrderPayByOrderNumber(order.getOrderNumber());
				OrderPay orderPay = orderPays.get(0);
				// 保存确认人,状态改为支付完成
				orderPayService.updateStatusWithConfirm(orderPay.getPayNumber(), OrderPayEnum.ORDER_PAY_FINISH, "小样赠品");
				orderService.updateStatus(order.getOrderNumber(), OrderEnum.ORDER_STATUS_DISPATCH);
				
				// 验证重复提交
				List<OrderDispatch> list = dispatchService.findOrderDispatchByOrderNumber(order.getOrderNumber());
				if(list == null || list.size() == 0) {
					dispatchService.createDispatch(order.getOrderNumber());
				}
				request.getSession().setAttribute(SessionName.IF_DEMAND.toString(), "1");
			}else if(ifdemand != null && ifdemand == 0 && order.getPrice() != 0){
				/*给用户友好提示*/
				WebUtils.putErrorMessage("索取小样失败，请确保您的购物车没有其它产品，请您重新索取小样", request);
				return WebUtils.themesView(request, currentSite, "user/order");
			}
			// 生成支付单
			// orderPayService.createPay(order);
			// 删除购物车中的物品
			cartService.deleteFromCart(userId, currentSite.getId());
			request.setAttribute("order", order);
			request.setAttribute("orderDetail", orderDetail);
			if (ifdemand != null && ifdemand == 0) {
				return WebUtils.themesView(request,currentSite,"pay/demand");
			}else{
				return WebUtils.themesView(request,currentSite,"pay/payment");
			}
		} else {
			return WebUtils.themesView(request,currentSite,"pay/emptycart");
		}
	}
	
	
	@RequestMapping(value = "/user/orderDetail.html", method = RequestMethod.GET)
	public String userOrderDetail(Integer orderId, HttpServletRequest request,String site) {
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		OrderInfo orderInfo = orderService.getOrderInfo(orderId);
		String orderNumber = orderInfo.getOrder().getOrderNumber();
		OrderDispatch orderDispatch = orderDispatchService.getOrderDispatchByOrderNumber(orderNumber);
		request.setAttribute("orderInfo", orderInfo);
		request.setAttribute("orderDispatch", orderDispatch);
		
		return WebUtils.themesView(request,currentSite,"user/orderdetail");
	}
	@RequestMapping(value = "/user/order_{orderNumber}.html", method = RequestMethod.GET)
	public String userOrderDetail(@PathVariable String orderNumber, HttpServletRequest request,String site) {
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		OrderInfo orderInfo = orderService.getOrderInfo(orderService.getOrder(orderNumber).getId());
		request.setAttribute("orderInfo", orderInfo);
		return WebUtils.themesView(request,currentSite,"user/orderdetail");
	}
	
	/**
	 * 用户订单列表
	 * @param request
	 * @param site
	 * @return
	 */
	@RequestMapping(value = "/user/order.html", method = RequestMethod.GET)
	public String userOrders(HttpServletRequest request,String site) {
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		Integer userId = (Integer)request.getSession().getAttribute(SessionName.USER_ID.toString());
		List<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
		List<Orders> orders = orderService.findOrderByUserId(userId, currentSite.getId());
		for(int i = 0;i < orders.size(); i++) {
			Orders order = orders.get(i);
			List<OrderPay> orderPays = orderPayService.findOrderPayByOrderNumber(order.getOrderNumber());
			
			List<OrderDispatch> orderDispatchs = orderDispatchService.findOrderDispatchByOrderNumber(order.getOrderNumber());
			
			if(orderDispatchs != null && orderDispatchs.size() > 0) {
				OrderDispatch orderDispatch = orderDispatchs.get(0);
				order.setDispatchStatus(orderDispatch.getStatus());
			}
			
			// 订单付款状态
			if(orderPays != null && orderPays.size() > 0) {
				OrderPay orderPay = orderPays.get(0);
				order.setPayStatus(orderPay.getStatus());
			}
			String orderNumber = order.getOrderNumber();
			List<OrderDetail> orderDetails = orderService.findOrderDetailByOrderNumber(orderNumber);
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setOrder(order);
			orderInfo.setOrderDetail(orderDetails);
			orderInfos.add(orderInfo);
		}
		request.setAttribute("orderInfos", orderInfos);
		return WebUtils.themesView(request,currentSite,"user/order");
	}
}
