package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.ReturnPurchase;
import com.babailiren.ec.repository.dao.ReturnPurchaseDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class ReturnPurchaseDaoTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private ReturnPurchaseDao returnPurchaseDao;
	
	
	@Test
	public void testUpdate() {
		ReturnPurchase e = new ReturnPurchase();
		e.setId(1);
		e.setItemId(36);
		ReturnPurchase[] es = {e};
		
		returnPurchaseDao.update(es);
		
	}
}
