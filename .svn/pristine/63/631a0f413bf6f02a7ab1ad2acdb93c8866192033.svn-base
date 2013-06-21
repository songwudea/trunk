package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Privilege;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.PrivilegeDao;

@Service
public class PrivilegeService {

	@Autowired
	private PrivilegeDao privilegeDao;
	
	public List<Privilege> findAll() {
		return privilegeDao.findAll();
	}
	
	public Page<Privilege> list(Page<Privilege> page, Privilege privilege) {
		return privilegeDao.findPrivilegePage(page, privilege);
	}
	
	public Privilege getPrivilege(Integer privilegeId) {
		return privilegeDao.getByPK(privilegeId);
	}
	
	public void delete (Integer id) {
		privilegeDao.delete(id);
	}
	
	public void save(Privilege entity) {
		privilegeDao.add(entity);
	}
	
	public void update(Privilege entity) {
		Privilege[] entities = {entity};
		privilegeDao.update(entities);
	}
}
