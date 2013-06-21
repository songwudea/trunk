package com.babailiren.ec.repository.dao;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Role;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "roles")
public class RoleDao extends JdbcEntityDao<Role, Integer> {

	public Page<Role> findRolePage(Page<Role> page, Role role) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from roles where 1 = 1 ");
		if (role.getId() != null) {
			sb.append(" and id = '" + role.getId() + "'");
		}
		page = findPage(page, sb.toString());
		return page;
	}
	
}