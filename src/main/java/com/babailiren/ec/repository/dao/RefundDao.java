package com.babailiren.ec.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.babailiren.ec.model.Refund;
import com.babailiren.ec.repository.EntityDao;
import com.babailiren.ec.repository.JdbcEntityDao;
import com.babailiren.ec.repository.Page;

@Repository
@EntityDao(Table = "refund")
public class RefundDao extends JdbcEntityDao<Refund, Integer> {
	
	
	public Page<Refund> findRefundPageBySiteId(Page<Refund> page, Refund refund) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from refund ");
		sb.append(" where refund.site_id = ? ");
		List<Object> list = new ArrayList<Object>();
		list.add(refund.getSiteId());
		page = findPage(page, sb.toString(), list.toArray());
		return page;
	}
	
	public List<Refund> findRefundByOrderNumber(String orderNumber) {
		StringBuffer sb = new StringBuffer(" select * from refund where refund.order_number = ? ");
		return find(sb.toString(), orderNumber);
	}
	
	/**
	 * 根据 订单号计算 多次退款
	 * @param orderNumber
	 * @return
	 */
	public Long sumRefundPrice(String orderNumber) {
		String sql = " select sum(refund.price) from refund where refund.orderNumber = ? ";
		return this.getJdbcTemplate().queryForLong(sql, orderNumber);
	}
	
	public void update(Integer id, String name, String status) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update refund ");
		sb.append(" set refund.confirm_by_employee_name = ?, ");
		sb.append(" refund.status = ?, ");
		sb.append(" refund.refund_date = now() ");
		sb.append(" where id = ? ");
		this.getJdbcTemplate().update(sb.toString(), name, status, id);
	}
}
