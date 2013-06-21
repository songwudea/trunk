package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Employee;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public Page<Employee> list(Page<Employee> page, Employee address, Integer siteId) {
		return employeeDao.findEmployeePage(page, address, siteId);
	}
	
	public List<Employee> findEmployeeByNameAndPass(String account, String password) {
		return employeeDao.findEmployeeByNameAndPass(account, password);
	}
	
	public Employee getEmployee(Integer employeeId) {
		return employeeDao.getByPK(employeeId);
	}
	
	public void delete (Integer id) {
		employeeDao.delete(id);
	}
	
	public void save(Employee entity) {
		employeeDao.add(entity);
	}
	
	public Employee getEmployeeByAccount(String account) {
		return employeeDao.getEmployeeByAccount(account);
	}
	
	public void update(Employee entity) {
		Employee[]entities = {entity};
		employeeDao.update(entities);
	}
	
}
