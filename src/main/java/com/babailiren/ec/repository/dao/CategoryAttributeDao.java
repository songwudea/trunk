package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.CategoryAttribute;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table = "category_attributes")
public class CategoryAttributeDao extends JdbcEntityDao<CategoryAttribute, Integer> {
	
	public List<CategoryAttribute> findAttributeFilter() {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from  category_attributes ");
		sb.append(" where category_attributes.attr_type = ? ");
		sb.append(" and category_attributes.filter = ?  ");
		return find(sb.toString(), "SELECT", 1);
	}
	
	public List<CategoryAttribute> findAttributeFilter(Integer cid) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from  category_attributes ");
		sb.append(" where category_attributes.attr_type = ? ");
		sb.append(" and category_attributes.filter = ?  ");
		sb.append(" and category_attributes.category_id = ? ");
		return find(sb.toString(), "SELECT", 1, cid);
	}
	
	public List<CategoryAttribute> findCategoryAttributeByCid(Integer cid) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from category_attributes where category_attributes.category_id = '");
		sb.append(cid);
		sb.append("' ");
		return find(sb.toString());
	}
}
