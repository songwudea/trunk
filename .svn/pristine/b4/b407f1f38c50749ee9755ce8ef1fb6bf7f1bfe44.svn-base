package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.ItemCustomerAttribute;
import com.babailiren.ec.repository.dao.ItemCustomerAttributeDao;

@Service
public class ItemCustomerAttributeService {
	
	@Autowired
	private ItemCustomerAttributeDao customerAttributeDao;
	
	public List<ItemCustomerAttribute> findItemCustomerAttributes(Integer itemId) {
		return customerAttributeDao.findItemCustomerAttributes(itemId);
	}
	
	public void addAll(ItemCustomerAttribute[] customerAttributes) {
		customerAttributeDao.add(customerAttributes);
	}
	
	public void deleteByItemId(Integer itemId) {
		customerAttributeDao.deleteByItemId(itemId);
	}
}
