package com.babailiren.repository.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.OrderDetail;
import com.babailiren.ec.repository.dao.OrderDetailDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class OrderDetailDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Test
	public void testUpdate() {
		OrderDetail orderDetail = orderDetailDao.getByPK(28);
		orderDetail.setPrice(10000);
		orderDetail.setUpdatedAt(new Date());
		OrderDetail[] orderDetails = { orderDetail };
		orderDetailDao.update(orderDetails);
	}
}
