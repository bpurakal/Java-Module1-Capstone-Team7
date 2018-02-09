package com.techelevator;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private static final String PUCHASE_DISPLAY_FEED = "Feed Money";
	private static final String PURCHASE_DISPLAY_SELECT = "Select Product";
	private static final String PURCHASE_DISPLAY_FINAL = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTION = { PUCHASE_DISPLAY_FEED, PURCHASE_DISPLAY_SELECT,
			PURCHASE_DISPLAY_FINAL };
	private static final String PUCHASE_DISPLAY_GO_TO_PURCHASE_MENU = "Exit To Menu";

	private static final String[] FEED_MENU_OPTION = { PUCHASE_DISPLAY_FEED, PURCHASE_DISPLAY_SELECT,
			PURCHASE_DISPLAY_FINAL };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		VendingMachine VM500 = new VendingMachine();
		PurchaseBasket yourCart = new PurchaseBasket();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items

				int counter = 0;

				for (String slotID : VM500.getInventory().keySet()) {

					// COME BACK AND FORMAT THIS BRO

					System.out.println(VM500.getInventory().keySet().toArray()[counter] + " "
							+ VM500.getInventory().get(slotID).toArray()[0] + " \nAmount Left "
							+ VM500.getInventory().get(slotID).size());
					counter++;
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTION, "\nYour current balance is: " + VM500.getBalance());

				if (choice.equals(PUCHASE_DISPLAY_FEED)) {
					VM500.addToBalance(menu.getAmountFromUserInput());
				}

				if (choice.equals(PURCHASE_DISPLAY_SELECT)) {
					System.out.println("What would you like to buy?");
					Scanner userInput = new Scanner(System.in);
					String purchaseKey = userInput.nextLine();
					yourCart.addToBasket(VM500.purchaseItem(purchaseKey));
					System.out.println(VM500.getBoughtItem());
				}

				if (choice.equals(PURCHASE_DISPLAY_FINAL)) {
					System.out.println(VM500.returnChange());
					System.out.println(yourCart.consumeBasket());
				}
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
