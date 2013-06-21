package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Privilege;
import com.babailiren.ec.repository.dao.PrivilegeDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class PrivilegeDaoTest  extends AbstractJUnit4SpringContextTests {

	@Autowired
	private PrivilegeDao privilegeDao;
	
	
	@Test
	public void testUpdate() {
		Privilege e = new Privilege();
		e.setId(1);
		e.setDescription("123");
		Privilege[] es = {e};
		
		privilegeDao.update(es);
		
	}
}
