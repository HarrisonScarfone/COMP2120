package Lab2;

import java.util.ArrayList;

public class ReceiptPrinter {
	
	ArrayList<Item> items;
	private int infoLineTabs = 6;
	
	public ReceiptPrinter (ArrayList<Item> items){
		this.items = items;		
	}
	
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
	
	public void printSeperatorLine() {
		System.out.println("--------------------------------------------------"
				+ "-----------------------------");
	}
	
	public void printInfoLine(String name, int quantity, double price, double total) {
		int tabsReduction = name.length() / 8;
		System.out.print(name);
		for(int i=0; i < infoLineTabs - tabsReduction; i++) {
			System.out.print("\t");
		}
		System.out.printf("%d\t$%.2f\t\t$%.2f\n", quantity, price, total);
	}
	
	public void printTitleLine() {
		System.out.print("Item\t\t\t\t\tQuantity\tPrice\t\tTotal\n");
	}
	
	public void printReceiptLine(double subtotal) {
		System.out.printf("Subtotal:\t\t\t\t\t\t\t\t$%.2f\n", subtotal);
		System.out.printf("6.25 Sales Tax\t\t\t\t\t\t\t\t$%.2f\n", subtotal*0.0625);
		System.out.printf("Total:\t\t\t\t\t\t\t\t\t$%.2f\n", subtotal*1.0625);
	}
	
}
