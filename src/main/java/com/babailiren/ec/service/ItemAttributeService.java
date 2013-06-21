package com.babailiren.ec.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.ItemAttribute;
import com.babailiren.ec.repository.dao.ItemAttributeDao;

@Service
public class ItemAttributeService {
	
	@Autowired
	private ItemAttributeDao itemAttributeDao;
	
	public Map<String,String> findItemAttributesMap(Integer itemId) {
		Map<String, String> map = new HashMap<String, String>();
		List<ItemAttribute> list = findItemAttributes(itemId);
		for(int i = 0; i < list.size(); i++) {
			ItemAttribute itemAttribute = list.get(i);
			map.put(itemAttribute.getAttrName(), itemAttribute.getAttrValue());
		}
		return map;
	}
	
	public void delete(Integer itemId, String key) {
		itemAttributeDao.delete(itemId, key);
	}
	
	public List<ItemAttribute> findItemAttributes(Integer itemId) {
		return itemAttributeDao.findItemAttributes(itemId);
	}
	
	public ItemAttribute getItemAttribute(Integer itemId, String attrName) {
		return itemAttributeDao.getItemAttributes(itemId, attrName);
	}
	
	public void save(ItemAttribute entity) {
		itemAttributeDao.add(entity);
	}
	
	public void update(ItemAttribute entity) {
		ItemAttribute[]entities = {entity};
		itemAttributeDao.update(entities);
	}
}
