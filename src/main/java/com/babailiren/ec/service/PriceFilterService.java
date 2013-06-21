package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.PriceFilter;
import com.babailiren.ec.repository.dao.PriceFilterDao;

@Service
public class PriceFilterService {
	
	@Autowired
	private PriceFilterDao priceFilterDao;
	
	public List<PriceFilter> findAll() {
		return priceFilterDao.findAll();
		
	}
	
	public List<PriceFilter> findPriceFilter(Integer siteId) {
		return priceFilterDao.findPriceFilterPageBySiteId(siteId);
	}
	
	public void save(List<PriceFilter> list) {
		priceFilterDao.add(list.toArray(new PriceFilter[0]));
	}
	
	public void delBySiteId(Integer siteId) {
		priceFilterDao.delBySiteId(siteId);
	}
}
