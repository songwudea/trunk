package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Brand;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "brands")
public class BrandDao extends JdbcEntityDao<Brand, Integer> {
	
	public List<Brand> findBrands(Integer cid) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from brands where brands.category_id = 0 or category_id = '");
		sb.append(cid);
		sb.append("' ");
		return find(sb.toString());
	}
	
	public List<Brand> findBrandsByCid(Integer cid) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from brands where brands.category_id = ? ");
		return find(sb.toString(), cid);
	}

	public Page<Brand> findBrandPage(Page<Brand> page, Brand brand) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from brands where 1 = 1 ");
		if (brand.getId() != null) {
			sb.append(" and id = '" + brand.getId() + "'");
		}
		page = findPage(page, sb.toString());
		return page;
	}
	
	public void updateCategoryId(Integer cid) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update brands set category_id = 0 ");
		sb.append(" where category_id = '");
		sb.append(cid);
		sb.append("' ");
		this.getJdbcTemplate().update(sb.toString());
	}
}