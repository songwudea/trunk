package com.babailiren.ec.web.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.MenuService;
import com.babailiren.ec.service.PrivilegeService;
import com.babailiren.ec.web.common.Pager;

@Controller
@RequestMapping("/admin/privilege")
public class PrivilegeController {
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(){
		return "admin/privilege/index";
	}
	
	@RequestMapping(value = "edit.html", method = RequestMethod.POST)
	public String edit(@ModelAttribute("privilege") Privilege privilege,
			HttpServletRequest request) {
		Validator validator = new Validator();
		validator.isNotBlankValidator(privilege.getName(), "请填写模块名")
				 .isNotBlankValidator(privilege.getDescription(), "请填写模块描述")
				 .isNotBlankValidator(privilege.getCode(), "请填写模块代码");

		if (StringUtils.isNotEmpty(validator.renderHtmlMessage())) {
			request.setAttribute("message", validator.renderHtmlMessage());
		} else {
			if (privilege.getId() == null) {
				privilege.setCreatedAt(new Date());
				privilege.setUpdatedAt(new Date());
				privilegeService.save(privilege);
				request.setAttribute("message", "用户信息增加成功");
			} else {
				privilege.setUpdatedAt(new Date());
				privilegeService.update(privilege);
				request.setAttribute("message", "用户信息修改成功");
			}
		}
		return "admin/privilege/edit";
	}
	
	@RequestMapping(value = "doEdit.html", method = RequestMethod.GET)
	public String doEdit(Privilege privilege, HttpServletRequest request) {
		List<Menu> parentMenus = menuService.findParentMenus();
		List<Menu> menus = new ArrayList<Menu>();
		
		for(int i = 0; i < parentMenus.size(); i++) {
			Menu parentMenu = parentMenus.get(i);
			List<Menu> subMenus = menuService.findSubMenus(parentMenu.getId());
			for(int j = 0;j < subMenus.size(); j++) {
				Menu menu = new Menu();
				menu.setName(parentMenu.getName() + ">" + subMenus.get(j).getName());
				menu.setId(subMenus.get(j).getId());
				menus.add(menu);
			}
		}
		request.setAttribute("menus", menus);
		
		if(privilege.getId() != null) {
			privilege = privilegeService.getPrivilege(privilege.getId());
			request.setAttribute("model", privilege);
		}
		return "admin/privilege/edit";
	}
	
	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody String list(Privilege privilege,Page<Privilege> page,
			HttpServletRequest request, HttpServletResponse response) {
		page = privilegeService.list(page, privilege);
		return new Pager<Privilege>().getJsonPagerData(page);
	}
	
	@RequestMapping(value = "delete.html", method = RequestMethod.POST)
	public @ResponseBody
	String delete(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		privilegeService.delete(id);
		return "suss";
	}
}
