package com.babailiren.ec.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.enumeration.OrderPayEnum;
import com.babailiren.ec.enumeration.PayType;
import com.babailiren.ec.model.OrderPay;
import com.babailiren.ec.model.Orders;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.OrderDao;
import com.babailiren.ec.repository.dao.OrderPayDao;

@Service
public class OrderPayService {

	@Autowired
	private OrderPayDao orderPayDao;

	@Autowired
	private OrderDao orderDao;
	
	public Page<OrderPay> list(Page<OrderPay> page, OrderPay orderPay, Integer siteId) {
		return orderPayDao.findOrderPayPage(page, orderPay, siteId);
	} 

	public void updateBuyer(String buyer,String payNumber) {
		
		orderPayDao.updateBuyer(buyer, payNumber);
	}
	public OrderPay createPay(String orderNumber, String payNumber) {
		Orders order = orderDao.getOrderByOrderNumber(orderNumber);
		OrderPay orderPay = new OrderPay();
		orderPay.setOrderNumber(order.getOrderNumber());
		orderPay.setCreatedAt(new Date());
		orderPay.setPayAmount(order.getPrice() + order.getShipfee());
		orderPay.setRemark(order.getRemark());
		orderPay.setStatus(OrderPayEnum.ORDER_PAY_STATUS_BUYER_WAIT.toString());
		orderPay.setType(PayType.ALIPAY_PAY.toString());
		orderPay.setUserId(order.getUserId());
		orderPay.setPayNumber(payNumber);
		return orderPayDao.add(orderPay);
	}
	public OrderPay createSamplePay(String orderNumber, String payNumber) {
		Orders order = orderDao.getOrderByOrderNumber(orderNumber);
		OrderPay orderPay = new OrderPay();
		orderPay.setOrderNumber(order.getOrderNumber());
		orderPay.setCreatedAt(new Date());
		orderPay.setPayAmount(order.getPrice() + order.getShipfee());
		orderPay.setRemark(order.getRemark());
		orderPay.setStatus(OrderPayEnum.ORDER_PAY_FINISH.toString());
		orderPay.setType(PayType.ALIPAY_PAY.toString());
		orderPay.setUserId(order.getUserId());
		orderPay.setPayNumber(payNumber);
//		orderPay.set
		return orderPayDao.add(orderPay);
	}
	public void updateStatus(String tradeNumber,String payNumber, OrderPayEnum status) {
		orderPayDao.updateStatus(tradeNumber,payNumber, status);
	}

	public void updateStatusWithConfirm(String payNumber,
			OrderPayEnum status, String name) {
		orderPayDao.updateStatusWithConfirm(payNumber, status, name);
	}

	public List<OrderPay> findOrderPayByOrderNumber(String orderNumber) {
		return orderPayDao.findOrderPayByOrderNumber(orderNumber);
	}

	public OrderPay getOrderPayByPayNumber(String payNumber) {
		return orderPayDao.getOrderPayByPayNumber(payNumber);
	}
}
