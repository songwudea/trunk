package com.babailiren.ec.enumeration;

public enum SortAttrEnum {
	
	SALES(1,"销量"),
	PRICE(2,"价格"),
	COMMENT(4,"评论"),
	TIME(5,"上架时间");
	public int id;
	public String name;
	
	SortAttrEnum(int id,String name) {
		this.id = id;
		this.name = name;
	}
}
