package com.babailiren.ec.web.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.common.Validator;
import com.babailiren.ec.model.Menu;
import com.babailiren.ec.model.Privilege;
import com.babailiren.ec.model.Role;
import com.babailiren.ec.model.RolePrivilege;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.MenuService;
import com.babailiren.ec.service.PrivilegeService;
import com.babailiren.ec.service.RolePrivilegeService;
import com.babailiren.ec.service.RoleService;
import com.babailiren.ec.web.common.Pager;

@Controller
@RequestMapping("/admin/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private PrivilegeService privilegeService;

	@Autowired
	private RolePrivilegeService rolePrivilegeService;

	@Autowired
	private MenuService menuService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "admin/role/index";
	}

	@RequestMapping(value = "doEdit.html", method = RequestMethod.GET)
	public String doEdit(Role role, HttpServletRequest request) {
		if (role.getId() != null) {
			role = roleService.getRole(role.getId());
			request.setAttribute("model", role);
		}
		return "admin/role/edit";
	}

	@RequestMapping(value = "permissions.html", method = RequestMethod.POST)
	public String doPermissions(Integer roleId, Integer[] privilegeid,
			HttpServletRequest request) {
		rolePrivilegeService.deleteAll(roleId);
		List<RolePrivilege> list = new ArrayList<RolePrivilege>();
		
		if(privilegeid != null) {
			for (int i = 0; i < privilegeid.length; i++) {
				Integer pid = privilegeid[i];
				RolePrivilege rolePrivilege = new RolePrivilege();
				rolePrivilege.setCreatedAt(new Date());
				rolePrivilege.setUpdatedAt(new Date());
				rolePrivilege.setRoleId(roleId);
				rolePrivilege.setPrivilegeId(pid);
				list.add(rolePrivilege);
			}
			rolePrivilegeService.addAll(list.toArray(new RolePrivilege[0]));
		}
		request.setAttribute("message", "权限分配成功.");
		return permissions(roleId, request);
	}

	@RequestMapping(value = "permissions.html", method = RequestMethod.GET)
	public String permissions(Integer roleId, HttpServletRequest request) {
		Map<String, List<Privilege>> map = new HashMap<String, List<Privilege>>();
		List<Privilege> privileges = privilegeService.findAll();
		for (int i = 0; i < privileges.size(); i++) {
			Privilege privilege = privileges.get(i);
			Menu subMenu = menuService.getMenu(privilege.getMenuId());
			Menu parentMenu = menuService.getMenu(subMenu.getParentId());
			if (map.containsKey(parentMenu.getName() + ">" + subMenu.getName())) {
				map.get(parentMenu.getName() + ">" + subMenu.getName()).add(
						privilege);
			} else {
				List<Privilege> list = new ArrayList<Privilege>();
				list.add(privilege);
				map.put(parentMenu.getName() + ">" + subMenu.getName(), list);
			}
		}
		
		// 获取已经存在的权限
		List<RolePrivilege> rolePrivileges = rolePrivilegeService.findRolePrivileges(roleId);
		List<String> rolePrivilegeList = new ArrayList<String>();
		for(int i = 0;i < rolePrivileges.size();i++) {
			RolePrivilege rolePrivilege = rolePrivileges.get(i);
			rolePrivilegeList.add(String.valueOf(rolePrivilege.getPrivilegeId()));
		}
		
		request.setAttribute("roleId", roleId);
		request.setAttribute("privileges", map);
		request.setAttribute("rolePrivilegeList", rolePrivilegeList);
		return "admin/role/permissions";
	}

	@RequestMapping(value = "edit.html", method = RequestMethod.POST)
	public String edit(@ModelAttribute("role") Role role,
			HttpServletRequest request) {
		Validator validator = new Validator();
		validator.isNotBlankValidator(role.getName(), "请填写角色名")
				.isNotBlankValidator(role.getDescription(), "请填写角色描述");

		if (StringUtils.isNotEmpty(validator.renderHtmlMessage())) {
			request.setAttribute("message", validator.renderHtmlMessage());
		} else {
			if (role.getId() == null) {
				role.setCreatedAt(new Date());
				role.setUpdatedAt(new Date());
				roleService.save(role);
				request.setAttribute("message", "角色信息增加成功");
			} else {
				role.setUpdatedAt(new Date());
				roleService.update(role);
				request.setAttribute("message", "角色信息修改成功");
			}
		}
		return "admin/role/edit";
	}

	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(Role role, Page<Role> page, HttpServletRequest request,
			HttpServletResponse response) {
		page = roleService.list(page, role);
		return new Pager<Role>().getJsonPagerData(page);
	}
}
