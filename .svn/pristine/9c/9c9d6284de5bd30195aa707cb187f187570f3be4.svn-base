package com.babailiren.ec.web.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.babailiren.ec.common.Validator;
import com.babailiren.ec.model.User;

@Controller
@RequestMapping("/")
public class ActionController {
	
/*	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	*/
	@RequestMapping(value = "login.html", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	

	@RequestMapping(value = "register.html", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, HttpServletRequest request) {
		Validator validator = new Validator();
		validator.isNotBlankValidator(user.getName(), "请填写用户名")
				 .isNotBlankValidator(user.getPassword(), "请填写用户密码");
		
		// 判断是否验证失败
		if(StringUtils.isNotEmpty(validator.renderHtmlMessage())) {
			request.setAttribute("validator", validator.renderHtmlMessage());
			return "user/register";
		} else {
			
		}

		request.setAttribute("validator", validator.renderHtmlMessage());
		return "user/register";
	}

}
