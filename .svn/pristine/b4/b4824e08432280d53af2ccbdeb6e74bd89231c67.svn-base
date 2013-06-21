package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Employee;
import com.babailiren.ec.repository.dao.EmployeeDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class EmployeeDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Test
	public void testUpdate() {
		Employee employee = employeeDao.getByPK(3);
		employee.setName("徐昂1");
		Employee[] employees = { employee };
		employeeDao.update(employees);
	}
}
