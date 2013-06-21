package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.SitePageConfig;
import com.babailiren.ec.repository.dao.SitePageConfigDao;

@Service
public class SitePageConfigService {
	
	@Autowired
	private SitePageConfigDao sitePageConfigDao;
	
	public void addAll(List<SitePageConfig> list) {
		sitePageConfigDao.add(list.toArray(new SitePageConfig[0]));
	}
	
	public void delBySiteId(Integer templateId, String pageType) {
		sitePageConfigDao.delBySiteId(templateId, pageType);
	}
	
	public List<SitePageConfig> findSitePageConfigBySiteId(Integer templateId, String pageType) {
		return sitePageConfigDao.findSitePageConfigBySiteId(templateId, pageType);
	}
	
	public List<SitePageConfig> findSitePageConfigBySiteId(Integer templateId) {
		return sitePageConfigDao.findSitePageConfigBySiteId(templateId);
	}
}
