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
import com.babailiren.ec.model.ContentType;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.ContentTypeService;
import com.babailiren.ec.web.common.Pager;

@Controller
@RequestMapping("/admin/contentType")
public class ContentTypeController {

	@Autowired
	private ContentTypeService contentTypeService;
	
	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	@ResponseBody
	public String list(ContentType contentType, Page<ContentType> page, HttpServletRequest request,
			HttpServletResponse response) {
		Page<ContentType> list = contentTypeService.list(page, contentType);
		return new Pager<ContentType>().getJsonPagerData(list);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "admin/contentType/index";
	}
	
	
	@RequestMapping(value = "edit.html", method = RequestMethod.POST)
	public String edit(@ModelAttribute("contentType") ContentType contentType,HttpServletRequest request) {
		Validator validator = new Validator();
		validator.isNotBlankValidator(contentType.getName(), "请填写类型名称");

		if (StringUtils.isNotEmpty(validator.renderHtmlMessage())) {
			request.setAttribute("message", validator.renderHtmlMessage());
		} else {
			if (contentType.getId() == null) {
				contentType.setCreatedAt(new Date());
				contentType.setUpdatedAt(new Date());
				contentTypeService.save(contentType);
				request.setAttribute("message", "内容类型增加成功");
			} else {
				contentType.setUpdatedAt(new Date());
				contentTypeService.update(contentType);
				request.setAttribute("message", "内容类型修改成功");
			}
		}
		return "admin/contentType/edit";
	}
	
	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public String edit(Integer id, HttpServletRequest request) {
		if (id != null) {
			ContentType contentType = contentTypeService.getByPK(id);
			request.setAttribute("model", contentType);
		}
		return "admin/contentType/edit";
	}
	
}
