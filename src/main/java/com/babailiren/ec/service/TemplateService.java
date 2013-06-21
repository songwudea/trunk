package com.babailiren.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Template;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.TemplateDao;

@Service
public class TemplateService {

	@Autowired
	private TemplateDao templateDao;

	public Page<Template> list(Page<Template> page, Template template) {
		return templateDao.findTemplatePage(page, template);
	}
}
