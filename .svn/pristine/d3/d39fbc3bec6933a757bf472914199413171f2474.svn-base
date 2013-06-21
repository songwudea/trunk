package com.babailiren.ec.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.constants.Constants;
import com.babailiren.ec.service.MenuService;
import com.babailiren.ec.web.session.BackSession;
import com.babailiren.ec.web.vo.MenuVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/admin/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(HttpServletRequest request) {
		// 利用该员工的角色获取权限再后去菜单
		BackSession backSession = (BackSession) request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		Integer employeeId = backSession.getEmployeeId();
		List<MenuVo> menus = menuService.findMenusByEmployeeRoleId(employeeId);
		Gson gson = new GsonBuilder().serializeNulls().create();
		System.out.println(gson.toJson(menus));
		return gson.toJson(menus);
	}
}
