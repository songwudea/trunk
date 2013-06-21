package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.EmployeeRole;
import com.babailiren.ec.repository.dao.EmployeeRoleDao;

@Service
public class EmployeeRoleService {
	
	@Autowired
	private EmployeeRoleDao employeeRoleDao;
	
	public List<EmployeeRole> findEmployeeRoleByEid(Integer id) {
		return employeeRoleDao.findEmployeeRolesByEid(id);
	}
	
	public void deleteByEid(Integer id) {
		employeeRoleDao.deleteByEid(id);
	}
	
	public void addAll(EmployeeRole[]entities) {
		employeeRoleDao.add(entities);
	}
}
