package com.babailiren.ec.web.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.babailiren.ec.model.Content;
import com.babailiren.ec.model.Site;
import com.babailiren.ec.service.ContentService;
import com.babailiren.ec.web.common.WebCache;
import com.babailiren.ec.web.common.WebUtils;

@Controller
@RequestMapping("/content")
public class NewsController {
	

	@Autowired
	private WebCache webCache;
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping(value = "/info/{contentPath}.html", method = RequestMethod.GET)
	public String detail1(HttpServletRequest request,HttpServletResponse response, String site,
			@PathVariable String contentPath) {
		ServletContext servletContext = request.getSession().getServletContext();
		Site currentSite = webCache.getSiteByDomain(servletContext, site);
		Integer parentId = 0;
		Integer id = 0;
		List<Content> list = null;
		Content content = contentService.getContentByPath(contentPath);
		if(content != null){
			parentId = content.getParentId();
		}
		
		Content parent = contentService.getByPK(parentId);
		
		if(parent != null){
			// 获取列表
			list =contentService.treeContent(content.getId());
			id = parent.getParentId();
		}
		
		if (content != null && !"".equals(parentId) && id != 0) {
			parent = contentService.getByPK(parentId);
			parentId = parent.getParentId();
			parent = contentService.getByPK(id);
		}
		
		//通过parentId查询出所有的列表
		List<Content> contentList =contentService.treeContent(parentId);
		if (contentList != null && contentList.size()>0) {
			request.setAttribute("contentList", contentList);
			request.setAttribute("title", contentList.get(0).getTitle());
		}
		
		// 补个逻辑
		
		request.setAttribute("seconds", list);
		request.setAttribute("details", contentList);
		request.setAttribute("content", content);
		request.setAttribute("parent", parent);
		return WebUtils.themesView(request, currentSite, "content/detail1");
	}
	

	@RequestMapping(value = "{contentPath}.html", method = RequestMethod.GET)
	public String detail(HttpServletRequest request,HttpServletResponse response, String site,
			@PathVariable String contentPath) {
		ServletContext servletContext = request.getSession().getServletContext();
		Site currentSite = webCache.getSiteByDomain(servletContext, site);
		Integer parentId = 0;
		Integer id = 0;
		Content content = contentService.getContentByPath(contentPath);
		if(content != null){
			parentId = content.getParentId();
		}
		
		Content parent = contentService.getByPK(parentId);
		
		if(parent != null){
			// 获取列表
			List<Content> contentList =contentService.treeContent(content.getId());
			
			
			id = parent.getParentId();
		}
		
		if (content != null && !"".equals(parentId) && id != 0) {
			parent = contentService.getByPK(parentId);
			parentId = parent.getParentId();
			parent = contentService.getByPK(id);
		}
		
		//通过parentId查询出所有的列表
		List<Content> contentList =contentService.treeContent(parentId);
		if (contentList != null && contentList.size()>0) {
			request.setAttribute("contentList", contentList);
			request.setAttribute("title", contentList.get(0).getTitle());
		}
		
		// 补个逻辑
		
		request.setAttribute("details", contentList);
		request.setAttribute("content", content);
		request.setAttribute("parent", parent);
		return WebUtils.themesView(request, currentSite, "content/detail");
	}
	
	
	@RequestMapping(value = "brand_story.html", method = RequestMethod.GET)
	public String story(HttpServletRequest request,HttpServletResponse response, String site) {
		ServletContext servletContext = request.getSession().getServletContext();
		Site currentSite = webCache.getSiteByDomain(servletContext, site);

		
		return WebUtils.themesView(request, currentSite, "content/brand_story");
	}
	

}
