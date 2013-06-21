package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.RolePrivilege;
import com.babailiren.ec.repository.dao.RolePrivilegeDao;

@Service
public class RolePrivilegeService {
	
	@Autowired
	private RolePrivilegeDao rolePrivilegeDao;
	
	public void deleteAll(Integer roleId) {
		rolePrivilegeDao.deleteAll(roleId);
	}
	
	public void addAll(RolePrivilege[]entities) {
		rolePrivilegeDao.add(entities);
	}
	
	public List<RolePrivilege> findRolePrivileges(Integer roleId) {
		return rolePrivilegeDao.findRolePrivilegeByRoleId(roleId);
	}
}
