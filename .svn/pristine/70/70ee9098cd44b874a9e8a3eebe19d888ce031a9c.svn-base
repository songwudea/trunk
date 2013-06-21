package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.PriceFilter;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table = "price_filter")
public class PriceFilterDao extends JdbcEntityDao<PriceFilter, Integer> {
	
	public List<PriceFilter> findPriceFilterPageBySiteId(Integer siteId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from price_filter where site_id = ? ");
		return find(sb.toString(), siteId);
	}
	
	
	public void delBySiteId(Integer siteId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" delete from price_filter where price_filter.site_id = ? ");
		getJdbcTemplate().update(sb.toString(), siteId);
	} 
	
}
