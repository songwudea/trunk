package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Menu;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table = "menus")
public class MenuDao extends JdbcEntityDao<Menu, Integer> {
	
	public List<Menu> findSubMenus(Integer parentId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from menus where menus.parent_id = ? ");
		return find(sb.toString(), parentId);
	}
	
	public List<Menu> findParentMenus() {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from menus where menus.parent_id is null and url is null ");
		return find(sb.toString());
	}
	
	/**
	 * 根据 员工id和父菜单id 获取子菜单
	 * @param employeeId
	 * @param parentId
	 * @return List
	 */
	public List<Menu> findMenusByEmployeeRoleId(Integer employeeId, Integer parentId) {
		StringBuffer sb = new StringBuffer(" select menus.* from menus ");
		sb.append(" left join `privileges` on `privileges`.menu_id = menus.id ");
		sb.append(" left join role_privilege on role_privilege.privilege_id = `privileges`.id ");
		sb.append(" left join employee_role on employee_role.role_id = role_privilege.role_id ");
		sb.append(" where employee_role.employee_id = ? and menus.parent_id = ? group by menus.id ");
		return find(sb.toString(), employeeId, parentId);
	}
}
