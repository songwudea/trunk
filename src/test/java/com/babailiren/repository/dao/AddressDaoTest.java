package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Address;
import com.babailiren.ec.repository.dao.AddressDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class AddressDaoTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private AddressDao addressDao;

	@Test
	public void testUpdate() {
		Address address = addressDao.getByPK(136);
		Address[]addresses = {address};
		address.setMainflag("y");
		addressDao.update(addresses);
	}
	
}
