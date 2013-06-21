package com.babailiren.ec.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.constants.Constants;
import com.babailiren.ec.enumeration.OrderEnum;
import com.babailiren.ec.enumeration.OrderPayEnum;
import com.babailiren.ec.model.Employee;
import com.babailiren.ec.model.OrderDispatch;
import com.babailiren.ec.model.OrderPay;
import com.babailiren.ec.model.Orders;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.DispatchService;
import com.babailiren.ec.service.EmployeeService;
import com.babailiren.ec.service.OrderPayService;
import com.babailiren.ec.service.OrderService;
import com.babailiren.ec.web.common.Pager;
import com.babailiren.ec.web.session.BackSession;

@Controller
@RequestMapping("/admin/orderpay")
public class OrderPayController {
	
	@Autowired
	private OrderPayService orderPayService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private DispatchService dispatchService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		// 状态
		request.setAttribute("status", OrderPayEnum.values());
		return "/admin/orderpay/index";
	}
	
	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(OrderPay orderPay, Page<OrderPay> page,
			HttpServletRequest request, HttpServletResponse response) {
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		Integer siteId = backSession.getSiteId();
		page = orderPayService.list(page, orderPay, siteId);
		return new Pager<OrderPay>().getJsonPagerData(page);
	}
	
	/**
	 * 确认付款,生成发货单,不调用支付宝任何方法,调用则在发货这里调用
	 * @param orderNumber
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "confirmPay.html", method = RequestMethod.GET)
	public String confirmPay(String orderNumber, HttpServletRequest request) {
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		Employee employee = employeeService.getEmployee(backSession.getEmployeeId());
		
		List<OrderPay> orderPays = orderPayService.findOrderPayByOrderNumber(orderNumber);
		OrderPay orderPay = orderPays.get(0);
		
		
		// 保存确认人,状态改为支付完成
		orderPayService.updateStatusWithConfirm(orderPay.getPayNumber(), OrderPayEnum.ORDER_PAY_FINISH, employee.getName());
		orderService.updateStatus(orderNumber, OrderEnum.ORDER_STATUS_DISPATCH);
		
		// 验证重复提交
		List<OrderDispatch> list = dispatchService.findOrderDispatchByOrderNumber(orderNumber);
		if(list == null || list.size() == 0) {
			dispatchService.createDispatch(orderNumber);
		}
		
		// 创建发货单
		Orders order = new Orders();
		order.setOrderNumber(orderNumber);
		return index(request);
	}
	
	
}
