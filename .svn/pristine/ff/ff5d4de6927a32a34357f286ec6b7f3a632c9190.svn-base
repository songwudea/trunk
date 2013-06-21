package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Content;
import com.babailiren.ec.repository.dao.ContentDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class ContentDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private ContentDao contentDao;
	
	@Test
	public void testUpdate() {
		Content content = contentDao.getByPK(45);
		Content[] contents = { content };
		content.setTitle("关于瞳话1");
		contentDao.update(contents);
	}
}
