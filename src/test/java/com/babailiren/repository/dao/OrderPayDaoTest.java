package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.OrderDispatchDetail;
import com.babailiren.ec.model.OrderPay;
import com.babailiren.ec.repository.dao.OrderPayDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class OrderPayDaoTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private OrderPayDao orderPayDao;
	
	@Test
	public void testUpdate() {
		OrderPay orderPay = orderPayDao.getByPK(4);
		orderPay.setBuyer("xuang132@qq.com");
		OrderPay[] orderPays = { orderPay };
		orderPayDao.update(orderPays);
	}
}
