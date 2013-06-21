package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.PagePublish;
import com.babailiren.ec.repository.dao.PagePublishDao;

@Service
public class PagePublishService {

	@Autowired
	private PagePublishDao publishDao;

	public void save(List<PagePublish> list) {
		publishDao.add(list.toArray(new PagePublish[0]));
	}
	
	public void delBySiteId(Integer siteId, Integer categoryId) {
		publishDao.delBySiteId(siteId, categoryId);
	}
	
	/**
	 * 查找首页信息
	 * @param siteId
	 * @return
	 */
	public List<PagePublish> findPagePublishs(Integer siteId, Integer categoryId) {
		return publishDao.findPagePublishs(siteId, categoryId);
	}
}
