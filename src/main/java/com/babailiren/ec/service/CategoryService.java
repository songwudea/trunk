package com.babailiren.ec.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Category;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.BrandDao;
import com.babailiren.ec.repository.dao.CategoryDao;
import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private BrandDao brandDao;

	/**
	 * 获取一个顶级的分类
	 * @param category
	 * @return
	 */
	public Category getTopCategory(Category category) {
		Category topCategory = null;

		// 获取父类
		while (category != null) {
			if (category.getParentCategory() == null) {
				topCategory = category;
			}
			category = category.getParentCategory();
		}
		return topCategory;
	}

	public List<Category> fullCategory() {
		List<Category> categoryList = categoryDao.findAll();
		for (Category c : categoryList) {
			c.setChildren(filterCategory(c.getId(), categoryList));
		}
		return categoryList;
	}

	public List<Category> treeCategoryNoParent(Integer siteId) {
		List<Category> categoryList = categoryDao.findCategoryBySiteId(siteId);
		for (Category c : categoryList) {
			c.setChildren(filterCategory(c.getId(), categoryList));
		}
		return filterCategory(null, categoryList);
	}

	public Category getCategoryByPath(String path) {
		return categoryDao.getCategoryByPath(path);
	}
	
	

	
	public Map<Integer, Category> categories() {
		// 会换查询方法
		List<Category> categoryList = categoryDao.findAll();
		// 按siteid 组织成MAP
		Multimap<Integer, Category> map = ArrayListMultimap.create();
		for (Category c : categoryList) {
			map.put(c.getSiteId(), c);
		}
		// 补充关系
		Map<Integer, Category> categoriesMap = Maps.newHashMap();
		for (Integer siteId : map.keySet()) {
			Collection<Category> collection = map.get(siteId);
			List<Category> categories = categories(siteId, collection);
			for (Category category : categories) {
				categoriesMap.put(category.getId(), category);
			}
		}
		return categoriesMap;
	}

	// for XA by tao
	public Map<Integer, List<Category>> treeCategory() {
		// 会换查询方法
		List<Category> categoryList = categoryDao.findAll();
		// 按siteid 组织成MAP
		Multimap<Integer, Category> map = ArrayListMultimap.create();
		for (Category c : categoryList) {
			map.put(c.getSiteId(), c);
		}
		// 补充关系
		Map<Integer, List<Category>> mapBySiteId = Maps.newHashMap();
		for (Integer siteId : map.keySet()) {
			Collection<Category> collection = map.get(siteId);
			List<Category> treeCategory = treeCategory(siteId, collection);
			mapBySiteId.put(siteId, treeCategory);
		}
		return mapBySiteId;
	}

	/**
	 * 
	 * @param siteId
	 * @param ctgs
	 * @return
	 */
	private List<Category> categories(Integer siteId, Collection<Category> ctgs) {
		for (Category c : ctgs) {
			List<Category> children = filterCategory(c.getId(), ctgs);
			for (Category child : children) {
				child.setParentCategory(c);
			}
			c.setChildren(children);
		}
		return new ArrayList<Category>(ctgs);
	}

	private List<Category> treeCategory(Integer siteId,
			Collection<Category> ctgs) {
		for (Category c : ctgs) {
			List<Category> children = filterCategory(c.getId(), ctgs);
			for (Category child : children) {
				child.setParentCategory(c);
			}
			c.setChildren(children);
		}

		// 获取所有的父类
		return filterCategory(null, ctgs);
	}

	private List<Category> filterCategory(final Integer parentId,
			Collection<Category> categoryList) {
		Collection<Category> topCategories = Collections2.filter(categoryList,
				new Predicate<Category>() {
					@Override
					public boolean apply(Category input) {
						return input.getParentId() == parentId;
					}
				});
		List<Category> filtedList = Lists.newArrayList();
		filtedList.addAll(topCategories);
		return filtedList;
	}

	public Category getCategory(Integer id) {
		return categoryDao.getByPK(id);
	}

	public void save(Category entity) {
		categoryDao.add(entity);
	}

	public Page<Category> list(Page<Category> page, Category category) {
		return categoryDao.findCategoryPage(page, category);
	}

	public List<Category> findParentCategory(Integer siteId) {
		return categoryDao.findParentCategory(siteId);
	}

	public List<Category> findCategoryByPid(Category category) {
		List<Category> list = categoryDao.findCategoryByPid(category.getId());
		return list;
	}

	public void updateCategoryId(Integer cid) {
		brandDao.updateCategoryId(cid);
	}

	public void update(Category category) {
		Category[]categories = {category};
		categoryDao.update(categories);
	}

}