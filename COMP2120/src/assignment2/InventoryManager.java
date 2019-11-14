package assignment2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


@SuppressWarnings("serial")
public class InventoryManager implements Serializable{
	
	private static LinkedList<Item> inventory; 
	private static final Scanner scanner = new Scanner(System.in); 
	private static final String filename = "savedInventory.ser";
	
	public InventoryManager() {
		InventoryManager.inventory = new LinkedList<Item>();
		//this.scanner = new Scanner(System.in);	
	}
	
	public void runInventoryManager() {
		int choice;
		do{
			displayMenu();
			choice = getChoiceInput();
			handleMenuInput(choice);
		}while(choice != 8);
	}
	
	public void handleMenuInput(int choice) {
		switch(choice) {
		case 1:
			addItem();
			break;
		case 2:
			displayAll();
			break;
		case 3:
			showBooksByAuthor();
			break;
		case 4:
			showGiftsByLabel();
			runInventoryManager();
			break;
		case 5:
			showShoesBySize();
			break;
		case 6:
			deleteItemById();
			break;
		case 7:
			purchaseItem();
			break;
		case 8:
			System.out.println("Saving and exiting.");
			saveLinkedList();
			System.exit(0);
			break;
		default:
			System.out.println("Invadid option.");	
		}
	}
	
	public void displayMenu() {
		System.out.println("==========================");
		System.out.println("Inventory Control System");
		System.out.println("==========================");
		System.out.println("1. Add Item");
		System.out.println("2. Display All Items");
		System.out.println("3. Show Books by Author");
		System.out.println("4. Show Gift Cards by Label");
		System.out.println("5. Show Shoes by Size");
		System.out.println("6. Delete Item by ID");
		System.out.println("7. Purchase Item by ID");
		System.out.println("8. Exit and Save");
		System.out.println("==========================");
	}
	
	public void saveLinkedList() {
		try {
	        FileOutputStream file = new FileOutputStream(filename); 
	        ObjectOutputStream out = new ObjectOutputStream(file); 

	        out.writeObject(inventory); 
	            
	        out.close(); 
	        file.close(); 
	              
	        System.out.println("Inventory saved succesfully."); 
	        }catch(Exception e) {
	        	System.out.println("Inventory was not saved succesfully.");
	        } 
	}
	
	//will always be a java standard linked list
	@SuppressWarnings("unchecked")
	public void loadLinkedList() {
	     try {
	         FileInputStream file = new FileInputStream(filename); 
	         ObjectInputStream in = new ObjectInputStream(file); 
	              
	         inventory = (LinkedList<Item>)in.readObject(); 
	              
	         in.close(); 
	         file.close(); 
	              
	         System.out.println("Inventory has been loaded."); 
	        }catch(Exception e) {
	        	System.out.println("Couldnt load an inventory.");
	        }

	        runInventoryManager();
	}
	
	public void addItem() {
		System.out.printf("Enter Type (b: Book, g: Gift Card, s: Shoe):");
		String choice = scanner.nextLine();
		switch(choice) {
		case "b":
			addBook();
			break;
		case "g":
			addGiftCard();
			break;
		case "s":
			addShoe();
			break;
		default:
			System.out.println("Invalid choice.");
			addItem();
		}				
	}
	//System.out.println("" + price + "," + quantity + ',' + title + "," + author + "," + year);
	public void addBook() {
		double price = getPriceInput();
		int quantity = getQuantityInput();
		System.out.printf("Enter the book title: ");
		String title = scanner.nextLine();
		System.out.printf("Enter the author: ");
		String author = scanner.nextLine();
		int year = getYearInput();
		inventory.add(new Book(price, quantity, author, title, year));
	}
	
	public void addGiftCard() {
		double price = getPriceInput();
		int quantity = getQuantityInput();
		System.out.printf("Enter label: ");
		String label = scanner.nextLine();
		System.out.printf("Enter manufacturer: ");
		String manufacturer = scanner.nextLine();
		inventory.add(new GiftCard(price, quantity, label, manufacturer));
	}
	
	public void addShoe() {
		double price = getPriceInput();
		int quantity = getQuantityInput();
		System.out.println("Color options are: white, silver, red, beige, brown, blue, black, pink");
		System.out.printf("Enter the color: ");
		String color = scanner.nextLine();
		double size = getSizeInput();
		inventory.add(new Shoe(price, quantity, color, size));
	}
	
	public double getPriceInput() {
		System.out.printf("Enter price: ");
		String input = scanner.nextLine();
		try {
			return Double.parseDouble(input);
		}catch(Exception e){
			System.out.println("Invalid price. Try again.");
			return getPriceInput();
		}
	}
	
	public double getSizeInput() {
		System.out.printf("Enter size: ");
		String input = scanner.nextLine();
		try {
			return Double.parseDouble(input);
		}catch(Exception e){
			System.out.println("Invalid size. Try again.");
			return getSizeInput();
		}
	}
	
	public int getQuantityInput() {
		System.out.printf("Enter quantity: ");
		String input = scanner.nextLine();
		try {
			return Integer.parseInt(input);
		}catch(Exception e){
			System.out.println("Invalid quantity. Try again.");
			return getQuantityInput();
		}
	}
	
	public int getYearInput() {
		System.out.printf("Enter year: ");
		String input = scanner.nextLine();
		try {
			return Integer.parseInt(input);
		}catch(Exception e){
			System.out.println("Invalid year. Try again.");
			return getYearInput();
		}
	}
	
	public int getChoiceInput() {
		System.out.printf("Enter choice number: ");
		String input = scanner.nextLine();
		try {
			return Integer.parseInt(input);
		}catch(Exception e){
			System.out.println("Invalid choice. Try again.");
			return getChoiceInput();
		}
	}
	
	public int getDeleteIdInput() {
		System.out.printf("Enter id to delete: ");
		String input = scanner.nextLine();
		try {
			return Integer.parseInt(input);
		}catch(Exception e){
			System.out.println("Invalid id. Try again.");
			return getDeleteIdInput();
		}
	}
	
	public int getPurchaseIdInput() {
		System.out.printf("Enter id to purchase: ");
		String input = scanner.nextLine();
		try {
			return Integer.parseInt(input);
		}catch(Exception e){
			System.out.println("Invalid id. Try again.");
			return getPurchaseIdInput();
		}
	}
	
	public int getPurchaseQuantityInput() {
		System.out.printf("Enter quantity to purchase: ");
		String input = scanner.nextLine();
		try {
			return Integer.parseInt(input);
		}catch(Exception e){
			System.out.println("Invalid quantity. Try again.");
			return getPurchaseQuantityInput();
		}
	}
	
	public void displayAll() {
		System.out.println("Inventory Contents: ");
		for(Item i: inventory) {
			System.out.println("--------------------");
			i.display();
			
		}
	}
	
	public void showBooksByAuthor() {
		LinkedList<Book> books = new LinkedList<Book>();
		for(Item i: inventory) {
			if(i.classification.equals("Book")) {
				books.add((Book) i);
			}
		}
		Collections.sort(books, new BookSort());
		System.out.println("Books Sorted by Author");
		System.out.println("--------------------");
		for(Book b: books) {
			System.out.println("--------------------");
			b.display();
		}
	}
	
	public void showGiftsByLabel() {
		LinkedList<GiftCard> giftCards = new LinkedList<GiftCard>();
		for(Item i: inventory) {
			if(i.classification.equals("Gift Card")) {
				giftCards.add((GiftCard) i);
			}
		}
		Collections.sort(giftCards, new GiftSort());
		System.out.println("Gift Cards Sorted by Label");
		System.out.println("--------------------");
		for(GiftCard g: giftCards) {
			System.out.println("--------------------");
			g.display();
		}
	}
	
	public void showShoesBySize() {
		LinkedList<Shoe> shoes = new LinkedList<Shoe>();
		for(Item i: inventory) {
			if(i.classification.equals("Shoe")) {
				shoes.add((Shoe) i);
			}
		}
		Collections.sort(shoes, new ShoeSort());
		System.out.println("Shoes Sorted by Size");
		System.out.println("--------------------");
		for(Shoe s: shoes) {
			System.out.println("--------------------");
			s.display();
		}
	}
	
	public void deleteItemById() {
		System.out.printf("Enter the id of the item to delete: ");
		int deleteId = getDeleteIdInput();
		for(int i=0; i<inventory.size(); i++) {
			if(inventory.get(i).id == deleteId) {
				inventory.remove(i);
				return;
			}
		}
		System.out.println("Item id not found. No Item Deleted.");
	}
	
	public void purchaseItem() {
		int purchaseId = getPurchaseIdInput();
		int purchaseQuantity = getPurchaseQuantityInput();
		for(int i=0; i<inventory.size(); i++) {
			if(inventory.get(i).id == purchaseId) {
				inventory.get(i).purchase(purchaseQuantity);
				return;
			}
		}
		System.out.println("Couldnt make the purchase. Something went wrong.");
	}
}