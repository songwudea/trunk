package com.babailiren.ec.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.enumeration.OrderDispatchEnum;
import com.babailiren.ec.model.OrderDispatch;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "order_dispatchs")
public class OrderDispatchDao extends JdbcEntityDao<OrderDispatch, Integer> {
	
	
	public Page<OrderDispatch> findOrderDispatchPage(Page<OrderDispatch> page, OrderDispatch orderDispatch, Integer siteId) {
		List<Object> list = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from order_dispatchs ");
		sb.append(" where order_dispatchs.site_id = ? ");
		list.add(siteId);
		if(orderDispatch.getShipname() != null && !"".equals(orderDispatch.getShipname())) {
			sb.append(" and order_dispatchs.shipname like ?");
			list.add("%" + orderDispatch.getShipname() + "%");
		}
		if(orderDispatch.getOrderDispatchNumber() != null && !"".equals(orderDispatch.getOrderDispatchNumber())) {
			sb.append(" and order_dispatchs.order_dispatch_number = ?");
			list.add(orderDispatch.getOrderDispatchNumber());
		}
		if(orderDispatch.getStatus() != null && !"".equals(orderDispatch.getStatus()) && !"all".equals(orderDispatch.getStatus())) {
			sb.append(" and order_dispatchs.status = ?");
			list.add(orderDispatch.getStatus());
		}
		if(orderDispatch.getShipaddress() != null && !"".equals(orderDispatch.getShipaddress())) {
			sb.append(" and order_dispatchs.shipaddress like ?");
			list.add("%" + orderDispatch.getShipaddress() + "%");
		}
		
		page = findPage(page, sb.toString(), list.toArray());
		return page;
	}
	
	/**
	 * 专门用来更新状态的
	 * @param orderNumber
	 * @param orderDispatchEnum
	 */
	public void updateStatus(String orderNumber, OrderDispatchEnum orderDispatchEnum, String dispathNumber, String shipInfo) {
		String sql = " update order_dispatchs set status = ?, order_dispatch_number = ?, express_delivery_name = ?  where order_number = ? ";
		this.getJdbcTemplate().update(sql, orderDispatchEnum.toString(),dispathNumber,shipInfo, orderNumber);
	}
	
	public void updateStatus(String orderNumber, OrderDispatchEnum orderDispatchEnum) {
		String sql = " update order_dispatchs set status = ?  where order_number = ? ";
		this.getJdbcTemplate().update(sql, orderDispatchEnum.toString(), orderNumber);
		
	}
	
	public List<OrderDispatch> findOrderDispatchByOrderNumber(String orderNumber) {
		String sql = " select * from order_dispatchs where order_dispatchs.order_number = ? ";
		return find(sql, orderNumber);
	}
	
	public OrderDispatch getOrderDispatchByOrderNumber(String orderNumber) {
		String sql = " select * from order_dispatchs where order_dispatchs.order_number = ?  ";
		return get(sql, orderNumber);
	}
}
