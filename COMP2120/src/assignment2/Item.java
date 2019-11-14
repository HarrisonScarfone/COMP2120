package assignment2;

import java.io.Serializable;

@SuppressWarnings("serial")
abstract class Item implements Serializable{
	
	public static int counter = 0;	
	
	protected final int id;
	protected double price;
	protected int quantity;
	protected String classification;
	
	public Item() {
		this(0.0, 0, "");
	}
	
	public Item(double price, int quantity, String classification) {
		this.id = ++counter;
		setPrice(price);
		setQuantity(quantity);
		setClassification(classification);
	}
	
	public abstract void display();
	
	public void purchase(int purchaseQuantity) {
		if(quantity >= purchaseQuantity) {
			quantity -= purchaseQuantity;
		}
	}
	
	public void setPrice(double price) {
		if(price >= 0) {
			this.price = price;
		}else {
			this.price = 0;
		}
		
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setQuantity(int quantity) {
		if(quantity >= 0 ) {
			this.quantity = quantity;
		}else {
			this.quantity = 0;
		}
	}
	
	public void setClassification(String classification) {
		if(classification.isBlank() || classification.isEmpty()) {
			this.classification = "No Value";
		}else {
			this.classification = classification;
		}
	}
	
	public String getClassification() {
		return classification;
	}
}
