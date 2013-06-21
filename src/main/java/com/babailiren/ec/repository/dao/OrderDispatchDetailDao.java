package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.OrderDispatchDetail;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table = "order_dispatch_detail")
public class OrderDispatchDetailDao extends JdbcEntityDao<OrderDispatchDetail, Integer> {
	
	public List<OrderDispatchDetail> findOrderDispatchDetailByOrderDispathId(Integer orderDispathId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from order_dispatch_detail where order_dispatch_detail.order_dispath_id = ? ");
		return find(sb.toString(), orderDispathId);
	}

}
