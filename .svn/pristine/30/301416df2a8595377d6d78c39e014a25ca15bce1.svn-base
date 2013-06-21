package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Role;
import com.babailiren.ec.repository.dao.RoleDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class RoleDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private RoleDao roleDao;
	
	@Test
	public void testUpdate() {
		Role e = new Role();
		e.setId(1);
		e.setName("123");
		Role[] es = {e};
		
		roleDao.update(es);
		
	}
}
