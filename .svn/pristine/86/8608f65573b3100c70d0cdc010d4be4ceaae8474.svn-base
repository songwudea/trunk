package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.SitePageConfig;
import com.babailiren.ec.model.Template;
import com.babailiren.ec.repository.dao.SitePageConfigDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class SitePageConfigDaoTest  extends AbstractJUnit4SpringContextTests {

	@Autowired
	private SitePageConfigDao sitePageConfigDao;
	@Test
	public void testUpdate() {
		SitePageConfig e = new SitePageConfig();
		e.setId(158);
		e.setQuantity(5);
		SitePageConfig[] es = {e};
		
		sitePageConfigDao.update(es);
		
	}
}
