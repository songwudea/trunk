package com.babailiren.ec.model;

import java.util.Date;

public class ItemPriceExtend {

	private Integer itemId;
	private String itemAttrs;
	private String customerClass;
	private Integer orderQuantity;
	private Integer price;
	private Date publishOn;
	private Date expireOn;
	private String createdBy;
	private String updatedBy;
	private Date createdAt;
	private Date updatedAt;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemAttrs() {
		return itemAttrs;
	}

	public void setItemAttrs(String itemAttrs) {
		this.itemAttrs = itemAttrs;
	}

	public String getCustomerClass() {
		return customerClass;
	}

	public void setCustomerClass(String customerClass) {
		this.customerClass = customerClass;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getPublishOn() {
		return publishOn;
	}

	public void setPublishOn(Date publishOn) {
		this.publishOn = publishOn;
	}

	public Date getExpireOn() {
		return expireOn;
	}

	public void setExpireOn(Date expireOn) {
		this.expireOn = expireOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
