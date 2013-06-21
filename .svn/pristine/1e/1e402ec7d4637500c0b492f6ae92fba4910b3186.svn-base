package com.babailiren.ec.web.common;

import com.babailiren.ec.model.GridDataModel;
import com.babailiren.ec.repository.Page;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Pager<T> {
	public String getJsonPagerData(Page<T> page) {
		long total = page.getTotalItems();
		long end = page.getPageNo() + page.getPageSize();
		end = end > total ? total : end;

		GridDataModel<T> model = new GridDataModel<T>();
		model.setRows(page.getResult());
		model.setTotal(page.getTotalItems());
		Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJson(model);
	}
}
