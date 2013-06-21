package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.PriceFilter;
import com.babailiren.ec.repository.dao.PriceFilterDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class PriceFilterDaoTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private PriceFilterDao priceFilterDao;
	
	
	@Test
	public void testUpdate() {
		PriceFilter e = new PriceFilter();
		e.setId(1);
		e.setRangeMax(123000);
		PriceFilter[] es = {e};
		
		priceFilterDao.update(es);
		
	}
}
