package com.babailiren.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.model.Promotion;
import com.babailiren.ec.repository.dao.PromotionDao;

@Service
public class PromotionService {

	@Autowired
	private PromotionDao promotionDao;

	public Promotion getPromotionsById(int promotionId) {
		
		return promotionDao.getPromotionsById(promotionId);
	}

}
