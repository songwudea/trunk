package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.City;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table = "dict_city", PK ="city_id")
public class CityDao extends JdbcEntityDao<City, Integer> {

	public List<City> findCityByPid(Integer pid) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from dict_city where dict_city.prov_id = ? ");
		return find(sb.toString(), pid);
	}
	
	public City getCityById(Integer cityId) {
		String sql = " select * from dict_city where city_id = ? ";
		return get(sql, cityId);
	}
}
