package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Template;
import com.babailiren.ec.repository.dao.TemplateDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class TemplateDaoTest  extends AbstractJUnit4SpringContextTests {

	@Autowired
	private TemplateDao templateDao;
	
	@Test
	public void testUpdate() {
		Template tpl = new Template();
		tpl.setId(39);
		tpl.setName("瑶瑶");
		Template[] tpls = {tpl};
		templateDao.update(tpls);
	}
}
