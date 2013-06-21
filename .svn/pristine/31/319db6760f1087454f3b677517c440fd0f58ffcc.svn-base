package com.babailiren.ec.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Category;
import com.babailiren.ec.model.CategoryAttribute;
import com.babailiren.ec.repository.dao.CategoryAttributeDao;
import com.babailiren.ec.repository.dao.CategoryDao;

@Service
public class CategoryAttributeService {
	
	@Autowired
	private CategoryAttributeDao categoryAttributeDao;
	
	@Autowired
	private CategoryDao categoryDao;

	public List<CategoryAttribute> findAttributeFilter() {
		return categoryAttributeDao.findAttributeFilter();
	}
	
	
	public Map<String, CategoryAttribute> findCategoryAttributeByCidExtendMap(Integer cid) {
		List<CategoryAttribute> list = findCategoryAttributeByCidExtend(cid);
		Map<String, CategoryAttribute> map = new HashMap<String, CategoryAttribute>();
		for(int i = 0;i < list.size(); i++) {
			CategoryAttribute categoryAttribute = list.get(i);
			map.put(categoryAttribute.getName(), categoryAttribute);
		}
		return map;
	}
	
	/**
	 * 查找 该分类包括它上级的继承属性
	 * @return
	 */
	public List<CategoryAttribute> findCategoryAttributeByCidExtend(Integer cid) {
		List<CategoryAttribute> list = new ArrayList<CategoryAttribute>();
		Category category = categoryDao.getByPK(cid);
		list = findCategoryAttributeByCid(cid);
		if(category.getParentId() != null) {
			Category category2 = categoryDao.getByPK(category.getParentId());
			list.addAll(findCategoryAttributeByCid(category2.getId()));
			if(category2.getParentId() != null) {
				Category category3 = categoryDao.getByPK(category2.getParentId());
				list.addAll(findCategoryAttributeByCid(category3.getId()));
			}
		}
		return list;
	}
	
	public void save(CategoryAttribute entity) {
		categoryAttributeDao.add(entity);
	}
	
	public List<CategoryAttribute> findCategoryAttributeByCid(Integer cid) {
		return categoryAttributeDao.findCategoryAttributeByCid(cid);
	}
	
}
