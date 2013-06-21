package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Province;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table = "dict_province", PK = "prov_id")
public class ProvinceDao extends JdbcEntityDao<Province, Integer> {
	public List<Province> findAll() {
		String sql = " select * from dict_province ";
		return find(sql);
	}
	
	public Province getProvinceById(Integer id) {
		String sql = " select * from dict_province where prov_id = ? ";
		return get(sql, id);
	}
}
