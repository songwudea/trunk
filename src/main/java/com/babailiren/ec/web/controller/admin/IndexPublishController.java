package com.babailiren.ec.web.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.babailiren.ec.constants.Constants;
import com.babailiren.ec.model.PagePublish;
import com.babailiren.ec.model.SitePageConfig;
import com.babailiren.ec.service.PagePublishService;
import com.babailiren.ec.service.SitePageConfigService;
import com.babailiren.ec.web.session.BackSession;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/admin/indexpublish")
public class IndexPublishController {

	@Autowired
	private SitePageConfigService sitePageConfigService;
	
	@Autowired
	
	private PagePublishService pagePublishService;
	
	@RequestMapping(value = "edit.html", method = RequestMethod.POST)
	public String edit(String[] name_key, String[] entity_type,
			String[] id_key, HttpServletRequest request, Integer categoryId, String pageType) {
		BackSession backSession = (BackSession) request.getSession()
				.getAttribute(Constants.BACK_EMPLOYEE_SESSION);

		pagePublishService.delBySiteId(backSession.getSiteId(), categoryId);

		List<PagePublish> list = new ArrayList<PagePublish>();
		for (int i = 0; i < name_key.length; i++) {
			String name = name_key[i];
			String type = entity_type[i];
			String id = id_key[i];
			String names = request.getParameter(type + "_" + id + "_name");
			String ids = request.getParameter(type + "_" + id + "_id");
			PagePublish pagePublish = new PagePublish();
			pagePublish.setSiteId(backSession.getSiteId());
			pagePublish.setEntityName(names);
			if("Category".equals(pageType)) {
				pagePublish.setCategoryId(categoryId);
			}
			
			pagePublish.setNameKey(name);
			pagePublish.setEntityId(ids);
			pagePublish.setEntityType(type);
			if (names != null && !"".equals(names) && !"".equals(ids)
					&& ids != null) {
				list.add(pagePublish);
			}
		}
		pagePublishService.save(list);
		request.setAttribute("message", "首页配置成功.");
		return index(request, categoryId, pageType);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request, Integer categoryId, String pageType) {
		BackSession backSession = (BackSession) request.getSession()
				.getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		Integer siteId = backSession.getSiteId();
		
		List<SitePageConfig> sitePageConfigs = sitePageConfigService
				.findSitePageConfigBySiteId(siteId, pageType);
		List<PagePublish> pagePublishs = pagePublishService
				.findPagePublishs(siteId, categoryId);

		Gson gson = new GsonBuilder().serializeNulls().create();
		String sitePageConfigValues = gson.toJson(sitePageConfigs);
		String pagePublishValues = gson.toJson(pagePublishs);
		request.setAttribute("sitePageConfigValues", sitePageConfigValues);
		request.setAttribute("pagePublishValues", pagePublishValues);
		request.setAttribute("categoryId", categoryId);
		request.setAttribute("pageType", pageType);

		return "admin/indexpublish/edit";
	}

}
