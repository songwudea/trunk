package com.babailiren.ec.model;

@SuppressWarnings("serial")
public class PromotionDetails implements java.io.Serializable{
	
	private int id ;
	
	private  int produceAmout;
	
	private int promotionId;
	
	private String promotionName;

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduceAmout() {
		return produceAmout;
	}

	public void setProduceAmout(int produceAmout) {
		this.produceAmout = produceAmout;
	}

	public int getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}

}
