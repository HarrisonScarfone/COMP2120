package lab2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Harrison Scarfone 104900846
 *
 */

public class Invoice {

	private final Scanner scanner = new Scanner(System.in);
	private final ArrayList<Item> items = new ArrayList<Item>();
	private int howManyItems;

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
		System.out.println("How many items? ");
		howManyItems = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i < howManyItems+1; i++) {
			System.out.printf("Input name of item %d: \n", i);
			String name = scanner.nextLine();
			System.out.printf("Item Quantity of item %d: \n", i);
			int quantity = scanner.nextInt();
			System.out.printf("input price of item %d: \n", i);
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
		System.out.print("\n\n\nYour bill:\n");
		printTitleLine();
		double subtotal = 0;
		for (Item item : items) {
			String name = item.getName();
			int quantity = item.getQuantity();
			double price = item.getPrice();
			double total = item.getTotal();
			subtotal += total;
			printInfoLine(name, quantity, price, total);
		}
		System.out.println();
		printReceiptLine(subtotal);
	}
	
	/**
	 * Prints an information line in the receipt.
	 * @param name Name of the item to be printed. 
	 * @param quantity Quantity of the item.
	 * @param price Price of the item.
	 * @param total Total price of that particular item.
	 */
	public void printInfoLine(String name, int quantity, double price, double total) {
		System.out.printf("%-30s%10d%10.2f%10.2f\n", name, quantity, price, total);		
	}

	/**
	 * Helper function to print a title line for the receipt.
	 */
	public void printTitleLine() {
		System.out.printf("%-30s%10s%10s%10s\n", "Item", "Quantity", "Price", "Total");	
	}

	/**
	 * Helper function to print the footer of the receipt.
	 * 
	 * @param subtotal The sum of all item costs before taxes.
	 */
	public void printReceiptLine(double subtotal) {
		System.out.printf("%-50s%10.2f\n", "Subtotal", subtotal);
		System.out.printf("%-50s%10.2f\n", "6.25% sales taxes", subtotal*0.0625);		
		System.out.printf("%-50s%10.2f\n", "Total", subtotal*1.0625);		
		
	}

}
