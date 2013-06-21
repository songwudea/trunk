package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.PromotionDetails;
import com.babailiren.ec.repository.dao.PromotionDetailsDao;

@Service
public class PromotionDetailService {

	@Autowired
	private PromotionDetailsDao promotionDetailsDao;

	public List<PromotionDetails> getPromotionDetailsById(int promotionId) {

		return promotionDetailsDao.getPromotionDetailsById(promotionId);
	}

}
