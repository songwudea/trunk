package com.babailiren.ec.repository.dao;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Template;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "templates")
public class TemplateDao extends JdbcEntityDao<Template, Integer> {
	
	public Page<Template> findTemplatePage(Page<Template> page, Template template) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from templates where 1 = 1 ");
		page = findPage(page, sb.toString());
		return page;
	}
}
