package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.EmployeeSite;
import com.babailiren.ec.repository.dao.EmployeeSiteDao;

@Service
public class EmployeeSiteService {

	@Autowired
	private EmployeeSiteDao employeeSiteDao;
	
	public List<EmployeeSite> findEmployeeSiteByEmployeeId(Integer employeeId) {
		return employeeSiteDao.findEmployeeSiteByEmployeeId(employeeId);
	}
	
	public void saveAll(List<EmployeeSite> list) {
		employeeSiteDao.add(list.toArray(new EmployeeSite[0]));
	}
	
	public void delete(Integer employeeId, Integer siteId) {
		employeeSiteDao.delete(employeeId, siteId);
	}
	
}
