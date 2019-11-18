package assignment2;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Shoe extends Item implements Serializable{
	
	public final static String identifier = "Shoe";
	
	enum Colors{
		white, silver, red, beige, brown, blue, black, pink	
	}
	
	private double size;
	private String color;
	
	public Shoe() {
		this(0.0, 0, "", 0);
	}
	
	public Shoe(double price, int quantity, String color, double size) {
		super(price, quantity, identifier);
		setSize(size);
		setColor(color);
	}
	
	@Override
	public void display() {
		System.out.printf("Type: \t\t%s\nId: \t\t%d\nPrice: \t\t$%.2f\nQuantity: \t%d\n"
				+ "Size: \t\t%.1f\nColor: \t\t%s\n", classification, id, price, quantity, size, color);	
	}
	
	public boolean validateColor(String color) {
		for(Colors c: Colors.values()) {
			if(c.name().equals(color)) {
				return true;
			}
		}
		return false;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		if(size > 0) {
			this.size = size;
		}else {
			size = 0;
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if(validateColor(color)) {
			this.color = color;
		}else {
			this.color = "undefined";
		}
	}
	
}
