package com.babailiren.ec.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.common.NumberFormatUtils;
import com.babailiren.ec.enumeration.InvoiceTypeEnum;
import com.babailiren.ec.enumeration.OrderEnum;
import com.babailiren.ec.enumeration.OrderSeqEnum;
import com.babailiren.ec.enumeration.PayType;
import com.babailiren.ec.model.Address;
import com.babailiren.ec.model.Cart;
import com.babailiren.ec.model.OrderDetail;
import com.babailiren.ec.model.OrderDispatch;
import com.babailiren.ec.model.OrderPay;
import com.babailiren.ec.model.OrderSeq;
import com.babailiren.ec.model.Orders;
import com.babailiren.ec.pay.PayUtils;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.OrderDao;
import com.babailiren.ec.repository.dao.OrderDetailDao;
import com.babailiren.ec.repository.dao.OrderDispatchDao;
import com.babailiren.ec.repository.dao.OrderDownloadDao;
import com.babailiren.ec.repository.dao.OrderPayDao;
import com.babailiren.ec.repository.dao.OrderSeqDao;
import com.babailiren.ec.web.vo.OrderInfo;
import com.babailiren.ec.web.vo.OrderVo;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderDownloadDao downloadDao;
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Autowired
	private OrderPayDao orderPayDao;
	
	@Autowired
	private OrderDispatchDao orderDispatchDao;

	@Autowired
	private OrderSeqDao orderSeqDao;
	
	public Page<Orders> list(Page<Orders> page, Orders order) {
		Page<Orders> page2 = orderDao.findOrderPageBySiteId(page, order);
		/*List<OrderDetail> detailVos = orderDetailDao.findOrderDetailByOrderNumber();
		List<Orders> orders = page2.getResult();
		for(int i = 0; i < orders.size(); i++) {
			Orders order1 = orders.get(i);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = "";
			if (order1.getCreatedAt()!= null && !"".equals(order1.getCreatedAt())) {
				date = format.format(order1.getCreatedAt());
			}
			order1.setCreatedAtS(date);
			String  orderNumber = order1.getOrderNumber();
			if (order1 != null && order1.getStatus() != null && !"".equals(order1.getStatus())) {
				if(order1.getStatus().equals("ORDER_STATUS_PAY")){
					order1.setStatus("支付中");
				}else if(order1.getStatus().equals("ORDER_STATUS_DISPATCH")){
					order1.setStatus("发货中");
				}else if(order1.getStatus().equals("ORDER_STATUS_FINISH")){
					order1.setStatus("发货完成");
				}else if(order1.getStatus().equals("ORDER_STATUS_REFUND")){
					order1.setStatus("退款中");
				}else{
					order1.setStatus("交易取消");
				}				
			}
			for (int j = 0; j < detailVos.size(); j++) {
				OrderDetail orderDetail = detailVos.get(j);
				if(orderNumber.equals(orderDetail.getOrderNumber())) {
					Orders orders2 = new Orders();
					if (orderDetail.getItemName() != null && !"".equals(orderDetail.getItemName())) {
						orders2.setOrderNumber(orderDetail.getItemName());
					}else{
						orders2.setOrderNumber("");
					}
					if (orderDetail.getQuantity() != null && !"".equals(orderDetail.getQuantity())) {
						orders2.setUserName(orderDetail.getQuantity().toString());
					}else{
						orders2.setUserName("");
					}
					if (orderDetail.getAmount() != null && !"".equals(orderDetail.getAmount())) {
						orders2.setCreatedAtS((orderDetail.getAmount()/100)+"");
					}else{
						orders2.setCreatedAtS("");
					}if (orderDetail.getCreatedAt()!= null && !"".equals(orderDetail.getCreatedAt())) {
						orders2.setStatus(format.format(orderDetail.getCreatedAt()));
					}else{
						orders2.setStatus("");
					}
					orders2.set_parentId(order1.getId().toString());
					orders.add(orders2);
				}
			}
		}
		page2.setResult(orders);*/
		return page2; 
	} 
	
	public List<OrderVo> findOrderVos(Orders order){
		return downloadDao.findOrderVos(order);
	}
	/**
	 * 根据 订单号获取订单
	 * @param orderNumber
	 * @return Orders
	 */
	public Orders getOrder(String orderNumber) {
		return orderDao.getOrderByOrderNumber(orderNumber);
	}

	public OrderInfo getOrderInfo(Integer orderId) {
		Orders order = orderDao.getByPK(orderId);
		List<OrderDetail> details = orderDetailDao
				.findOrderDetailByOrderNumber(order.getOrderNumber());
		OrderInfo info = new OrderInfo();
		
		List<OrderPay> orderPays = orderPayDao.findOrderPayByOrderNumber(order.getOrderNumber());
		List<OrderDispatch> orderDispatchs = orderDispatchDao.findOrderDispatchByOrderNumber(order.getOrderNumber());
		
		if(orderDispatchs != null && orderDispatchs.size() > 0) {
			OrderDispatch orderDispatch = orderDispatchs.get(0);
			order.setDispatchStatus(orderDispatch.getStatus());
		}
		
		// 订单付款状态
		if(orderPays != null && orderPays.size() > 0) {
			OrderPay orderPay = orderPays.get(0);
			order.setPayStatus(orderPay.getStatus());
		}
		
		info.setOrder(order);
		info.setOrderDetail(details);
		
		
		return info;
	}

	public List<OrderDetail> findOrderDetailByOrderNumber(String orderNumber) {
		return orderDetailDao.findOrderDetailByOrderNumber(orderNumber);
	}
	public List<OrderDetail> findOrderDetailByOrderNumber() {
		return orderDetailDao.findOrderDetailByOrderNumber();
	}
	public List<Orders> findOrderByUserId(Integer userId, Integer siteId) {
		return orderDao.findOrdersByUserId(userId, siteId);
	}

	/**
	 * 订单信息包括明细
	 * 
	 * @return
	 */
	public OrderInfo createOrderInfo(Address address, List<Cart> carts,
			Integer siteId, Integer userId,String invoice,String invoiceType,String invoiceTitle) {
		OrderInfo orderInfo = new OrderInfo();
		Orders order = createorder(address, carts, siteId, userId, invoice, invoiceType, invoiceTitle);
		List<OrderDetail> details = createOrderDetail(carts, userId, order
				.getOrderNumber());
		orderInfo.setOrder(order);
		orderInfo.setOrderDetail(details);
		return orderInfo;
	}

	/**
	 * 返回 order number 订单地址 购物车物品 客户备注 是否所要发票
	 * 
	 * @return
	 */
	private Orders createorder(Address address, List<Cart> carts,
			Integer siteId, Integer userId, String invoice,String invoiceType,String invoiceTitle) {
		Orders order = new Orders();

		/** 生成订单号 **/
		String numbers = createOrderNumber(siteId, userId);
		order.setOrderNumber(numbers);
		// 订单创建时间
		order.setCreatedAt(new Date());
		
		
		if("y".equals(invoice)) {
			order.setInvoice("y");
			order.setInvoiceTitle(invoiceTitle);
			if("0".equals(invoiceType)) {
				order.setInvoiceType(InvoiceTypeEnum.PERSON.name);
			} else {
				order.setInvoiceType(InvoiceTypeEnum.COMPANY.name);
			}
		} else {
			order.setInvoice("n");
		}

		// 设置总价格
		Integer total = PayUtils.total(carts);
		order.setPrice(total);
		order.setCreatedAt(new Date());
		order.setShipaddress(address.getAddress());
		order.setShipcity(address.getProvince());
		
		// TODO 运费到时候要改动态目前1500
		order.setShipfee(0);
		order.setShipname(address.getName());
		order.setQuantity(carts.size());
		order.setPaytype("");
		order.setPoints(PayUtils.totalPoint(carts));
		order.setSiteId(siteId);
		order.setShipprovince(address.getProvince());
		order.setShipsex(address.getSex());
		order.setShipzip(address.getZip());
		order.setUserId(userId);
		order.setShiptel(address.getMobile());
		order.setShipregion(address.getCity());
		order.setStatus(OrderEnum.ORDER_STATUS_PAY.toString());

		// 支付类型
		order.setPaytype(PayType.ALIPAY_PAY.toString());
		return order;
	}

	/**
	 * 生成订单明细
	 * 
	 * @param carts
	 * @return
	 */
	private List<OrderDetail> createOrderDetail(List<Cart> carts,
			Integer userId, String orderNumber) {
		List<OrderDetail> details = new ArrayList<OrderDetail>();
		for (int i = 0; i < carts.size(); i++) {
			OrderDetail detail = new OrderDetail();
			Cart cart = carts.get(i);
			detail.setQuantity(cart.getQty());
			detail.setItemId(cart.getItemId());
			detail.setItemName(cart.getName());
			detail.setUserId(userId);
			detail.setPoint(cart.getPoint());
			detail.setPrice(cart.getPrice());
			detail.setMarketprice(cart.getMarketPrice());
			detail.setOrderNumber(orderNumber);
			detail.setCreatedAt(new Date());
			detail.setAmount(detail.getPrice() * detail.getQuantity());
			details.add(detail);
		}
		return details;
	}

	public void saveOrder(Orders order) {
		orderDao.add(order);
	}

	public void saveDetailOrder(List<OrderDetail> list) {
		orderDetailDao.add(list.toArray(new OrderDetail[0]));
	}

	/**
	 * 创建订单编号
	 * 
	 * @param siteId
	 * @param userId
	 * @return String 
	 */
	private String createOrderNumber(Integer siteId, Integer userId) {
		Integer max = orderSeqDao.getMax(OrderSeqEnum.ORDER_NUMBER_SQE);
		Calendar cal = Calendar.getInstance();
		Integer seqId = max + 1;
		OrderSeq orderSeq = new OrderSeq();
		orderSeq.setType(OrderSeqEnum.ORDER_NUMBER_SQE.toString());
		orderSeq.setSeqId(seqId);
		orderSeq = orderSeqDao.add(orderSeq);
		String siteNum = NumberFormatUtils.format(siteId, "000");
		String orderNum = NumberFormatUtils.format(orderSeq.getSeqId(), "00000000");
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = NumberFormatUtils.format(cal.get(Calendar.MONTH), "00");
		String orderNumber = siteNum + "_" + orderNum + "_" + year + "_" + month;
		return orderNumber;
	}
	
	/**
	 * 专门用来更新状态
	 * @param orderNumber
	 * @param status
	 */
	public void updateStatus(String orderNumber, OrderEnum status) {
		orderDao.updateStatus(orderNumber, status);
	}

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		System.out.println(year);
		System.out.println(cal.get(Calendar.MONTH));

	}
}
