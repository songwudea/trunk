package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.PagePublish;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table = "page_publish")
public class PagePublishDao extends JdbcEntityDao<PagePublish, Integer> {

	
	
	
	
	/**
	 * 查找首页信息
	 * @param siteId
	 * @return
	 */
	public List<PagePublish> findPagePublishs(Integer siteId, Integer categoryId) {
		StringBuffer sb = new StringBuffer();
		if(categoryId == null) {
			sb.append(" select * from page_publish where page_publish.site_id = ? and page_publish.category_id is null  ");
			return find(sb.toString(), siteId);
		} else {
			sb.append(" select * from page_publish where page_publish.site_id = ? and page_publish.category_id = ?  ");
			return find(sb.toString(), siteId, categoryId);
		}
	}
	
	public void delBySiteId(Integer siteId,  Integer categoryId) {
		StringBuffer sb = new StringBuffer();
		if(categoryId == null) {
			sb.append(" delete from page_publish where site_id = ? and page_publish.category_id is null ");
			getJdbcTemplate().update(sb.toString(), siteId);
		} else {
			sb.append(" delete from page_publish where site_id = ? and page_publish.category_id = ? ");
			getJdbcTemplate().update(sb.toString(), siteId, categoryId);
		}
	}
}
