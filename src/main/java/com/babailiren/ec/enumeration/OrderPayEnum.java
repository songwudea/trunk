package com.babailiren.ec.enumeration;

public enum OrderPayEnum {
	
	
	// 等待买家支付
	ORDER_PAY_STATUS_BUYER_WAIT("等待买家支付"),

	// 等待卖家确认支付
	ORDER_PAY_STATUS_SELLER_CONFIRM("等待卖家确认支付"),
	
	ORDER_PAY_STATUS_RENDER("退款中"),
	
	// 支付完成
	ORDER_PAY_FINISH("支付完成"),
	
	// 支付验证失败
	ORDER_PAY_VERIFY_FAIL("支付失败");
	
	public String value;
	
	OrderPayEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
