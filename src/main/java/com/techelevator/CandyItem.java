package com.techelevator;

import java.math.BigDecimal;

public class CandyItem extends Items {

	public CandyItem(String name, BigDecimal price) {
		super(name, price);
	}
	
	public String getSound() {
		return "Chew Chew, Yum!";
	}

}
