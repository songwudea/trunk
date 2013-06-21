package com.babailiren.ec.model;

import java.util.Date;

import com.babailiren.ec.repository.FieldIgnore;

public class OrderPay implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String orderNumber;

	private String payNumber;

	private String type;

	private Integer userId;

	private Integer payAmount;

	private String status;

	private String remark;

	private Date createdAt;

	private String confirmEmployeeName;

	private Date confirmAt;

	private String tradeNumber;
	
	private String buyer;

	// 支付回调数据存放
	private String payInfo;
	
	
	// 用户名用于前台显示
	private String userName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getPayNumber() {
		return payNumber;
	}

	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getConfirmEmployeeName() {
		return confirmEmployeeName;
	}

	public void setConfirmEmployeeName(String confirmEmployeeName) {
		this.confirmEmployeeName = confirmEmployeeName;
	}

	public Integer getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Integer payAmount) {
		this.payAmount = payAmount;
	}

	public Date getConfirmAt() {
		return confirmAt;
	}

	public void setConfirmAt(Date confirmAt) {
		this.confirmAt = confirmAt;
	}

	@FieldIgnore
	public String getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(String payInfo) {
		this.payInfo = payInfo;
	}

	public String getTradeNumber() {
		return tradeNumber;
	}

	public void setTradeNumber(String tradeNumber) {
		this.tradeNumber = tradeNumber;
	}

	@FieldIgnore
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	
	
}
