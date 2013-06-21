package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Address;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "address")
public class AddressDao  extends JdbcEntityDao<Address, Integer> {
	
	public void updateDef2Y(Integer addressId) {
		String sql = " update address set mainflag = 'y' where id = '" + addressId + "' ";
		this.getJdbcTemplate().update(sql);
	}
	
	public void updateDef2N(Integer siteId, Integer userId) {
		String sql = " update address set mainflag = 'n' where site_id = '" + siteId + "' and user_id = '" + userId + "' ";
		this.getJdbcTemplate().update(sql);
	}
	
	public Page<Address> findAddressPage(Page<Address> page, Address address) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from address ");
		page = findPage(page, sb.toString());
		return page;
	}
	
	public List<Address> findAddressByUserId(Integer userId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from address where user_id = ? ");
		List<Address> list = find(sb.toString(), userId);
		return list;
	}
	
	public Page<Address> findAddressByUserIdPage(Page<Address> page,Integer userId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from address where user_id = ? ");
		page = findPage(page,sb.toString(), userId);
		return page;
	}
}
