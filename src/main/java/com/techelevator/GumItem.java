package com.techelevator;

import java.math.BigDecimal;

public class GumItem extends Items {

	public GumItem(String name, BigDecimal price) {
		super(name, price);
	}

	public String getSound() {
		return "Chew Chew, Yum!";
	}

}
