package com.babailiren.ec.web.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.common.Validator;
import com.babailiren.ec.constants.Constants;
import com.babailiren.ec.model.Brand;
import com.babailiren.ec.model.Category;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.BrandService;
import com.babailiren.ec.web.common.Pager;
import com.babailiren.ec.web.session.BackSession;
import com.babailiren.ec.web.vo.ComboBoxModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/admin/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "admin/brand/index";
	}
	
	@RequestMapping(value = "getBrands.html", method = RequestMethod.POST)
	public @ResponseBody
	String getBrands(Category category, HttpServletRequest request) {
		List<Brand> brands = brandService.findBrandsByCid(category.getId());
		List<ComboBoxModel> list = new ArrayList<ComboBoxModel>();
		Integer bid = NumberUtils.toInt(request.getParameter("bid"), 0);
		for(int i = 0;i < brands.size(); i++) {
			ComboBoxModel combo = new ComboBoxModel();
			combo.setId(brands.get(i).getId());
			combo.setText(brands.get(i).getName());
			if(bid == combo.getId()) {
				combo.setSelected(true);
			}
			list.add(combo);
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJson(list);
	}
	
	@RequestMapping(value = "edit.html", method = RequestMethod.POST)
	public String edit(@ModelAttribute("brand") Brand brand,
			HttpServletRequest request) {
		Validator validator = new Validator();
		validator.isNotBlankValidator(brand.getName(), "请填写品牌名");
		BackSession backSession = (BackSession)request.getSession().getAttribute(Constants.BACK_EMPLOYEE_SESSION);
		if (StringUtils.isNotEmpty(validator.renderHtmlMessage())) {
			request.setAttribute("message", validator.renderHtmlMessage());
		} else {
			if (brand.getId() == null) {
				brand.setCategoryId(0);
				brand.setSiteId(backSession.getSiteId());
				brand.setCreatedAt(new Date());
				brand.setUpdatedAt(new Date());
				brandService.save(brand);
				request.setAttribute("message", "品牌信息增加成功");
			} else {
				brandService.update(brand);
				request.setAttribute("message", "品牌信息修改成功");
			}
		}
		return "admin/brand/edit";
	}
	
	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public String edit(Integer brandId, HttpServletRequest request) {
		if (brandId != null) {
			Brand brand = brandService.getBrand(brandId);
			request.setAttribute("model", brand);
		}
		return "admin/brand/edit";
	}
	
	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(Brand brand, Page<Brand> page,
			HttpServletRequest request, HttpServletResponse response) {
		page = brandService.list(page, brand);
		return new Pager<Brand>().getJsonPagerData(page);
	}
	
	
}
