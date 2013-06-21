package com.babailiren.repository.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.EmployeeRole;
import com.babailiren.ec.model.EmployeeSite;
import com.babailiren.ec.repository.dao.EmployeeSiteDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class EmployeeSiteDaoTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private EmployeeSiteDao employeeSiteDao;
	
	@Test
	public void testUpdate() {
//		EmployeeSite  employeeSite = employeeSiteDao.getByPK(12);
//		employeeSite.setUpdatedAt(new Date());
//		EmployeeRole[] employeeRoles = { employeeRole };
//		employeeRoleDao.update(employeeRoles);
	}

}
