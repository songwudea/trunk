package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Comment;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.CommentDao;

@Service
public class CommentService {

	@Autowired
	private CommentDao commentDao;
	
	public Page<Comment> list(Page<Comment> page, Comment comment) {
		return commentDao.findCommentPage(page, comment);
	}
	
	public void verify(Integer id, boolean isDisplay) {
		commentDao.updateCommentDisplayflag(id, isDisplay);
	}
	
	public Comment save(Comment entity) {
		return commentDao.add(entity);
	}
	
	public List<Comment> findCommentsByItemId(Integer itemId) {
		return commentDao.findCommentByItemId(itemId);
	}
}
