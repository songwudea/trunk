package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.RolePrivilege;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table = "role_privilege")
public class RolePrivilegeDao extends JdbcEntityDao<RolePrivilege, Integer> {

	public void deleteAll(Integer roleId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" delete from role_privilege where role_privilege.role_id = '");
		sb.append(roleId);
		sb.append("'");
		getJdbcTemplate().execute(sb.toString());
	}

	public List<RolePrivilege> findRolePrivilegeByRoleId(Integer roleId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from role_privilege where role_privilege.role_id = ? ");
		return find(sb.toString(), roleId);
	}
}
