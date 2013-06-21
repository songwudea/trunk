package com.babailiren.repository.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.EmployeeRole;
import com.babailiren.ec.repository.dao.EmployeeRoleDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class EmployeeRoleDaoTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private EmployeeRoleDao employeeRoleDao;
	
	@Test
	public void testUpdate() {
		EmployeeRole  employeeRole = employeeRoleDao.getByPK(12);
		employeeRole.setUpdatedAt(new Date());
		EmployeeRole[] employeeRoles = { employeeRole };
		employeeRoleDao.update(employeeRoles);
	}
}
