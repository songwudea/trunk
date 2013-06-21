package com.babailiren.ec.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.constants.Constants;
import com.babailiren.ec.enumeration.OrderRefundEnum;
import com.babailiren.ec.model.Refund;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.RefundService;
import com.babailiren.ec.web.common.Pager;
import com.babailiren.ec.web.session.BackSession;

@Controller
@RequestMapping("/admin/refund")
public class RefundController {
	
	@Autowired
	private RefundService refundService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		request.setAttribute("status", OrderRefundEnum.values());
		return "admin/refund/index";
	}
	
	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(Refund refund, Page<Refund> page, HttpServletRequest request,
			HttpServletResponse response) {
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		refund.setSiteId(backSession.getSiteId());
		page = refundService.list(page, refund);
		return new Pager<Refund>().getJsonPagerData(page);
	}
	
	@RequestMapping(value = "comfireRefund.html", method = RequestMethod.POST)
	public @ResponseBody
	String comfireRefund(Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
			String name = backSession.getAccount();
			refundService.updateStatus(id, name, OrderRefundEnum.ORDER_REFUND_STATUS_COMFIRE.toString());
			return "suss";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
}
