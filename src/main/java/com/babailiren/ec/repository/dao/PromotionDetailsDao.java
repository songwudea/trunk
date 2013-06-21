package com.babailiren.ec.repository.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.PromotionDetails;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;


@Repository
@EntityDao(Table ="promotionDetails")
public class PromotionDetailsDao extends JdbcEntityDao<PromotionDetails, Number> {
	
	
	public List<PromotionDetails>getPromotionDetailsById(int promotionId){
		
		String promotions = "select a.promotion_name,b.reduce_price from promotion_details a left join  promotion b  on  a.promotion_id = b.id where promotion_id = ?";
		
		return find(promotions, promotionId);
		
	}
	

}
