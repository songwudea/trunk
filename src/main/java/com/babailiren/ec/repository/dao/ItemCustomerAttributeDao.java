package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.ItemCustomerAttribute;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table = "item_customer_attributes")
public class ItemCustomerAttributeDao extends
		JdbcEntityDao<ItemCustomerAttribute, Integer> {

	public List<ItemCustomerAttribute> findItemCustomerAttributes(Integer itemId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from item_customer_attributes where item_customer_attributes.item_id = ? ");
		return find(sb.toString(), itemId);
	}
	
	public void deleteByItemId(Integer itemId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" delete from item_customer_attributes where item_id = ? ");
		this.getJdbcTemplate().update(sb.toString(), itemId);
	}
}
