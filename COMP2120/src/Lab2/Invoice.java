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
	
	final Scanner scanner = new Scanner(System.in);
	ArrayList<Item> items = new ArrayList<Item>();
	
	/**
	 * 
	 * @param items Takes an ArrayList<Item> to build
	 * printing object.
	 */
	public Invoice (){
		
	}
	
	/**
	 * On call gets a list of 3 items from a user and stores
	 * the list inside of a private ArrayList<Item>
	 */
	public void getItems() {
		for(int i=1; i<4; i++) {
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
		for(Item item: items) {
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
		System.out.println("--------------------------------------------------"
				+ "-----------------------------");
	}
	
	/**
	 * Helper method that prints the body lines of receipt based
	 * on the Item it receives.
	 * @param name Name of the item.
	 * @param quantity Quantity of the item.
	 * @param price Price of the item.
	 * @param total The total cost of the quantity of item.
	 */
	public void printInfoLine(String name, int quantity, double price, double total) {
		int tabsReduction = name.length() / 8;
		System.out.print(name);
		for(int i=0; i < infoLineTabs - tabsReduction; i++) {
			System.out.print("\t");
		}
		System.out.printf("%d\t$%.2f\t\t$%.2f\n", quantity, price, total);
	}
	
	/**	
	 * Helper function to print a title line for the receipt.
	 */
	public void printTitleLine() {
		System.out.print("Item\t\t\t\t\tQuantity\tPrice\t\tTotal\n");
	}
	
	/**
	 * Helper function to print the footer of the receipt.
	 * @param subtotal The sum of all item costs before taxes.
	 */
	public void printReceiptLine(double subtotal) {
		System.out.printf("Subtotal:\t\t\t\t\t\t\t\t$%.2f\n", subtotal);
		System.out.print("6.25%");
		System.out.printf(" Sales Tax\t\t\t\t\t\t\t\t$%.2f\n", subtotal*0.0625);
		System.out.printf("Total:\t\t\t\t\t\t\t\t\t$%.2f\n", subtotal*1.0625);
	}
	
}
