package com.babailiren.ec.pay;

import java.util.List;

import com.babailiren.ec.model.Cart;

public class PayUtils {
	
	public static Integer totalPoint(List<Cart> carts) {
		int point = 0;
		for(int i = 0; i < carts.size(); i++) {
			Cart cart = carts.get(i);
			point += cart.getPoint();
		}
		return point;
	}
	
	public static Integer total(List<Cart> carts) {
		int total = 0;
		for(int i = 0; i < carts.size(); i++) {
			Cart cart = carts.get(i);
			total += cart.getPrice() * cart.getQty();
		}
		return total;
	}
}
