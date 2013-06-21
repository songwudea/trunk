package com.babailiren.ec.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.babailiren.ec.model.Site;
import com.babailiren.ec.web.common.WebCache;
import com.babailiren.ec.web.common.WebUtils;

@Controller
@RequestMapping("/part")
public class PartialController {

	@Autowired
	private WebCache webCache;
	
	@RequestMapping(value = "{part}.html")
	public String part(HttpServletRequest request,String site, @PathVariable String part){
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		return WebUtils.themesView(request,currentSite,part);
	}
	
}
