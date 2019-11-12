package assignment2;

import java.io.Serializable;

@SuppressWarnings("serial")
public class GiftCard extends Item implements Serializable{
	
	public final static String identifier = "Gift Card";
	
	private String label;
	private String manufacturer;
	
	public GiftCard() {
		this(0.0, 0, "", "");
	}
	
	public GiftCard(double price, int quantity, String label, String manufacturer) {
		super(price, quantity, identifier);
		setManufacturer(manufacturer);
		setLabel(label);
	}

	@Override
	public void display() {
		System.out.printf("Type: \t\t%s\nId: \t\t%d\nPrice: \t\t$%.2f\nQuantity: \t%d\nLabel: \t\t%s\n"
				+ "Manufacturer: \t%s\n", classification, id, price, quantity, label, manufacturer);	
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		if(manufacturer.isBlank() || manufacturer.isEmpty()) {
			this.manufacturer = "No listed manufacturer";
;		}else {
			this.manufacturer = manufacturer;
		}
		
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		if(label.isBlank() || label.isEmpty()) {
			this.label = "No label found.";
		}else {
			this.label = label;
		}
	}

}
