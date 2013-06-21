package com.babailiren.repository.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Orders;
import com.babailiren.ec.repository.dao.OrderDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class OrderDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private OrderDao orderDao;
	
	@Test
	public void testUpdate() {
		Orders order = orderDao.getByPK(21);
		order.setUpdateAt(new Date());
		Orders[] orders = { order };
		orderDao.update(orders);
	}
}
