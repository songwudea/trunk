package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.OrderDetail;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table = "order_details")
public class OrderDetailDao extends JdbcEntityDao<OrderDetail, Integer> {

	public List<OrderDetail> findOrderDetailByOrderNumber(String orderNumber) {
		String sql = " select * from order_details where order_details.order_number = ? ";
		return find(sql, orderNumber);
	}
	public List<OrderDetail> findOrderDetailByOrderNumber() {
		String sql = " select * from order_details ";
		return find(sql);
	}
}

