package com.babailiren.repository.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.ItemCustomerAttribute;
import com.babailiren.ec.repository.dao.ItemCustomerAttributeDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class ItemCustomerAttributeDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private ItemCustomerAttributeDao itemCustomerAttributeDao;
	
	@Test
	public void testUpdate() {
		ItemCustomerAttribute  itemCustomerAttribute = itemCustomerAttributeDao.getByPK(12);
		itemCustomerAttribute.setUpdatedAt(new Date());
		ItemCustomerAttribute[] itemCustomerAttributes = { itemCustomerAttribute };
		itemCustomerAttributeDao.update(itemCustomerAttributes);
	}
}
