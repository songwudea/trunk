package com.babailiren.ec.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.enumeration.OrderDispatchEnum;
import com.babailiren.ec.model.OrderDetail;
import com.babailiren.ec.model.OrderDispatch;
import com.babailiren.ec.model.OrderDispatchDetail;
import com.babailiren.ec.model.Orders;
import com.babailiren.ec.repository.dao.OrderDao;
import com.babailiren.ec.repository.dao.OrderDetailDao;
import com.babailiren.ec.repository.dao.OrderDispatchDao;
import com.babailiren.ec.repository.dao.OrderDispatchDetailDao;

@Service
public class DispatchService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Autowired
	private OrderDispatchDao orderDispatchDao;

	@Autowired
	private OrderDispatchDetailDao orderDispatchDetailDao;

	

	public void update(String orderNumber, OrderDispatchEnum dispatchEnum,
			String dispathNumber, String shipInfo) {
		orderDispatchDao.updateStatus(orderNumber, dispatchEnum, dispathNumber,
				shipInfo);
	}

	public List<OrderDispatch> findOrderDispatchByOrderNumber(String orderNumber) {
		return orderDispatchDao.findOrderDispatchByOrderNumber(orderNumber);
	}

	public void createDispatch(String orderNumber) {
		Orders order = orderDao.getOrderByOrderNumber(orderNumber);
		OrderDispatch orderDispatch = new OrderDispatch();
		List<OrderDetail> orderDetails = orderDetailDao
				.findOrderDetailByOrderNumber(orderNumber);

		orderDispatch.setCreatedAt(new Date());
		orderDispatch.setOrderNumber(orderNumber);
		orderDispatch.setPrice(order.getPrice());
		orderDispatch.setQuantity(order.getQuantity());
		orderDispatch.setShipaddress(order.getShipaddress());
		orderDispatch.setShipcity(order.getShipcity());
		orderDispatch.setShipfee(order.getShipfee());
		orderDispatch.setShipname(order.getShipname());
		orderDispatch.setShipprovince(order.getShipprovince());
		orderDispatch.setShipregion(order.getShipregion());
		orderDispatch.setShiptel(order.getShiptel());
		orderDispatch.setShipzip(order.getShipzip());
		orderDispatch.setSiteId(order.getSiteId());
		orderDispatch
				.setStatus(OrderDispatchEnum.ORDER_DISPATCH_STATUS_SELLER_WAIT
						.toString());
		orderDispatch.setUserId(order.getUserId());
		orderDispatch.setCreatedAt(new Date());
		orderDispatch = orderDispatchDao.add(orderDispatch);

		List<OrderDispatchDetail> list = new ArrayList<OrderDispatchDetail>();
		for (int i = 0; i < orderDetails.size(); i++) {
			OrderDetail orderDetail = orderDetails.get(i);
			OrderDispatchDetail orderDispatchDetail = new OrderDispatchDetail();
			orderDispatchDetail.setAmount(orderDetail.getAmount());
			orderDispatchDetail.setCreatedAt(new Date());
			orderDispatchDetail.setItemId(orderDetail.getItemId());
			orderDispatchDetail.setItemName(orderDetail.getItemName());
			orderDispatchDetail.setOrderDispathId(orderDispatch.getId());
			orderDispatchDetail.setPoint(orderDetail.getPoint());
			orderDispatchDetail.setPrice(orderDetail.getPrice());
			orderDispatchDetail.setQuantity(orderDetail.getQuantity());
			orderDispatchDetail.setUserId(order.getUserId());
			list.add(orderDispatchDetail);
		}
		orderDispatchDetailDao.add(list.toArray(new OrderDispatchDetail[0]));

	}
}
