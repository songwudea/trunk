package com.babailiren.ec.enumeration;

public enum InvoiceTypeEnum {
	PERSON(0,"个人"),
	COMPANY(1,"单位");
	public int id;
	public String name;
	
	InvoiceTypeEnum(int id,String name) {
		this.id = id;
		this.name = name;
	}
}
