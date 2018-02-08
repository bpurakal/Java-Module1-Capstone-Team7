package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Stack;

public class VendingMachine {
	
	private Map<String, Stack<Items>> inventory;
	
	public VendingMachine() throws FileNotFoundException {
		InventoryReader someCrazyShit = new InventoryReader();
		inventory = someCrazyShit.generateInventory();
	}

	public Map<String, Stack<Items>> getInventory() {
		return inventory;
	}

}
