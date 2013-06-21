package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.EmployeeSite;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table = "employee_site")
public class EmployeeSiteDao extends JdbcEntityDao<EmployeeSite, Integer> {
	
	public List<EmployeeSite> findEmployeeSiteByEmployeeId(Integer employeeId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from employee_site where employee_site.employee_id = ? ");
		return find(sb.toString(), employeeId);
	}
	
	public void delete(Integer employeeId, Integer siteId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" delete from employee_site where employee_site.employee_id = ? and employee_site.site_id = ? ");
		getJdbcTemplate().update(sb.toString(), employeeId, siteId);
	}
	
	
}
