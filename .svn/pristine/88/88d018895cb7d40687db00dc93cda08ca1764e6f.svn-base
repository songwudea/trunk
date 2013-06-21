package com.babailiren.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.enumeration.OrderSeqEnum;
import com.babailiren.ec.model.OrderSeq;
import com.babailiren.ec.repository.dao.OrderSeqDao;

@Service
public class SeqService {
	
	@Autowired
	private OrderSeqDao orderSeqDao;
	
	public synchronized Integer getOrderSeq() {
		Integer max = orderSeqDao.getMax(OrderSeqEnum.ORDER_NUMBER_SQE);
		Integer seqId = max + 1;
		OrderSeq orderSeq = new OrderSeq();
		orderSeq.setType(OrderSeqEnum.ORDER_NUMBER_SQE.toString());
		orderSeq.setSeqId(seqId);
		orderSeq = orderSeqDao.add(orderSeq);
		return orderSeq.getSeqId();
	}
}
