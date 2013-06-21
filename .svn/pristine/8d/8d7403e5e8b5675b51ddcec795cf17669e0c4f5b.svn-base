package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Category;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "categories")
public class CategoryDao extends JdbcEntityDao<Category, Integer> {
	
	public List<Category> findCategoryBySiteId(Integer siteId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from categories where 1 = 1 and categories.site_id = ? ");
		return find(sb.toString(), siteId);
	}
	
	public List<Category> findParentCategory(Integer siteId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from categories where 1 = 1 and parent_id is null ");
		return find(sb.toString());
	}
	
	@Override
	public List<Category> findAll() {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from categories")
				.append(" order by sort");
		return find(sb.toString());
	}
	
	
	public Category getCategoryByPath(String path) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from categories where path = ? ");
		return get(sb.toString(),path);
	}
	
	public Page<Category> findCategoryPage(Page<Category> page, Category category) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from categories where 1 = 1 ");
		if (category.getId() != null) {
			sb.append(" and id = '" + category.getId() + "'");
		}
		
		if(category.getLevel() != null) {
			sb.append(" and level = '" + category.getLevel() + "'");
		}
		
		page = findPage(page, sb.toString());
		return page;
	}
	
	public List<Category> findCategoryByPid(Integer pid) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from categories where categories.parent_id = ? ");
		return find(sb.toString(), pid);
	}

	public List<Category> findCategoryByLevel(Integer level) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from categories where categories.level = ? ");
		return find(sb.toString(), level);
	}
}
