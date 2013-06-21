package com.babailiren.ec.provider;

import com.babailiren.ec.model.Item;

public class PointProvider {

	
	public static Integer getSimplePoint(Item item) {
		if(item.getPoint() != null) {
			return item.getPoint();
		} else {
			int x = item.getPrice() / 100;
			return x;
		}
		
	}
}
