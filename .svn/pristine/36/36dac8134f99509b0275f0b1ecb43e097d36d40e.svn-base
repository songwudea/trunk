package com.babailiren.repository.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Link;
import com.babailiren.ec.repository.dao.LinkDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class LinkDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private LinkDao linkDao;
	
	@Test
	public void testUpdate() {
		Link link = linkDao.getByPK(1);
		link.setUpdatedAt(new Date());
		Link[] links = { link };
		linkDao.update(links);
	}
}
