package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.PagePublish;
import com.babailiren.ec.repository.dao.PagePublishDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class PagePublishDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private PagePublishDao pagePublishDao;
	
	
	@Test
	public void testUpdate() {
		PagePublish e = new PagePublish();
		e.setId(1);
		e.setEntityName("");
		PagePublish[] es = {e};
		
		pagePublishDao.update(es);
		
	}
	
}
