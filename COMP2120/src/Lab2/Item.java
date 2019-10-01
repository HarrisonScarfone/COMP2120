package Lab2;
/**
 * 
 * @author Harrison Scarfone 104900846
 *
 */
public class Item {	
	
	private final String name;
	private final double price;
	private final int quantity;
	
	/**
	 * 
	 * @param n The name of the item.
	 * @param p The price of the item.
	 * @param q The quantity of the items being purchased. Only
	 * allows for whole number purchases.
	 */
	public Item(String name, double price, int quantity) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	/**
	 * 
	 * @return The name of the item.
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return The quantity of the item.
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * 
	 * @return The price of the item.
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * 
	 * @return The total price of the item (price * quantity).
	 */
	public double getTotal() {
		return price*quantity;
	}
			
}
