package assignment2;

/*
 * By: Harrison Scarfone
 * Student Number: 104900846
 * This program is an inventory manager written for assignment 2
 */

import java.util.Scanner;

public class Main {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("==========================");
		System.out.println("Inventory Control System");
		System.out.println("==========================");
		System.out.println("1. Load Inventory Manager");
		System.out.println("2. New Inventory Manager");
		System.out.println("==========================");
		switch(getChoiceInput()) {
		case 1:
			InventoryManager imLoad = new InventoryManager();
			imLoad.loadLinkedList();
			imLoad.runInventoryManager();
			break;
		case 2:
			InventoryManager imNew = new InventoryManager();
			imNew.runInventoryManager();
			break;
		default:
			System.out.println("Invalid entry.  Now exiting.");
			break;
		}	
	}
	
	public static int getChoiceInput() {
		System.out.printf("Enter choice number: ");
		String input = scanner.nextLine();
		try {
			return Integer.parseInt(input);
		}catch(Exception e){
			System.out.println("Invalid choice. Try again.");
			return getChoiceInput();
		}
	}
}
