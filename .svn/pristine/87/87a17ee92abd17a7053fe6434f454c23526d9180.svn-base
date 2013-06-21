package com.babailiren.ec.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.common.Validator;
import com.babailiren.ec.model.Address;
import com.babailiren.ec.model.City;
import com.babailiren.ec.model.Province;
import com.babailiren.ec.model.Site;
import com.babailiren.ec.repository.dao.CityDao;
import com.babailiren.ec.repository.dao.ProvinceDao;
import com.babailiren.ec.service.AddressService;
import com.babailiren.ec.web.common.WebCache;
import com.babailiren.ec.web.common.WebUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/user/address")
public class UserAddressController {
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private CityDao cityDao;
	
	@Autowired
	private ProvinceDao provinceDao;
	
	@Autowired
	private WebCache webCache;
	
	@RequestMapping(value = "addAddress.html", method = RequestMethod.POST)
	public @ResponseBody
	String addAddress(HttpServletRequest request, String name, String province, String city, String address, String zip, String mobile,  String site) {
		Integer userId = WebUtils.getUserId(request);
		Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
		Address addr = new Address();
		addr.setAddress(address);
		addr.setProvince(province);
		addr.setCity(city);
		addr.setZip(zip);
		addr.setMobile(mobile);
		addr.setName(name);
		addr.setMainflag("n");
		addr.setSiteId(currentSite.getId());
		addr.setUserId(userId);
		addr.setCreateAt(new Date());
		addr = addressService.save(addr);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "suss");
		map.put("addid", String.valueOf(addr.getId()));
		Gson gson = new Gson();
		return gson.toJson(map);
	}
	
	@RequestMapping(value = "getCity.html", method = RequestMethod.POST)
	public @ResponseBody
	String getCity(HttpServletRequest request) {
		Integer pid = Integer.valueOf(request.getParameter("pid"));
		List<City> list = addressService.findCityByPid(pid);
		Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJson(list);
	}
	
	@RequestMapping(value = "setDefAddress.html", method = RequestMethod.GET)
	public String setDefAddress(HttpServletRequest request, Integer addressId, String site) {
		Integer userId = WebUtils.getUserId(request);
		Site currentSite = webCache.getSiteByDomain(request.getSession()
				.getServletContext(), site);
		addressService.updateDef2N(currentSite.getId(), userId);
		addressService.updateDef2Y(addressId);
		WebUtils.putSuccessMessage("默认地址设置成功", request);
		return index(request, site);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request, String site) {
		Integer userId = WebUtils.getUserId(request);
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		
		List<Province> provinces = addressService.findProvinces();
		
		List<Address> addresses = addressService.findAddressByUserId(userId);
		// 地址
		request.setAttribute("addresses", addresses);
		
		// 城市
		request.setAttribute("provinces", provinces);
		return WebUtils.themesView(request,currentSite,"address/index");
	}
	
	@RequestMapping(value = "delete.html", method = RequestMethod.GET)
	public String delete(Integer addressId, HttpServletRequest request, String site) {
		addressService.delete(addressId);
		WebUtils.putSuccessMessage("地址删除成功", request);
		return index(request, site);
	}
	
	@RequestMapping(value = "edit.html", method = RequestMethod.POST)
	public String edit(Address address, HttpServletRequest request, String site) {
		Integer userId = WebUtils.getUserId(request);
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		Validator validator = new Validator();
		validator.isNotBlankValidator(address.getAddress(), "请填写详细地址")
				.isNotBlankValidator(address.getMobile(), "请填写手机")
				.isNotBlankValidator(address.getName(), "请填写姓名")
				.isNotBlankValidator(address.getZip(), "请填写邮编");
		if (StringUtils.isNotEmpty(validator.renderHtmlMessage())) {
			WebUtils.putSuccessMessage(validator.renderHtmlMessage(), request);
		} else {
			address.setUserId(userId);
			if(address.getId() == null) {
				address.setCreateAt(new Date());
				address.setCity(cityDao.getCityById(Integer.parseInt(address.getCity())).getCityName());
				address.setProvince(provinceDao.getProvinceById(Integer.parseInt(address.getProvince())).getProvName());
				address.setSiteId(currentSite.getId());
				addressService.save(address);
				WebUtils.putSuccessMessage("地址添加完成", request);
			} else {
				address.setCity(cityDao.getCityById(Integer.parseInt(address.getCity())).getCityName());
				address.setProvince(provinceDao.getProvinceById(Integer.parseInt(address.getProvince())).getProvName());
				address.setSiteId(currentSite.getId());
				address.setUpdateAt(new Date());
				addressService.update(address);
				request.setAttribute("message", "地址更新完成");
			}
		}
		return index(request, site);
	}
}
