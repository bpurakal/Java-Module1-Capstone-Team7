package com.techelevator;

import java.math.BigDecimal;

public abstract class Items {
	private String name;
	private BigDecimal price;
	
	public Items (String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return name + " , " + price;
	}

}
