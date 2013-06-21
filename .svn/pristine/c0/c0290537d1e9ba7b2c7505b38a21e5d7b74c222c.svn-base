package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Site;
import com.babailiren.ec.repository.dao.SiteDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class SiteDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private SiteDao siteDao;
	@Test
	public void testUpdate() {
		Site e = new Site();
		e.setId(1);
		e.setTemplateId(1);
		Site[] es = {e};
		
		siteDao.update(es);
		
	}
}
