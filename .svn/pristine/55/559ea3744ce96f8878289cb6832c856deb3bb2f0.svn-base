package com.babailiren.ec.repository.dao;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.ContentType;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "content_types")
public class ContentTypeDao extends JdbcEntityDao<ContentType, Integer> {
	
	public Page<ContentType> findContentTypePage(Page<ContentType> page, ContentType contentType) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from content_types");
		page = findPage(page, sb.toString());
		return page;
	}
	
}
