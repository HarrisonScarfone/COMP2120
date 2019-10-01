package Lab2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Harrison Scarfone 104900846
 *
 */

public class Invoice {

	private final int infoLineTabs = 6;
	private final Scanner scanner = new Scanner(System.in);
	private final ArrayList<Item> items = new ArrayList<Item>();

	/**
	 * 
	 * @param items Takes an ArrayList<Item> to build printing object.
	 */
	public Invoice() {

	}

	/**
	 * On call gets a list of 3 items from a user and stores the list inside of a
	 * private ArrayList<Item>
	 */
	public void getItems() {
		for (int i = 1; i < 4; i++) {
			System.out.print("Item name: ");
			String name = scanner.nextLine();
			System.out.print("Item quantity: ");
			int quantity = scanner.nextInt();
			System.out.print("Item price: ");
			double price = scanner.nextDouble();
			scanner.nextLine();
			Item newItem = new Item(name, price, quantity);
			items.add(newItem);
		}
	}

	/**
	 * Prints the receipt.
	 */
	public void printReceipt() {
		printTitleLine();
		printSeperatorLine();
		double subtotal = 0;
		for (Item item : items) {
			String name = item.getName();
			int quantity = item.getQuantity();
			double price = item.getPrice();
			double total = item.getTotal();
			subtotal += total;
			printInfoLine(name, quantity, price, total);
		}
		printSeperatorLine();
		printReceiptLine(subtotal);
	}

	/**
	 * Helper method to print receipt section seperator.
	 */
	public void printSeperatorLine() {
		System.out.println("--------------------------------------------------" + "-----------------------------");
	}

	public void printInfoLine(String name, int quantity, double price, double total) {
		System.out.printf("%-30s%10d%10.2f%10.2f\n", name, quantity, price, total);		
	}

	/**
	 * Helper function to print a title line for the receipt.
	 */
	public void printTitleLine() {
		System.out.printf("%-30s%10s%10s%10s\n", "Name", "Quantity", "Price", "Total");	
	}

	/**
	 * Helper function to print the footer of the receipt.
	 * 
	 * @param subtotal The sum of all item costs before taxes.
	 */
	public void printReceiptLine(double subtotal) {
		System.out.printf("%-50s%10.2f\n", "Subtotal", subtotal);
		System.out.printf("%-50s%10.2f\n", "6.25% Taxes", subtotal*0.0625);		
		System.out.printf("%-50s%10.2f\n", "Total", subtotal*1.0625);		
		
	}

}
