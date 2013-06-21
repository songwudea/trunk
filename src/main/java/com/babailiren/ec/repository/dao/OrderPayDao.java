package com.babailiren.ec.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.common.NumberFormatUtils;
import com.babailiren.ec.enumeration.OrderPayEnum;
import com.babailiren.ec.model.OrderPay;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "order_pay")
public class OrderPayDao extends JdbcEntityDao<OrderPay, Integer> {
	
	public Page<OrderPay> findOrderPayPage(Page<OrderPay> page, OrderPay orderPay, Integer siteId) {
		String siteNum = NumberFormatUtils.format(siteId, "000");
		StringBuffer sb = new StringBuffer();
		sb.append(" select order_pay.*, users.name as userName from order_pay ");
		sb.append(" left join users on users.id = order_pay.user_id ");
		sb.append(" where order_pay.order_number like '" + siteNum + "_%' ");
		List<Object> list = new ArrayList<Object>();
		if(orderPay.getPayNumber() != null && !"".equals(orderPay.getPayNumber())) {
			sb.append(" and order_pay.pay_number like ?");
			list.add("%" + orderPay.getPayNumber() + "%");
			
		}
		
		if(orderPay.getUserName() != null && !"".equals(orderPay.getUserName())) {
			sb.append(" and users.name = ?");
			list.add(orderPay.getUserName());
		}
		
		if(orderPay.getTradeNumber() != null && !"".equals(orderPay.getTradeNumber())) {
			sb.append(" and order_pay.trade_number = ?");
			list.add(orderPay.getTradeNumber());
		}
		
		if(orderPay.getStatus() != null && !"".equals(orderPay.getStatus()) && !"all".equals(orderPay.getStatus())) {
			sb.append(" and order_pay.status = ?");
			list.add(orderPay.getStatus());
		}
		
		page = findPage(page, sb.toString(), list.toArray());
		return page;
	}

	/**
	 * 专门用来更新订单状态
	 * 
	 * @param orderNumber
	 * @param status
	 */
	public void updateBuyer(String buyer,String payNumber) {
		String sql = " update order_pay set buyer = ? where pay_number = ? ";
		this.getJdbcTemplate().update(sql, buyer, payNumber);
	}
	
	public void updateStatus(String tradeNumber,String payNumber, OrderPayEnum status) {
		String sql = " update order_pay set status = ? ,trade_number = ? where pay_number = ? ";
		this.getJdbcTemplate().update(sql, status.toString(), tradeNumber,payNumber);
	}

	public void updateStatusWithConfirm(String payNumber,
			OrderPayEnum status, String userName) {
		String sql = " update order_pay set confirm_employee_name = ?, status = ?, confirm_at = now() where pay_number = ?  ";
		this.getJdbcTemplate().update(sql, userName, status.toString(),
				payNumber);
	}

	public List<OrderPay> findOrderPayByOrderNumber(String orderNumber) {
		String sql = " select * from order_pay where order_pay.order_number = ? ";
		return find(sql, orderNumber);
	}

	public OrderPay getOrderPayByPayNumber(String payNumber) {
		String sql = " select * from order_pay where order_pay.pay_number = ? ";
		return get(sql, payNumber);
	}
	
}
