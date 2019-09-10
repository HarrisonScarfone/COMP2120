package Lab2;
/**
 * 
 * @author Harrison Scarfone 104900846
 *
 */
public class Item {	
	
	private String name;
	private double price;
	private int quantity;
	
	/**
	 * 
	 * @param n 
	 * @param p
	 * @param q
	 */
	public Item(String name, double price, int quantity) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getTotal() {
		return price*quantity;
	}
			
}
