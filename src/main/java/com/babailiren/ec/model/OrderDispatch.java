package com.babailiren.ec.model;

import java.util.Date;

public class OrderDispatch implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 流水号* */
	private Integer id;
	
	private String orderDispatchNumber;
	
	/**
	 * 快递名字
	 */
	private String expressDeliveryName;
	
	public String getExpressDeliveryName() {
		return expressDeliveryName;
	}

	public void setExpressDeliveryName(String expressDeliveryName) {
		this.expressDeliveryName = expressDeliveryName;
	}

	/** 订单编号 **/
	private String orderNumber;
	
	private Integer siteId;

	/** customer* */
	private Integer userId;

	/** 订单项数量* */
	private Integer quantity;

	/** 总价格* */
	private Integer price;

	/** 总配送费* */
	private Integer shipfee;

	/** 付款人姓名* */
	private String shipname;

	/** 付款人电话* */
	private String shiptel;

	/** 付款人省份* */
	private String shipprovince;

	/** 付款人城市* */
	private String shipcity;

	/** 付款人地区* */
	private String shipregion;

	/** 付款人地址* */
	private String shipaddress;

	/** 付款人邮编* */
	private String shipzip;

	/** 发货状态* */
	private String status;

	/** 创建时间* */
	private Date createdAt;
	
	/** 更新时间 **/
	private Date updateAt;
	
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

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Integer getShipfee() {
		return shipfee;
	}

	public void setShipfee(Integer shipfee) {
		this.shipfee = shipfee;
	}

	public String getShipname() {
		return shipname;
	}

	public void setShipname(String shipname) {
		this.shipname = shipname;
	}

	public String getShiptel() {
		return shiptel;
	}

	public void setShiptel(String shiptel) {
		this.shiptel = shiptel;
	}

	public String getShipprovince() {
		return shipprovince;
	}

	public void setShipprovince(String shipprovince) {
		this.shipprovince = shipprovince;
	}

	public String getShipcity() {
		return shipcity;
	}

	public void setShipcity(String shipcity) {
		this.shipcity = shipcity;
	}

	public String getShipregion() {
		return shipregion;
	}

	public void setShipregion(String shipregion) {
		this.shipregion = shipregion;
	}

	public String getShipaddress() {
		return shipaddress;
	}

	public void setShipaddress(String shipaddress) {
		this.shipaddress = shipaddress;
	}

	public String getShipzip() {
		return shipzip;
	}

	public void setShipzip(String shipzip) {
		this.shipzip = shipzip;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOrderDispatchNumber() {
		return orderDispatchNumber;
	}

	public void setOrderDispatchNumber(String orderDispatchNumber) {
		this.orderDispatchNumber = orderDispatchNumber;
	}
	
	
}
