package com.babailiren.repository.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.babailiren.ec.model.Cart;
import com.babailiren.ec.repository.dao.CartDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class CartDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private CartDao cartDao;
	
	@Test
	public void testUpdate() {
		Cart cart = cartDao.getByPK(44l);
		Cart[]carts = {cart};
		cart.setName("测试更新");
		cartDao.update(carts);
	}
}
