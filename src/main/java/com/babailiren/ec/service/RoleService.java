package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Role;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.RoleDao;

@Service
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;
	
	public Page<Role> list(Page<Role> page, Role role) {
		return roleDao.findRolePage(page, role);
	}
	
	public List<Role> findRoles() {
		return roleDao.findAll();
	}
	
	public Role getRole(Integer roleId) {
		return roleDao.getByPK(roleId);
	}
	
	public void delete (Integer id) {
		roleDao.delete(id);
	}
	
	public void save(Role entity) {
		roleDao.add(entity);
	}
	
	public void update(Role entity) {
		Role[]entities = {entity};
		roleDao.update(entities);
	}
}
