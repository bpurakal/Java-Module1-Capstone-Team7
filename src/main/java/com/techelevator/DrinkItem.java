package com.techelevator;

import java.math.BigDecimal;

public class DrinkItem extends Item {

	public DrinkItem(String name, BigDecimal price) {
		super(name, price);
	}

	public String getSound() {
		return "Glug Glug, Yum!";
	}

}
