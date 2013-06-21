package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Site;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.SiteDao;

@Service
public class SiteService {

	@Autowired
	private SiteDao siteDao;

	public List<Site> findAll() {
		return siteDao.findAll();
	}

	public List<Site> findSiteByEmployeeId(Integer employeeId) {
		return siteDao.findSiteByEmployeeId(employeeId);
	}

	public Site getSite(Integer id) {
		return siteDao.getByPK(id);
	}
	
	public Site getSiteByDomain(String domain) {
		return siteDao.getSiteByDomain(domain);
	}

	public Page<Site> list(Page<Site> page, Site site) {
		return siteDao.findSitePage(page, site);
	}
	
	public void update(Site site) {
		Site[]sites = {site};
		siteDao.update(sites);
	}
}
