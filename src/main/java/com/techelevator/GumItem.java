package com.techelevator;

import java.math.BigDecimal;

public class GumItem extends Item {

	public GumItem(String name, BigDecimal price) {
		super(name, price);
	}

	public String getSound() {
		return "Chew Chew, Yum!";
	}

}
