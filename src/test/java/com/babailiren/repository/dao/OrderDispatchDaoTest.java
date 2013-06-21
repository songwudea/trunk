package com.babailiren.repository.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.OrderDetail;
import com.babailiren.ec.model.OrderDispatch;
import com.babailiren.ec.repository.dao.OrderDispatchDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class OrderDispatchDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private OrderDispatchDao orderDispatchDao;
	
	@Test
	public void testUpdate() {
		OrderDispatch orderDispatch = orderDispatchDao.getByPK(17);
		orderDispatch.setUpdateAt(new Date());
		
		OrderDispatch[] orderDispatchs = { orderDispatch };
		orderDispatchDao.update(orderDispatchs);
	}
}
