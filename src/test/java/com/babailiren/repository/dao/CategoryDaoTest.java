package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Category;
import com.babailiren.ec.repository.dao.CategoryDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class CategoryDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private CategoryDao categoryDao;

	@Test
	public void testUpdate() {
		Category category = categoryDao.getByPK(1);
		Category[] categories = { category };
		category.setName("似水明眸系列");
		categoryDao.update(categories);
	}
}
