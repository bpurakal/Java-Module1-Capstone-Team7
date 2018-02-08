package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


public class InventoryReader {
	
	public Map generateInventory() throws FileNotFoundException {
		
		File inputFile = getInventoryFile();
		
		Stack<Items> itemsStack = new Stack<>();  // come back and give this a better name
		
		Map<String, Stack<Items>> inventory = new HashMap<>();
		
		try (Scanner fileScanner = new Scanner(inputFile)) {
	        while (fileScanner.hasNextLine()) { // while it can read file until no more new lines
	            String line = fileScanner.nextLine();// grab the new line
	            String[] itemIDNameAndPrice = line.split("|");
	            for(int i = 0; i < 5; i++) {
	            		Items test = new Items(itemIDNameAndPrice[1], new BigDecimal ("itemIDNameAndPrice[2]"));
	            		itemsStack.push(test);
	            }
	            inventory.put(itemIDNameAndPrice[0], itemsStack);
	        }
	    }
		return inventory;
	}
	@SuppressWarnings("resource")
	private static File getInventoryFile() {

		File inventoryFile = new File("vendingmachine.csv");
		if (inventoryFile.exists() == false) { // checks for the existence of a file
			System.out.println("vendingmachine.csv does not exist");
			System.exit(1); // Ends the program
		} else if (inventoryFile.isFile() == false) { // a file is normal if it is not a directory
			System.out.println("vendingmachine.csv is not a file");
			System.exit(1); // Ends the program
		}
		return inventoryFile;
	}

}
