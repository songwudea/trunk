package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Brand;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.BrandDao;

@Service
public class BrandService {
	
	@Autowired
	private BrandDao brandDao;
	
	
	public List<Brand> findAll() {
		return brandDao.findAll();
	}
	
	public Page<Brand> list(Page<Brand> page, Brand brand) {
		return brandDao.findBrandPage(page, brand);
	}
	
	public Brand getBrand(Integer brandId) {
		return brandDao.getByPK(brandId);
	}
	
	public List<Brand> findByPK(Integer[] pk) {
		return brandDao.findByPK(pk);
	}
	
	
	public List<Brand> findBrandsByCid(Integer cid) {
		return brandDao.findBrandsByCid(cid);
	}
	
	public void save(Brand entity) {
		brandDao.add(entity);
	}
	
	public void update(Brand brand) {
		Brand[]brands = {brand};
		brandDao.update(brands);
	}
	
	public List<Brand> findBrands(Integer cid) {
		return brandDao.findBrands(cid);
	}
}
