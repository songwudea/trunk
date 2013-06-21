package com.babailiren.ec.repository.dao;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Privilege;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "privileges")
public class PrivilegeDao extends JdbcEntityDao<Privilege, Integer> {
	
	public Page<Privilege> findPrivilegePage(Page<Privilege> page, Privilege privilege) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select privileges.*,menus.name as module_name from privileges ");
		sb.append(" left join menus on menus.id = privileges.menu_id ");
		sb.append(" where 1 = 1 ");
		if (privilege.getId() != null) {
			sb.append(" and id = '" + privilege.getId() + "'");
		}
		page = findPage(page, sb.toString());
		return page;
	}
	
}