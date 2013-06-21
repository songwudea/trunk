package com.babailiren.ec.web.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.common.Validator;
import com.babailiren.ec.constants.Constants;
import com.babailiren.ec.model.Employee;
import com.babailiren.ec.model.EmployeeRole;
import com.babailiren.ec.model.EmployeeSite;
import com.babailiren.ec.model.Role;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.EmployeeRoleService;
import com.babailiren.ec.service.EmployeeService;
import com.babailiren.ec.service.EmployeeSiteService;
import com.babailiren.ec.service.RoleService;
import com.babailiren.ec.web.common.Pager;
import com.babailiren.ec.web.session.BackSession;

@Controller
@RequestMapping("/admin/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRoleService employeeRoleService;

	@Autowired
	private EmployeeSiteService employeeSiteService;

	@Autowired
	private RoleService roleService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "admin/employee/index";
	}

	@RequestMapping(value = "cancelSite.html", method = RequestMethod.POST)
	public @ResponseBody
	String cancelSite(Integer employeeId, String siteIds,
			HttpServletRequest request) {
		try {
			String[] vals = siteIds.split(",");
			for (int i = 0; i < vals.length; i++) {
				employeeSiteService.delete(employeeId, Integer
						.parseInt(vals[i]));
			}
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}

	/**
	 * 分配站点
	 * 
	 * @param employeeId
	 * @param siteId
	 * @return
	 */
	@RequestMapping(value = "assortSite.html", method = RequestMethod.POST)
	public @ResponseBody
	String assortSite(Integer employeeId, String siteIds,
			HttpServletRequest request) {
		try {
			String[] vals = siteIds.split(",");
			List<EmployeeSite> list = new ArrayList<EmployeeSite>();
			for (int i = 0; i < vals.length; i++) {
				EmployeeSite employeeSite = new EmployeeSite();
				employeeSite.setEmployeeId(employeeId);
				employeeSite.setSiteId(Integer.parseInt(vals[i]));
				list.add(employeeSite);
			}
			employeeSiteService.saveAll(list);
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}

	/**
	 * 分配站点
	 */
	@RequestMapping(value = "assortSite.html", method = RequestMethod.GET)
	public String assortSite(Integer employeeId, HttpServletRequest request) {
		request.setAttribute("employeeId", employeeId);
		return "admin/employee/assortSite";
	}

	@RequestMapping(value = "doEmployeerole.html", method = RequestMethod.GET)
	public String doEmployeeRole(Integer employeeId, HttpServletRequest request) {
		List<Role> roles = roleService.findRoles();
		List<EmployeeRole> employeeRoles = employeeRoleService
				.findEmployeeRoleByEid(employeeId);

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < employeeRoles.size(); i++) {
			list.add(employeeRoles.get(i).getRoleId() + "");
		}
		request.setAttribute("employeeRoles", list);
		request.setAttribute("roles", roles);
		request.setAttribute("employeeId", employeeId);
		return "admin/employee/employeerole";
	}

	@RequestMapping(value = "employeeRole.html", method = RequestMethod.POST)
	public String employeeRole(Integer employeeId, Integer[] roleId,
			HttpServletRequest request) {
		employeeRoleService.deleteByEid(employeeId);

		List<EmployeeRole> list = new ArrayList<EmployeeRole>();
		if (roleId != null) {
			for (int i = 0; i < roleId.length; i++) {
				Integer rid = roleId[i];
				EmployeeRole employeeRole = new EmployeeRole();
				employeeRole.setCreatedAt(new Date());
				employeeRole.setUpdatedAt(new Date());
				employeeRole.setRoleId(rid);
				employeeRole.setEmployeeId(employeeId);
				list.add(employeeRole);
			}
			employeeRoleService.addAll(list.toArray(new EmployeeRole[0]));
		}
		request.setAttribute("message", "角色分配成功.");
		return doEmployeeRole(employeeId, request);
	}

	@RequestMapping(value = "doEdit.html", method = RequestMethod.GET)
	public String doEdit(Employee employee, HttpServletRequest request) {
		if (employee.getId() != null) {
			employee = employeeService.getEmployee(employee.getId());
			request.setAttribute("model", employee);
		}
		return "admin/employee/edit";
	}

	@RequestMapping(value = "edit.html", method = RequestMethod.POST)
	public String edit(@ModelAttribute("employee") Employee employee,
			HttpServletRequest request) {
		Validator validator = new Validator();
		validator.isNotBlankValidator(employee.getAccount(), "请填写用户名")
				 .isNotBlankValidator(employee.getDepartment(), "轻填写部门")
				 .isNotBlankValidator(employee.getEmail(), "请填写邮件")
				 .isNotBlankValidator(employee.getMobile(), "请填写手机号码")
			 	 .isNotBlankValidator(employee.getPassword(), "请填写用户密码");
		// check user name
		if(employee.getId() == null) {
			if(employeeService.getEmployeeByAccount(employee.getAccount()) != null) {
				validator.expressionValidator(true, "用户账户不能重复");
			}
		}

		if (StringUtils.isNotEmpty(validator.renderHtmlMessage())) {
			request.setAttribute("message", validator.renderHtmlMessage());
		} else {
			if (employee.getId() == null) {
				employee.setCreatedAt(new Date());
				employee.setUpdatedAt(new Date());
				employeeService.save(employee);
				request.setAttribute("message", "用户信息增加成功");
			} else {
				employee.setUpdatedAt(new Date());
				employeeService.update(employee);
				request.setAttribute("message", "用户信息修改成功");
			}
		}
		return "admin/employee/edit";
	}

	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(Employee employee, Page<Employee> page, HttpServletRequest request) {
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		page = employeeService.list(page, employee, backSession.getSiteId());
		return new Pager<Employee>().getJsonPagerData(page);
	}
}
