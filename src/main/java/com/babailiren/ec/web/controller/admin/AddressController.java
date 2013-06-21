package com.babailiren.ec.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.model.Address;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.AddressService;
import com.babailiren.ec.web.common.Pager;

@Controller
@RequestMapping("/admin/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Integer userId,HttpServletRequest request) {
		if (userId != null && !"".equals(userId)) {
			request.setAttribute("callBackMethod", "singleList.html?userId="+userId);
		}else{
			request.setAttribute("callBackMethod", "list.html");
		}
		return "admin/address/index";
	}
	
	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(Address address,Integer userid, Page<Address> page,
			HttpServletRequest request, HttpServletResponse response) {
		page = addressService.list(page, address);
		return new Pager<Address>().getJsonPagerData(page);
	}
	
	@RequestMapping(value = "singleList.html", method = RequestMethod.POST)
	public @ResponseBody
	String singleList(Integer userId, Page<Address> page,
			HttpServletRequest request, HttpServletResponse response) {
		page = addressService.findAddressByUserIdPage(page, userId);
		return new Pager<Address>().getJsonPagerData(page);
	}
	
}
