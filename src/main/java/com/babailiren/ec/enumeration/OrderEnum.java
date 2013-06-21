package com.babailiren.ec.enumeration;

public enum OrderEnum {
	// 订单流程支付中
	ORDER_STATUS_PAY("支付中"),
	// 订单流程发货中
	ORDER_STATUS_DISPATCH("发货中"),
	// 订单流程发货完成
	ORDER_STATUS_FINISH("发货完成"),
	// 订单退款中
	ORDER_STATUS_REFUND("退款中"),
	// 订单流程取消
	ORDER_STATUS_CANEL("交易取消");

	public String value;

	OrderEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
