package com.babailiren.ec.web.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.common.Validator;
import com.babailiren.ec.constants.Constants;
import com.babailiren.ec.model.Content;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.ContentService;
import com.babailiren.ec.web.common.Pager;
import com.babailiren.ec.web.session.BackSession;

@Controller
@RequestMapping("/admin/content")
public class ContentController {

	@Autowired
	private ContentService contentService;

	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(Content content, String parentId, Page<Content> page,
			HttpServletRequest request, HttpServletResponse response) {
		if (parentId == null || "".equals("")) {
			parentId = "0";
		}
		Page<Content> list = contentService.list(page, parentId);
		return new Pager<Content>().getJsonPagerData(list);
	}

	@RequestMapping(value = "list2.html", method = RequestMethod.GET)
	public String list2() {
		return "admin/content/index";
	}
	@RequestMapping(value = "list2.html", method = RequestMethod.POST)
	public @ResponseBody
	String listChild(Content content, String parentId, Page<Content> page,
			HttpServletRequest request, HttpServletResponse response) {
		Page<Content> list = contentService.list(page, parentId);
		return new Pager<Content>().getJsonPagerData(list);
	}
	@RequestMapping(value = "list1.html", method = RequestMethod.POST)
	public @ResponseBody
	String list1(Content content, Page<Content> page,
			HttpServletRequest request, HttpServletResponse response) {
		BackSession backSession = (BackSession) request.getSession()
				.getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		Integer siteId = backSession.getSiteId();
		content.setSiteId(siteId);
		Page<Content> list = contentService.findContentBySiteId(page, content);
		return new Pager<Content>().getJsonPagerData(list);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "admin/content/indexP";
	}

	@RequestMapping(value = "edit.html", method = RequestMethod.POST)
	public String edit(@ModelAttribute("content") Content content,
			HttpServletRequest request) {
		Validator validator = new Validator();
		validator.isNotBlankValidator(content.getTitle(), "请填写标题");

		if (StringUtils.isNotEmpty(validator.renderHtmlMessage())) {
			request.setAttribute("message", validator.renderHtmlMessage());
		} else {
			BackSession backSession = (BackSession) request.getSession()
					.getAttribute(Constants.BACK_EMPLOYEE_SESSION);
			Integer siteId = backSession.getSiteId();

			if (content.getId() == null) {
				content.setHitCounter(0);
				content.setSiteId(siteId);
				content.setCreatedAt(new Date());
				content.setUpdatedAt(new Date());
				content.setParentId(content.getTypeId());
				contentService.save(content);
				request.setAttribute("message", "内容增加成功");
			} else {
				content.setSiteId(siteId);
				content.setUpdatedAt(new Date());
				contentService.update(content);
				request.setAttribute("message", "内容修改成功");
			}
		}
		if (content.getParentId()==0) {
			return "admin/content/editP";
		}else{
			return "admin/content/edit";
		}
	}

	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public String edit(Integer id, Integer parentId, HttpServletRequest request) {
		BackSession backSession = (BackSession) request.getSession()
				.getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		Integer siteId = backSession.getSiteId();
		List<Content> contents = contentService.findParentContent(siteId,id);
		request.setAttribute("contents", contents);
		///新增还是修改
		Content content=null;
		if(id == null && parentId == 0){
			content = new Content();
			content.setTypeId(parentId);
			content.setParentId(parentId);
			content.setPublished(true);
			content.setHitCounter(0);
			request.setAttribute("model", content);
			return "admin/content/editP";
		}else if (id != null) {
			//修改，根据id查询是修改目录还是修改文章
			content = contentService.getByPK(id);
			request.setAttribute("model", content);
			if (0==content.getParentId()) {
				return "admin/content/editP";
			}
		} else if (parentId != null) {
			content = new Content();
			content.setTypeId(parentId);
			request.setAttribute("model", content);
		}
		return "admin/content/edit";
	}
	
	@RequestMapping(value = "delete.html", method = RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response, Integer id) {
		//根据id来删除，如果有只目录的话  要级联删除
		//查询有没有子目录
		StringBuffer str = new StringBuffer();
		if (id != null && !"".equals(id)) {
			str.append(id);
			List<Content> contentList =contentService.findChildById(id);
			if (contentList != null && contentList.size()>0) {
				for (int i = 0; i < contentList.size(); i++) {
					str.append(",");
					str.append(contentList.get(i).getId());
				}
			}
			contentService.delete(str.toString());
		}
		return "suss";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

}
