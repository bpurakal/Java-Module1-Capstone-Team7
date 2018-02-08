package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		VendingMachine VM500 = new VendingMachine();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items

				int counter = 0;

				for (String slotID : VM500.getInventory().keySet()) {
					System.out.println(VM500.getInventory().keySet().toArray()[counter] + " "
							+ VM500.getInventory().get(slotID).toArray()[0] + " \nAmount Left "
							+ VM500.getInventory().get(slotID).size());
					counter++;
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				System.out.println("What would you like to purchase?");
				Scanner userInput = new Scanner(System.in);
				String userChoice = userInput.nextLine();

			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
		// InventoryReader test = new InventoryReader();
		// try {
		// test.generateInventory();
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// System.out.println(VM500.getInventory());
	}
}
