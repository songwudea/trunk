package com.babailiren.ec.repository.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.enumeration.OrderEnum;
import com.babailiren.ec.model.Orders;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "orders")
public class OrderDao extends JdbcEntityDao<Orders, Integer> {
	public Page<Orders> findOrderPageBySiteId(Page<Orders> page, Orders order) {
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
		
		if(order.getStartcreatedAt() != null && !"".equals(order.getStartcreatedAt()) && order.getEndcreatedAt() != null && !"".equals(order.getEndcreatedAt())) {
			sb.append(" and orders.created_at >= ? ");
			list.add(order.getStartcreatedAt());
			sb.append(" and orders.created_at <= ? ");
			list.add(order.getEndcreatedAt());
		}
		
		page = findPage(page, sb.toString(), list.toArray());
		return page;
	}
	
	
	public Orders getOrderByOrderNumber(String orderNumber) {
		String sql = " select * from orders where orders.order_number = ? ";
		return get(sql, orderNumber);
	}
	
	public List<Orders> findOrdersByUserId(Integer userId, Integer siteId) {
		String sql = " select * from orders where user_id = ? and site_id = ? order by created_at desc ";
		return find(sql, userId, siteId);
	}
	
	/**
	 * 专门用来更新订单状态
	 * @param orderNumber
	 * @param status
	 */
	public void updateStatus(String orderNumber, OrderEnum status) {
		String sql = " update orders set status = ? where order_number = ? ";
		this.getJdbcTemplate().update(sql, status.toString(), orderNumber);
	}
	
}
