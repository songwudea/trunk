package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Brand;
import com.babailiren.ec.repository.dao.BrandDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class BrandDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private BrandDao brandDao;
	
	@Test
	public void testUpdate() {
		Brand brand = brandDao.getByPK(1);
		Brand[]brands = {brand};
		brand.setName("测试更新");
		brandDao.update(brands);
	}
}
