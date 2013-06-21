package com.babailiren.ec.repository.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Language;
import com.babailiren.ec.model.Site;
import com.babailiren.ec.model.Template;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;
import com.google.common.collect.Maps;

@Repository
@EntityDao(Table = "sites")
public class SiteDao extends JdbcEntityDao<Site, Integer> {

	@Autowired
	private LanguageDao languageDao;

	@Autowired
	private TemplateDao templateDao;

	public Page<Site> findSitePage(Page<Site> page, Site site) {
		page.setResult(findAll());
		return page;
	}
	
	/**
	 * 根据员工id获取站点信息
	 * @return
	 */
	public List<Site> findSiteByEmployeeId(Integer employeeId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select sites.* from sites ");
		sb.append(" left join employee_site on sites.id = employee_site.site_id ");
		sb.append(" where employee_site.employee_id = ? ");
		return find(sb.toString(), employeeId);
	}

	@Override
	public List<Site> findAll() {
		List<Site> sites = super.findAll();
		List<Language> languages = languageDao.findAll();
		List<Template> templates = templateDao.findAll();
		Map<Integer, Language> languageMap = Maps.newHashMap();
		Map<Integer, Template> templateMap = Maps.newHashMap();
		for (Language l : languages) {
			languageMap.put(l.getId(), l);
		}
		for (Template t : templates) {
			templateMap.put(t.getId(), t);
		}
		for (Site s : sites) {
			s.setLanguage(languageMap.get(s.getLanguageId()));
			s.setTemplate(templateMap.get(s.getTemplateId()));
		}
		return sites;
	}

	@Deprecated
	public Site getSiteByDomain(String domain) {
		// TODO 全局缓存获取
		Site site = this.get("SELECT * FROM sites WHERE domain = ?", domain);
		// TODO 全局缓存获取
		Language language = languageDao.getByPK(site.getLanguageId());
		// TODO 全局缓存获取
		Template template = templateDao.getByPK(site.getTemplateId());

		site.setLanguage(language);
		site.setTemplate(template);

		return site;
	}
}
