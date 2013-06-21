package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.EmployeeRole;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table = "employee_role")
public class EmployeeRoleDao extends  JdbcEntityDao<EmployeeRole, Integer>  {
	
	public List<EmployeeRole> findEmployeeRolesByEid(Integer id) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from employee_role where employee_role.employee_id = ? ");
		return find(sb.toString(), id);
	}

	public void deleteByEid(Integer id) {
		StringBuffer sb = new StringBuffer();
		sb.append(" delete from employee_role where employee_role.employee_id = '");
		sb.append(id);
		sb.append("' ");
		getJdbcTemplate().execute(sb.toString());
	}
}
