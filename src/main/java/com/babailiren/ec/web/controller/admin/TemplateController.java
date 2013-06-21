package com.babailiren.ec.web.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.model.SitePageConfig;
import com.babailiren.ec.model.Template;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.SitePageConfigService;
import com.babailiren.ec.service.TemplateService;
import com.babailiren.ec.web.common.Pager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
@RequestMapping("/admin/template")
public class TemplateController {
	
	@Autowired
	private TemplateService templateService;
	
	@Autowired
	private SitePageConfigService sitePageConfigService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "admin/template/index";
	}
	
	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(Template template, Page<Template> page) {
		page = templateService.list(page, template);
		return new Pager<Template>().getJsonPagerData(page);
	}
	
	@RequestMapping(value = "configcategory.html", method = RequestMethod.GET)
	public String configCategory(String pageType, Integer templateId, HttpServletRequest request) {
		List<SitePageConfig> sitePageConfigs = sitePageConfigService
				.findSitePageConfigBySiteId(templateId, pageType);
		Gson gson = new GsonBuilder().serializeNulls().create();
		request.setAttribute("sitePageConfigs", gson.toJson(sitePageConfigs));
		request.setAttribute("pageType", pageType);
		request.setAttribute("templateId", templateId);
		return "admin/template/configHomePage";
	}

	/**
	 * 配置首页
	 * @return
	 */
	@RequestMapping(value = "confighomepage.html", method = RequestMethod.GET)
	public String configHomePage(String pageType, Integer templateId, HttpServletRequest request) {
		List<SitePageConfig> sitePageConfigs = sitePageConfigService
				.findSitePageConfigBySiteId(templateId, pageType);
		Gson gson = new GsonBuilder().serializeNulls().create();
		request.setAttribute("sitePageConfigs", gson.toJson(sitePageConfigs));
		request.setAttribute("pageType", pageType);
		request.setAttribute("templateId", templateId);
		return "admin/template/configHomePage";
	}

	/**
	 * 配置首页
	 * @return
	 */
	@RequestMapping(value = "confighomepage.html", method = RequestMethod.POST)
	public String configHomePage(String pageType, Integer templateId, String[] nameKey,
			Integer[] quantity, String[] entityType, HttpServletRequest request) {
		// TODO 根据 siteId 删除 站点页面配置
		sitePageConfigService.delBySiteId(templateId, pageType);

		List<SitePageConfig> list = new ArrayList<SitePageConfig>();
		for (int i = 0; i < nameKey.length; i++) {
			String name = nameKey[i];
			String type = entityType[i];
			Integer count = quantity[i];
			if (name != null && !"".equals(name)) {
				SitePageConfig config = new SitePageConfig();
				config.setNameKey(name);
				config.setEntityType(type);
				config.setQuantity(count);
				config.setTemplateId(templateId);
				config.setPageType(pageType);
				list.add(config);
			}
		}
		sitePageConfigService.addAll(list);
		request.setAttribute("message", "首页属性配置成功.");
		return configHomePage(pageType, templateId, request);
	}
}
