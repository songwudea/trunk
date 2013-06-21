package com.babailiren.repository.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Item;
import com.babailiren.ec.repository.dao.ItemDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class ItemDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private ItemDao itemDao;
	
	@Test
	public void testUpdate() {
		Item item = itemDao.getByPK(17);
		item.setUpdatedAt(new Date());
		Item[] items = { item };
		itemDao.update(items);
	}
}
