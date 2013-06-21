package com.babailiren.repository.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Language;
import com.babailiren.ec.repository.dao.LanguageDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class LanguageDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private LanguageDao languageDao;
	
	@Test
	public void testUpdate() {
		Language language = languageDao.getByPK(1);
		language.setUpdatedAt(new Date());
		Language[] languages = { language };
		languageDao.update(languages);
	}
}
