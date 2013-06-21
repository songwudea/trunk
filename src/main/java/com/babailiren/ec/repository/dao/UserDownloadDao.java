package com.babailiren.ec.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.User;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.web.vo.UserVo;

@Repository
@EntityDao(Table = "users")
public class UserDownloadDao extends JdbcEntityDao<UserVo, Integer> {
	
	public List<UserVo> findUserPage(User user) {
		List<UserVo> list = new ArrayList<UserVo>();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from users");
		list = find(sb.toString(), list.toArray(new Object[0]));
		return list;
	}
	
	
	
}
