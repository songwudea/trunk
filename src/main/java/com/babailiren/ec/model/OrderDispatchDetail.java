package com.babailiren.ec.model;

import java.util.Date;

public class OrderDispatchDetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 流水号* */
	private Integer id;

	private Integer orderDispathId;
	
	/** 用户ID * */
	private Integer userId;

	/** 商品ID* */
	private Integer itemId;

	/** 商品名称* */
	private String itemName;

	/** 商品数量* */
	private Integer quantity;

	/** 价格* */
	private Integer price;

	/** 总金额* */
	private Integer amount;

	/** 创建时间* */
	private Date createdAt;

	/** * 商品获得积分倍数 ** */
	private Integer point;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderDispathId() {
		return orderDispathId;
	}

	public void setOrderDispathId(Integer orderDispathId) {
		this.orderDispathId = orderDispathId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}
	
	
}
