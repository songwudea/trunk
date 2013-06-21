package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Employee;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "employees")
public class EmployeeDao extends  JdbcEntityDao<Employee, Integer>  {
	
	public List<Employee> findEmployeeByNameAndPass(String account, String password) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from employees where 1 =1  ");
		sb.append(" and employees.account = ? ");
		sb.append(" and employees.password = ? ");
		return find(sb.toString(), account, password);
	}
	
	public Employee getEmployeeByAccount(String account) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from employees where 1 = 1 ");
		sb.append(" and employees.account = ? ");
		return get(sb.toString(), account);
	}

	public Page<Employee> findEmployeePage(Page<Employee> page, Employee employee, Integer siteId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from employees ");
//		sb.append(" left join employee_site on employee_site.employee_id = employees.id ");
//		sb.append(" where employee_site.site_id = ? ");
		page = findPage(page, sb.toString());
		return page;
	}
	
}
