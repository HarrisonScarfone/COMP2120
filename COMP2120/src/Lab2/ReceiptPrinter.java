package Lab2;

import java.util.ArrayList;

/**
 * 
 * @author Harrison Scarfone 104900846
 *
 */

public class ReceiptPrinter {
	
	ArrayList<Item> items;
	private int infoLineTabs = 6;
	
	/**
	 * 
	 * @param items Takes an ArrayList<Item> to build
	 * printing object.
	 */
	public ReceiptPrinter (ArrayList<Item> items){
		this.items = items;		
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
		System.out.printf("6.25 Sales Tax\t\t\t\t\t\t\t\t$%.2f\n", subtotal*0.0625);
		System.out.printf("Total:\t\t\t\t\t\t\t\t\t$%.2f\n", subtotal*1.0625);
	}
	
}
