package Lab2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Harrison Scarfone 104900846
 *
 */

public class ItemGetter {
	
	final Scanner scanner = new Scanner(System.in);
	ArrayList<Item> items = new ArrayList<Item>();
	
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
}
