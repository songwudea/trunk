package com.babailiren.ec.web.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.babailiren.ec.model.PriceFilter;
import com.babailiren.ec.service.PriceFilterService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/admin/price")
public class PriceFilterController {

	@Autowired
	private PriceFilterService priceFilterService;

	@RequestMapping(value = "edit.html", method = RequestMethod.POST)
	public String edit(Integer[] rangeMaxs, Integer[] rangeMins,
			Integer siteId, HttpServletRequest request) {
		
		priceFilterService.delBySiteId(siteId);
		
		List<PriceFilter> list = new ArrayList<PriceFilter>();
		
		if(rangeMins == null) {
			request.setAttribute("message", "请填写价格属性");
			return view(siteId, request);
		}
		
		for (int i = 0; i < rangeMins.length; i++) {
			PriceFilter filter = new PriceFilter();
			int mix = rangeMins[i];
			int max = rangeMaxs[i];
			filter.setSiteId(siteId);
			filter.setRangeMax(max);
			filter.setRangeMin(mix);
			list.add(filter);
		}
		priceFilterService.save(list);

		request.setAttribute("message", "价格属性设置成功");
		return view(siteId, request);
	}

	@RequestMapping(value = "view.html", method = RequestMethod.GET)
	public String view(Integer siteId, HttpServletRequest request) {
		List<PriceFilter> list = priceFilterService.findPriceFilter(siteId);
		Gson gson = new GsonBuilder().serializeNulls().create();
		String price = gson.toJson(list);
		request.setAttribute("price", price);
		request.setAttribute("siteId", siteId);
		return "admin/price/view";
	}

}
