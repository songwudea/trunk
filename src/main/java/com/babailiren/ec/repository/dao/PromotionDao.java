package com.babailiren.ec.repository.dao;


import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Promotion;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;

@Repository
@EntityDao(Table ="promotion")
public class PromotionDao extends JdbcEntityDao<Promotion, Number> {
	
	public Promotion getPromotionsById(int promotionId){
		
		String promotions = "select a.promotion_name,b.reduce_price from promotion_details a left join  promotion b  on  a.promotion_id = b.id where promotion_id = ?";
		
		return get(promotions, promotionId);
		
	}

}
