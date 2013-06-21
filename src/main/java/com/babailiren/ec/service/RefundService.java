package com.babailiren.ec.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babailiren.ec.enumeration.OrderRefundEnum;
import com.babailiren.ec.model.OrderPay;
import com.babailiren.ec.model.Orders;
import com.babailiren.ec.model.Refund;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.repository.dao.OrderPayDao;
import com.babailiren.ec.repository.dao.RefundDao;

@Service
public class RefundService {
	
	@Autowired
	private RefundDao refundDao;
	
	@Autowired
	private OrderPayDao orderPayDao;

	public void createRefund(Orders order, OrderPay orderPay, Integer employeeId, String employeeName, Integer siteId) {
		Refund refund = new Refund();
		refund.setAccount(orderPay.getBuyer());
		refund.setCreateByEmployeeName(employeeName);
		refund.setOrderNumber(order.getOrderNumber());
		refund.setCreatedAt(new Date());
		refund.setPrice(order.getPrice());
		refund.setSiteId(siteId);
		refund.setStatus(OrderRefundEnum.ORDER_REFUND_STATUS_WAIT.toString());
		refundDao.add(refund);
	}
	
	public Refund getById(Integer id) {
		return refundDao.getByPK(id);
	}
	
	/**
	 * 整单退款check 只能下一次退款单
	 * @return
	 */
	public boolean checkRefundOnly(String orderNumber) {
		List<Refund> refunds = refundDao.findRefundByOrderNumber(orderNumber);
		if(refunds.size() >= 1) {
			return false;
		}
		return true;
	}
	
	/**
	 * 检查 退款表中 退款额度与支付表中支付额度
	 * @return
	 */
	public boolean checkRefund(String orderNumber) {
		// 1. 获取用户的支付单
		// 2. 因为这个童话只有一条支付,所以就拿第一条
		// TODO 以后这里需要改
		
		List<OrderPay> orderPays = orderPayDao.findOrderPayByOrderNumber(orderNumber);
		
		// 前面check过了 所以不会出现null
		OrderPay orderPay = orderPays.get(0);
		
		// 支付金额
		Long orderPayPrice = Long.parseLong(orderPay.getPayAmount().toString());
		
		// 退款金额
		Long sumRefundPrice = refundDao.sumRefundPrice(orderNumber);
		
		// 退款金额累加超过支付金额
		if(sumRefundPrice > orderPayPrice) {
			return false;
		}
		return true;
	}
	
	
	public List<Refund> findRefundByOrderNumber(String orderNumber) {
		return refundDao.findRefundByOrderNumber(orderNumber);
	}
	
	public void updateStatus(Integer id, String name, String status) {
		refundDao.update(id, name, status);
	}
	
	
	public Page<Refund> list(Page<Refund> page, Refund refund) {
		return refundDao.findRefundPageBySiteId(page, refund);
	} 
}
