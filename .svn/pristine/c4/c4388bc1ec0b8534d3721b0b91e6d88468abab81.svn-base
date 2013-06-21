package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Province;
import com.babailiren.ec.repository.dao.ProvinceDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class ProvinceDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private ProvinceDao provinceDao;
	@Test
	public void testUpdate() {
		Province e = new Province();

		Province[] es = {e};
		
		provinceDao.update(es);
		
	}
}
