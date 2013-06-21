package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Refund;
import com.babailiren.ec.repository.dao.RefundDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class RefundDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private RefundDao refundDao;
	
	
	@Test
	public void testUpdate() {
		Refund e = new Refund();
		e.setId(1);
		e.setOrderNumber("123");
		Refund[] es = {e};
		
		refundDao.update(es);
		
	}
}
