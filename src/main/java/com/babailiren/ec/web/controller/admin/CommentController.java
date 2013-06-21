package com.babailiren.ec.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.model.Comment;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.CommentService;
import com.babailiren.ec.web.common.Pager;

@Controller
@RequestMapping("/admin/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	@ResponseBody
	public String list(Comment comment, Page<Comment> page,
			HttpServletRequest request, HttpServletResponse response) {
		Page<Comment> list = commentService.list(page, comment);
		return new Pager<Comment>().getJsonPagerData(list);
	}

	@RequestMapping(value = "verify.html", method = RequestMethod.POST)
	public @ResponseBody
	String verify(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		commentService.verify(id, true);
		return "suss";
	}

	@RequestMapping(value = "hidden.html", method = RequestMethod.POST)
	public @ResponseBody
	String hidden(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		commentService.verify(id, false);
		return "suss";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "admin/comment/index";
	}
}
