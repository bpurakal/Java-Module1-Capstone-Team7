package com.techelevator;

import java.math.BigDecimal;

public class ChipItem extends Items {

	public ChipItem(String name, BigDecimal price) {
		super(name, price);
	}

	public String getSound() {
		return "Crunch Crunch, Yum!";
	}

}
