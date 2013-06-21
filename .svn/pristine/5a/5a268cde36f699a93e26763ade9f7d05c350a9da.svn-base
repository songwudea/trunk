package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.ItemAttribute;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table = "item_attributes")
public class ItemAttributeDao extends JdbcEntityDao<ItemAttribute, Integer> {

	/**
	 * 根据 itemid获取 attr
	 * @param itemId
	 * @return
	 */
	public List<ItemAttribute> findItemAttributes(Integer itemId) {
		StringBuffer sb = new StringBuffer(" select * from item_attributes where item_id = ? ");
		List<ItemAttribute> itemAttributes = find(sb.toString(), itemId);
		return itemAttributes;
	}
	
	/**
	 * 根据 itemid attrName 获取 ItemAttribute
	 * @param itemId
	 * @param attrName
	 * @return 
	 */
	public ItemAttribute getItemAttributes(Integer itemId, String attrName) {
		StringBuffer sb = new StringBuffer(" select * from item_attributes where item_id = ? and attr_name = ? ");
		ItemAttribute itemAttribute = get(sb.toString(), itemId, attrName);
		return itemAttribute;
	}
	
	public void delete(Integer itemId, String key) {
		StringBuffer sb = new StringBuffer();
		sb.append(" delete from item_attributes where item_attributes.item_id = ? and item_attributes.attr_name = ? ");
		this.getJdbcTemplate().update(sb.toString(), itemId, key);
	}
}
