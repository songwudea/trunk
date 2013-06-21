package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.SitePageConfig;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table = "site_page_config")
public class SitePageConfigDao extends JdbcEntityDao<SitePageConfig, Integer> {

	public void delBySiteId(Integer siteId, String pageType) {
		StringBuffer sb = new StringBuffer();
		sb.append(" delete from site_page_config where site_page_config.template_id = ? and page_type = ? ");
		this.getJdbcTemplate().update(sb.toString(), siteId, pageType);
	}

	/**
	 * 根据 siteid获取 SitePageConfig
	 * 
	 * @param siteId
	 * @return
	 */
	public List<SitePageConfig> findSitePageConfigBySiteId(Integer templateId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from site_page_config where template_id = ? ");
		return find(sb.toString(), templateId);
	}
	
	
	/**
	 * 根据siteid和type 获取 sitepageconfig
	 * @param siteId
	 * @param type
	 * @return
	 */
	public List<SitePageConfig> findSitePageConfigBySiteId(Integer templateId,
			String type) {
		StringBuffer sb = new StringBuffer(" select * from site_page_config where template_id = ? and page_type = ? ");
		return find(sb.toString(), templateId, type);
	}
}
