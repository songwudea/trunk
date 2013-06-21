
package com.babailiren.repository.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.Assert;

import com.babailiren.ec.enumeration.OpenAuth;
import com.babailiren.ec.model.User;
import com.babailiren.ec.repository.dao.UserDao;

@ContextConfiguration(locations = "classpath*:spring/spring-main.xml")
public class UserDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(39);
		user.setSiteId(1);
		user.setEmail("yuyuyuyu@126.com");
		user.setUsername("qq_瑶瑶");
		user.setPassword("A43ACE0468526E66");
		user.setMobile("13524854482");
		user.setName("瑶瑶");
		user.setUserSource(OpenAuth.QQ.toString());
		user.setActived(false);
		user.setUpdatedAt(new Date());
		user.setOpenId("96065995F89DC3116C22D691B491B5B6");
		User[]users = {user};
		userDao.update(users);
	}
	

	// @Test
	public void testAdd() {
		// 新增
		Date date = new Date();
		User user = new User();
		user.setName("中国人");
		user.setEmail("ymw_922@163.com");
		// 郁闷啊，不能直接用枚举
		// 可以用new BeanWrapperImpl(user).registerCustomEditor(Enum.class, new
		// EnumPropertyEditor());来实现枚举和数字之间的互转，但是BeanPropertySqlParameterSource中没有把BeanWrapper暴露出来，不好写，要hack
		// user.setGender(Gender.MALE);
		user.setLastLoginTime(date);
		user.setMobile("13812341234");
		user.setCreatedAt(date);
		user.setUpdatedAt(date);
		userDao.add(user);
		Assert.notNull(user.getId());

		// 查询
		List<User> list = userDao.find("select * from users where name=?",
				"中国人");
		Assert.isTrue(list.size() == 1);
		Assert.isTrue(user.getId() == list.get(0).getId());

		// 修改
		user.setName("larry");
		userDao.update("update users set name=:name where id=:id",
				new User[] { user });
		user = userDao.getByPK(user.getId());
		Assert.notNull(user);
		Assert.isTrue("larry".equals(user.getName()));

		// 删除
		userDao.delete(user.getId());
		user = userDao.getByPK(user.getId());
		Assert.isNull(user);
	}
}
