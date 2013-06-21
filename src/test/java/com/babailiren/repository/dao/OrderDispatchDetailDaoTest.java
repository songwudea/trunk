package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.OrderDispatchDetail;
import com.babailiren.ec.repository.dao.OrderDispatchDetailDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class OrderDispatchDetailDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private OrderDispatchDetailDao orderDispatchDetailDao;
	
	@Test
	public void testUpdate() {
		OrderDispatchDetail orderDispatchDetail = orderDispatchDetailDao.getByPK(45);
		orderDispatchDetail.setItemName("日夜眼部精华1");
		OrderDispatchDetail[] orderDispatchDetails = { orderDispatchDetail };
		orderDispatchDetailDao.update(orderDispatchDetails);
	}
}
