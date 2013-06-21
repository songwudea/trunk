package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Address;
import com.babailiren.ec.model.City;
import com.babailiren.ec.model.Province;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.AddressDao;
import com.babailiren.ec.repository.dao.CityDao;
import com.babailiren.ec.repository.dao.ProvinceDao;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private ProvinceDao provinceDao;
	
	@Autowired
	private CityDao cityDao;
	
	public void updateDef2Y(Integer addressId) {
		addressDao.updateDef2Y(addressId);
	}
	
	public void updateDef2N(Integer siteId, Integer userId) {
		addressDao.updateDef2N(siteId, userId);
	}
	
	public Address getAddress(Integer id) {
		return addressDao.getByPK(id);
	}
	
	public List<Address> findAddressByUserId(Integer userId) {
		return addressDao.findAddressByUserId(userId);
	}
	public Page<Address> findAddressByUserIdPage(Page<Address> page,Integer userId) {
		return addressDao.findAddressByUserIdPage(page ,userId);
	}
	public Page<Address> list(Page<Address> page, Address address) {
		return addressDao.findAddressPage(page, address);
	}
	
	public List<City> findCityByPid(Integer pid) {
		List<City> cities = cityDao.findCityByPid(pid);
		return cities;
	}
	
	public List<Province> findProvinces() {
		List<Province> provinces = provinceDao.findAll();
		return provinces;
	}
	
	public Address save(Address address) {
		return addressDao.add(address);
	}
	
	public void update(Address address) {
		Address[] addresses = {address};
		addressDao.update(addresses);
	}
	
	public void delete(Integer id) {
		addressDao.delete(id);
	}
	
}
