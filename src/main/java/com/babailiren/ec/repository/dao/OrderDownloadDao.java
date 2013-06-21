package com.babailiren.ec.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Orders;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.web.vo.OrderVo;

@Repository
@EntityDao(Table = "orders")
public class OrderDownloadDao extends JdbcEntityDao<OrderVo, Integer> {
	public List<OrderVo> findOrderPageBySiteId(Orders order) {
		List<OrderVo> orderVos = new ArrayList<OrderVo>();
		StringBuffer sb = new StringBuffer();
		sb.append(" select orders.*, users.name as userName, order_pay.status as payStatus from orders ");
		sb.append(" left join users on users.id = orders.user_id ");
		sb.append(" left join order_pay on order_pay.order_number = orders.order_number ");
		sb.append(" where orders.site_id = ? ");
		List<Object> list = new ArrayList<Object>();
		list.add(order.getSiteId());
		
		if(order.getOrderNumber() != null && !"".equals(order.getOrderNumber())) {
			sb.append(" and orders.order_number = ? ");
			list.add(order.getOrderNumber());
		}
		
		if(order.getStatus() != null && !"".equals(order.getStatus())  && !"all".equals(order.getStatus())) {
			sb.append(" and orders.status = ? ");
			list.add(order.getStatus());
		}
		
		if(order.getUserName() != null && !"".equals(order.getUserName())) {
			sb.append(" and users.name = ? ");
			list.add(order.getUserName());
		}
		
		if(order.getShiptel() != null && !"".equals(order.getShiptel())) {
			sb.append(" and orders.ship_tel = ? ");
			list.add(order.getShiptel());
		}
		
		orderVos = find( sb.toString(), list.toArray());
		return orderVos;
	}	
	
	
	public List<OrderVo> findOrderVos(Orders order) {
		List<OrderVo> orderVos = new ArrayList<OrderVo>();
		StringBuffer sb = new StringBuffer();
		sb.append(" select orders.*, users.name as userName, order_pay.status as payStatus from orders ");
		sb.append(" left join users on users.id = orders.user_id ");
		sb.append(" left join order_pay on order_pay.order_number = orders.order_number ");
		sb.append(" where orders.site_id = ? ");
		List<Object> list = new ArrayList<Object>();
		list.add(order.getSiteId());
		
		if(order.getOrderNumber() != null && !"".equals(order.getOrderNumber())) {
			sb.append(" and orders.order_number = ? ");
			list.add(order.getOrderNumber());
		}
		
		if(order.getStatus() != null && !"".equals(order.getStatus())  && !"all".equals(order.getStatus())) {
			sb.append(" and orders.status = ? ");
			list.add(order.getStatus());
		}
		
		if(order.getUserName() != null && !"".equals(order.getUserName())) {
			sb.append(" and users.name = ? ");
			list.add(order.getUserName());
		}
		
		if(order.getShiptel() != null && !"".equals(order.getShiptel())) {
			sb.append(" and orders.ship_tel = ? ");
			list.add(order.getShiptel());
		}
		orderVos = find( sb.toString(), list.toArray());
		return orderVos;
	}	
}
