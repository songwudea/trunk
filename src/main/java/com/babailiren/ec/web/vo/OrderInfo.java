package com.babailiren.ec.web.vo;

import java.util.List;

import com.babailiren.ec.model.OrderDetail;
import com.babailiren.ec.model.Orders;

public class OrderInfo {
	
	private Orders order;
	
	private List<OrderDetail> orderDetail;
	
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	
}
