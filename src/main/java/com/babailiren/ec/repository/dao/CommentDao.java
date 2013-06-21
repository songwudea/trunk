package com.babailiren.ec.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Comment;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "comments")
public class CommentDao extends JdbcEntityDao<Comment, Integer> {

	public Page<Comment> findCommentPage(Page<Comment> page, Comment comment) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from comments where 1=1");
		List<Object> list = new ArrayList<Object>();
		
		if(comment.getUserName() != null && !"".equals(comment.getUserName())) {
			sb.append(" and comments.user_name = ? ");
			list.add(comment.getUserName());
		}
		
		if(comment.getStartcreatedAt() != null && !"".equals(comment.getStartcreatedAt()) && comment.getEndcreatedAt() != null && !"".equals(comment.getEndcreatedAt())) {
			sb.append(" and comments.created_at >= ? ");
			list.add(comment.getStartcreatedAt());
			sb.append(" and comments.created_at <= ? ");
			list.add(comment.getEndcreatedAt());
		}
		page = findPage(page, sb.toString(),list.toArray());
		return page;
	}

	public void updateCommentDisplayflag(Integer id, boolean isDisplay) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update comments set comment_display_flag = ? where id = ? ");
		getJdbcTemplate().update(sb.toString(), isDisplay, id);
	}
	
	public List<Comment> findCommentByItemId(Integer itemId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from comments where comments.item_id = ? and comment_display_flag = 1 ");
		return find(sb.toString(), itemId);
	}
}
