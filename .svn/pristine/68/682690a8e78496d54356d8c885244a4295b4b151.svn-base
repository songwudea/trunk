package com.babailiren.repository.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.ItemAttribute;
import com.babailiren.ec.repository.dao.ItemAttributeDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class ItemAttributeDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private ItemAttributeDao itemAttributeDao;
	
	@Test
	public void testUpdate() {
		ItemAttribute  itemAttribute = itemAttributeDao.getByPK(12);
		itemAttribute.setUpdatedAt(new Date());
		ItemAttribute[] itemAttributes = { itemAttribute };
		itemAttributeDao.update(itemAttributes);
	}
}
