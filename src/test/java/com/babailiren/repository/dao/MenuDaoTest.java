package com.babailiren.repository.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Menu;
import com.babailiren.ec.repository.dao.MenuDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class MenuDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private MenuDao menuDao;
	
	@Test
	public void testUpdate() {
		Menu menu = menuDao.getByPK(1);
		menu.setUpdatedAt(new Date());
		Menu[] menus = { menu };
		menuDao.update(menus);
	}
}
