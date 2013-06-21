package com.babailiren.ec.web.vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.babailiren.ec.model.OrderDetail;
import com.babailiren.ec.model.OrderDispatch;

public class OrderVo {

	/** 流水号* */
	private Integer id;
	
	/** 订单编号 **/
	private String orderNumber;
	
	/** 退款余额 **/
	private Integer refundPrice;
	
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

	/** 支付方式* */
	private String paytype;
	
	/** 付款人性别* */
	private String shipsex;

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

	/** 付款人备注* */
	private String shipnote;

	/** 订单状态* */
	// TODO 枚举
	private String status;

	/** 是否需要发票 * */
	private String invoice;
	
	/** 发票类型* */
	private String invoiceType;

	/** 发票抬头* */
	private String invoiceTitle;

	/** 可获得的积分 * */
	private Integer points;

	/** 创建时间* */
	private Date createdAt;
	
	/** 更新时间 **/
	private Date updateAt;
	
	/** 发货时间 **/
	private Date deliverdate;
	
	/** 确认状态 **/
	private String affirmstate;
	
	/** 支付时间 **/
	private Date paydate;
	
	/** 用于前台显示 **/
	private String userName;
	
	/** 备注 **/
	private String remark;
	
	private String payStatus;
	
	private String dispatchStatus;
	
	///////
	private String createdAtS;
	
	private OrderDispatch dispatch;
	
	private List<OrderDetail> details = new ArrayList<OrderDetail>();

	
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

	public Integer getRefundPrice() {
		return refundPrice;
	}

	public void setRefundPrice(Integer refundPrice) {
		this.refundPrice = refundPrice;
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

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getShipsex() {
		return shipsex;
	}

	public void setShipsex(String shipsex) {
		this.shipsex = shipsex;
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

	public String getShipnote() {
		return shipnote;
	}

	public void setShipnote(String shipnote) {
		this.shipnote = shipnote;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedAtS() {
		return createdAtS;
	}

	public void setCreatedAtS(Date createdAtS) {
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.getCreatedAt());
		this.createdAtS = date;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Date getDeliverdate() {
		return deliverdate;
	}

	public void setDeliverdate(Date deliverdate) {
		this.deliverdate = deliverdate;
	}

	public String getAffirmstate() {
		return affirmstate;
	}

	public void setAffirmstate(String affirmstate) {
		this.affirmstate = affirmstate;
	}

	public Date getPaydate() {
		return paydate;
	}

	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getDispatchStatus() {
		return dispatchStatus;
	}

	public void setDispatchStatus(String dispatchStatus) {
		this.dispatchStatus = dispatchStatus;
	}

	public List<OrderDetail> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}

	public OrderDispatch getDispatch() {
		return dispatch;
	}

	public void setDispatch(OrderDispatch dispatch) {
		this.dispatch = dispatch;
	}

	
}
