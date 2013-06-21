package com.babailiren.ec.web.controller.admin;

import java.util.Date;

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
import com.babailiren.ec.constants.Constants;
import com.babailiren.ec.model.Link;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.LinkService;
import com.babailiren.ec.web.common.Pager;
import com.babailiren.ec.web.session.BackSession;

@Controller
@RequestMapping("/admin/link")
public class LinkController {

	@Autowired
	private LinkService linkService;
	
	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(Link link, Page<Link> page, HttpServletRequest request,
			HttpServletResponse response) {
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		Integer siteId = backSession.getSiteId();
		link.setSiteId(siteId);
		Page<Link> list = linkService.findLinkBySiteId(page, link);
		return new Pager<Link>().getJsonPagerData(list);
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "admin/link/index";
	}
	
	
	@RequestMapping(value = "edit.html", method = RequestMethod.POST)
	public String edit(@ModelAttribute("link") Link link,HttpServletRequest request) {
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		Validator validator = new Validator();
		validator.isNotBlankValidator(link.getLinkUrl(), "请填写链接URL");
		validator.isNotBlankValidator(link.getLinkText(), "请填写链接文本");
		if (StringUtils.isNotEmpty(validator.renderHtmlMessage())) {
			request.setAttribute("message", validator.renderHtmlMessage());
		} else {
			if(link.getId() == null) {
				link.setSiteId(backSession.getSiteId());
				link.setCreatedAt(new Date());
				link.setUpdatedAt(new Date());
				linkService.save(link);
				request.setAttribute("message", "链接信息增加成功");
			} else {
				link.setUpdatedAt(new Date());
				link.setSiteId(backSession.getSiteId());
				linkService.update(link);
				request.setAttribute("message", "链接信息更新成功");
			}
		}		
		return "admin/link/edit";
	}
	
	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public String edit(Integer id, HttpServletRequest request) {
		if (id != null) {
			Link link = linkService.getByPK(id);
			request.setAttribute("model", link);
		}
		return "admin/link/edit";
	}
}
