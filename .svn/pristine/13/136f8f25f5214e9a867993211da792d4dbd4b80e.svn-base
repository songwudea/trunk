package com.babailiren.ec.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.model.EmployeeSite;
import com.babailiren.ec.model.Site;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.EmployeeSiteService;
import com.babailiren.ec.service.SiteService;
import com.babailiren.ec.web.common.Pager;

@Controller
@RequestMapping("/admin/site")
public class SiteController {

	@Autowired
	private SiteService siteService;

	@Autowired
	private EmployeeSiteService employeeSiteService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "admin/site/index";
	}
	
	@RequestMapping(value = "editindexpage.html", method = RequestMethod.GET)
	public String editindexpage(Integer siteId, HttpServletRequest request) {
		request.setAttribute("siteId", siteId);
		Site site = siteService.getSite(siteId);
		request.setAttribute("model", site);
		return "admin/site/editindexpage";
	}
	
	@RequestMapping(value = "editindexpage.html", method = RequestMethod.POST)
	public String editindexpage(Integer siteId, String indexHtmlContent,HttpServletRequest request) {
		request.setAttribute("siteId", siteId);
		Site site = siteService.getSite(siteId);
		request.setAttribute("model", site);
		try {
			site.setIndexHtmlContent(indexHtmlContent);
			siteService.update(site);
			request.setAttribute("message", "首页静态页面编辑成功");
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "首页静态页面编辑失败");
		}
		
		return "admin/site/editindexpage";
	}
	
	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(Site site, Page<Site> page, HttpServletRequest request,
			HttpServletResponse response, Integer employeeId) {

		// 存放用户有权限的站点
		StringBuffer ids = new StringBuffer();
		if (employeeId != null) {
			List<EmployeeSite> employeeSites = employeeSiteService
					.findEmployeeSiteByEmployeeId(employeeId);
			for (int i = 0; i < employeeSites.size(); i++) {
				EmployeeSite employeeSite = employeeSites.get(i);
				ids.append(employeeSite.getSiteId());
				ids.append(",");
			}
		}
		page = siteService.list(page, site);
		List<Site> result = page.getResult();
		for (int i = 0; i < result.size(); i++) {
			if (ids.toString().contains(result.get(i).getId().toString())) {
				result.get(i).setAuthorize(true);
			} else {
				result.get(i).setAuthorize(false);
			}
		}
		return new Pager<Site>().getJsonPagerData(page);
	}
}
