package com.babailiren.ec.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.enumeration.SessionName;
import com.babailiren.ec.model.Comment;
import com.babailiren.ec.model.Item;
import com.babailiren.ec.service.CommentService;
import com.babailiren.ec.service.ItemService;

@Controller
public class CommentsController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/comments/edit.html", method = RequestMethod.POST)
	public @ResponseBody
	String edit(Integer itemId, String content, HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute(SessionName.USER_ID.toString()) != null) {
			String userId = request.getSession().getAttribute(SessionName.USER_ID.toString()).toString();
			String userName = request.getSession().getAttribute(SessionName.USER_NAME.toString()).toString();
			Item item = itemService.getItem(itemId);
			Comment comment = new Comment();
			comment.setItemId(itemId);
			comment.setCommentGood(content);
			comment.setTitle(content);
			comment.setCommentBad(content);
			comment.setCommentUseExp(content);
			comment.setCommentDisplayFlag(false);
			comment.setItemName(item.getName());
			comment.setUserId(Integer.parseInt(userId));
			comment.setUserName(userName);
			comment.setCommentType("COMMENT");
			comment.setCommentIp("");
			comment.setCreatedAt(new Date());
			comment.setCreatedBy("");
			commentService.save(comment);
		} else {
			return "请登录后再评论";
		}
		return "评论成功等审核通过后显示";
	}
}
