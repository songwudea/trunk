package com.babailiren.ec.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.User;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "users")
public class UserDao extends JdbcEntityDao<User, Integer> {
	
	public Page<User> findUserPage(Page<User> page, User user) {
		List<Object> list = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from users where 1 = 1 ");
		if(user.getEmail() != null && !"".equals(user.getEmail())) {
			sb.append(" and users.email = ? ");
			list.add(user.getEmail());
		}
		
		if(user.getMobile() != null && !"".equals(user.getMobile())) {
			sb.append(" and users.mobile = ? ");
			list.add(user.getMobile());
		}
		
		if(user.getUsername() != null && !"".equals(user.getUsername())) {
			sb.append(" and users.username = ? ");
			list.add(user.getUsername());
		}
		
		if(user.getGender() != null && !"".equals(user.getGender()) && !"all".equals(user.getGender())) {
			sb.append(" and users.gender = ? ");
			list.add(user.getGender());
		}
		
		if(user.getUserSource() != null && !"".equals(user.getUserSource()) && !"all".equals(user.getUserSource())) {
			sb.append(" and users.user_source = ? ");
			list.add(user.getUserSource());
		}
		page = findPage(page, sb.toString(), list.toArray(new Object[0]));
		return page;
	}
	
	/**
	 * 根据 用户名字查询
	 * @param email
	 * @return User
	 */
	public User getUserByMail(String email) {
		StringBuffer sb = new StringBuffer(" select * from users where users.email = ? ");
		return this.get(sb.toString(), email);
	}
	/**
	 * 根据 qq返回的openid查询当前用户
	 * @param email
	 * @return User
	 */
	public User getUserByOpenId(String openId) {
		StringBuffer sb = new StringBuffer(" select * from users where users.open_id = ? ");
		return this.get(sb.toString(), openId);
	}
	public void updateUser(User user) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update users ");
		sb.append(" set password = :password ");
		sb.append(", name = :name ");
		sb.append(", mobile = :mobile ");
		sb.append(", gender = :gender ");
		sb.append(", birthday = :birthday ");
		sb.append(", ifdemand = :ifdemand ");
		sb.append(" where users.id = :id ");
		User[]users = {user};
		this.update(sb.toString(), users);
		
	}
	
}
