package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.ContentType;
import com.babailiren.ec.repository.dao.ContentTypeDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class ContentTypeDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private ContentTypeDao contentTypeDao;
	
	@Test
	public void testUpdate() {
		ContentType contentType = contentTypeDao.getByPK(4);
		ContentType[] contentTypes = { contentType };
		contentType.setName("常见问题1");
		contentTypeDao.update(contentTypes);
	}
}
