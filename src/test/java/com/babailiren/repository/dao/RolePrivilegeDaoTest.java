package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.RolePrivilege;
import com.babailiren.ec.repository.dao.RolePrivilegeDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class RolePrivilegeDaoTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private RolePrivilegeDao rolePrivilegeDao;
	
	
	@Test
	public void testUpdate() {
		RolePrivilege e = new RolePrivilege();
		e.setId(1);
		e.setPrivilegeId(1);
		RolePrivilege[] es = {e};
		
		rolePrivilegeDao.update(es);
		
	}
}
