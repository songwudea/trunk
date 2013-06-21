package com.babailiren.ec.web.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.babailiren.ec.common.Validator;
import com.babailiren.ec.constants.Constants;
import com.babailiren.ec.model.Employee;
import com.babailiren.ec.model.Site;
import com.babailiren.ec.service.EmployeeService;
import com.babailiren.ec.service.MenuService;
import com.babailiren.ec.service.SiteService;
import com.babailiren.ec.web.session.BackSession;
import com.babailiren.ec.web.vo.MenuVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private SiteService siteService;
	
	@RequestMapping(value = "index.html", method = RequestMethod.GET)
	public String index() {
		return "admin/test";
	}

	@RequestMapping(value = "login.html", method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping(value = "logout.html", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return login();
	}

	@RequestMapping(value = "chooseSite.html", method = RequestMethod.POST)
	public String chooseSite(Integer siteId, HttpServletRequest request) {
		Validator validator = new Validator();
		validator.isNotBlankValidator(siteId, "找管理员帮你分配个站点管理权限。");

		if (StringUtils.isNotEmpty(validator.renderHtmlMessage())) {
			request.setAttribute("message", validator.renderHtmlMessage());
			return "admin/choosesite";
		}
		BackSession backSession = (BackSession) request.getSession()
				.getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		backSession.setSiteId(siteId);

		Integer employeeId = backSession.getEmployeeId();
		List<MenuVo> menus = menuService.findMenusByEmployeeRoleId(employeeId);
		Gson gson = new GsonBuilder().create();
		Map<String, List<MenuVo>> map = new HashMap<String, List<MenuVo>>();
		map.put("menus", menus);
		System.out.println(gson.toJson(map));
		request.setAttribute("menus", gson.toJson(map));
		return "admin/index";
	}

	@RequestMapping(value = "login.html", method = RequestMethod.POST)
	public String login(String name, String password, HttpServletRequest request) {
		
		Validator validator = new Validator();
		validator.isNotBlankValidator(name, "请填写用户名")
				.isNotBlankValidator(password, "请填写用户密码");
		if (StringUtils.isNotEmpty(validator.renderHtmlMessage())) {
			request.setAttribute("message", validator.renderHtmlMessage());
			return "admin/login"; 
		} 
		
		
		List<Employee> list = employeeService.findEmployeeByNameAndPass(name,
				password);
		if (list != null && list.size() > 0) {
			Employee employee = list.get(0);
			// 获取该员工的站点
			List<Site> sites = siteService.findSiteByEmployeeId(employee
					.getId());
			request.setAttribute("sites", sites);
			BackSession backSession = new BackSession();
			backSession.setAccount(name);
			backSession.setEmployeeId(employee.getId());
			request.getSession().setAttribute(Constants.BACK_EMPLOYEE_SESSION,
					backSession);
			return "admin/choosesite";
		} else {
			request.setAttribute("message", "用户名或密码错误");
			return "admin/login";
		}
	}
}
