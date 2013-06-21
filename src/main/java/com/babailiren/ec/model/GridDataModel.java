package com.babailiren.ec.model;

import java.util.ArrayList;
import java.util.List;

public class GridDataModel<T> {
	// 显示的总数
	private long total;
	// 行数据
	private List<T> rows = new ArrayList<T>();

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

}
