package com.babailiren.ec.repository.dao;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.enumeration.OrderSeqEnum;
import com.babailiren.ec.model.OrderSeq;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table = "order_seq")
public class OrderSeqDao extends JdbcEntityDao<OrderSeq, Integer> {
	
	public Integer getMax(OrderSeqEnum orderSeqEnum) {
		String sql = " select * from  order_seq where order_seq.type = ? ";
		return this.find(sql, orderSeqEnum.toString()).size();
	}
}
