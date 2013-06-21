package com.babailiren.ec.model;

@SuppressWarnings("serial")
public class Promotion implements java.io.Serializable {
	
	private int id;

	private int reducePrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReducePrice() {
		return reducePrice;
	}

	public void setReducePrice(int reducePrice) {
		this.reducePrice = reducePrice;
	}
	
}
