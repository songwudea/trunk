package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.common.PasswordManager;
import com.babailiren.ec.model.User;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.UserDao;
import com.babailiren.ec.repository.dao.UserDownloadDao;
import com.babailiren.ec.web.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserDownloadDao userDownloadDao;
	
	
	public User vailUser(String mail, String password) {
		User user = userDao.getUserByMail(mail);
		// TODO MD5
		if(user != null && user.getPassword().equals(PasswordManager.encode(password))) {
			return user;
		}
		return null;
	}
	
	public User vailUserByOpenId(String openId) {
		User user = userDao.getUserByOpenId(openId);
		if(user != null) {
			return user;
		}
		return null;
	}
	public User getUser(Integer userId) {
		return userDao.getByPK(userId);
	}
	
	public Page<User> list(Page<User> page, User user) {
		return userDao.findUserPage(page, user);
	}
	public List<UserVo> listVo( User user) {
		return userDownloadDao.findUserPage(user);
	}
	/**
	 * 根据mail获取user
	 * @param email
	 * @return User
	 */
	public User getUserByMail(String email) {
		return userDao.getUserByMail(email);
	}
	
	public boolean existsUser(String mail) {
		User user = userDao.getUserByMail(mail);
		return user != null;
	}
	
	public User add(User user) {
		String password = user.getPassword();
		user.setPassword(PasswordManager.encode(password));
		user = userDao.add(user);
		user.setPassword(password);
		return user;
	}
	
	public void update(User user) {
		userDao.updateUser(user);
	}
	
	
}
