package com.babailiren.ec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Menu;
import com.babailiren.ec.repository.dao.MenuDao;
import com.babailiren.ec.web.vo.MenuVo;

@Service
public class MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	/**
	 * 根据权限获取菜单
	 * @param employeeId
	 * @return
	 */
	public List<MenuVo> findMenusByEmployeeRoleId(Integer employeeId) {
		// 获取所有父类菜单
		List<Menu> parentMenus = menuDao.findParentMenus();
		List<MenuVo> menus = new ArrayList<MenuVo>();
		
		// 循环父菜单
		for(int i = 0;i < parentMenus.size(); i++) {
			Menu parentMenu = parentMenus.get(i);
			List<Menu> subMenus = menuDao.findMenusByEmployeeRoleId(employeeId, parentMenu.getId());
			if(subMenus != null && subMenus.size() > 0) {
				MenuVo parentMenuVO = new MenuVo();
				parentMenuVO.setIcon("icon-sys");
				parentMenuVO.setMenuid(parentMenu.getId());
				parentMenuVO.setMenuname(parentMenu.getName());
				parentMenuVO.setUrl(parentMenu.getUrl());
				for(int j = 0;j < subMenus.size(); j++) {
					Menu subMenu = subMenus.get(j);
					MenuVo subMenuVO = new MenuVo();
					subMenuVO.setIcon("icon-role");
					subMenuVO.setMenuid(subMenu.getId());
					subMenuVO.setMenuname(subMenu.getName());
					subMenuVO.setUrl(subMenu.getUrl());
					parentMenuVO.getMenus().add(subMenuVO);
				}
				menus.add(parentMenuVO);
			}
		}
		return menus;
	}
	
	public List<Menu> findSubMenus(Integer parentId) {
		return menuDao.findSubMenus(parentId);
	}
	
	public List<Menu> findParentMenus() {
		return menuDao.findParentMenus();
	}
	
	public Menu getMenu(Integer id) {
		return menuDao.getByPK(id);
	}

}
