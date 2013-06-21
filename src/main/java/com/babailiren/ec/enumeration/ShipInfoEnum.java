package com.babailiren.ec.enumeration;


public enum ShipInfoEnum {
	EMS("EMS", "http://www.11183.com.cn"), 
	STO("申通", "http://www.sto.cn"), 
	YTO("圆通", "http://www.yto.net.cn"), 
	SF("顺丰", "http://www.sf-express.com"), 
	ZJS("宅急送", "http://www.zjs.com.cn");

	public String name;
	public String url;

	ShipInfoEnum(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}
	
	
}
