package assignment2;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Book extends Item implements Serializable{
	
	public final static String identifier = "Book";
	
	private String author;
	private String title;
	private int year;
	
	public Book() {
		this(0.0, 0, "", "", 0);
	}
	
	public Book(double price, int quantity, String author, String title, int year) {
		super(price, quantity, identifier);
		setAuthor(author);
		setTitle(title);
		setYear(year);
	}

	@Override
	public void display() {
		System.out.printf("Type: \t\t%s\nId: \t\t%d\nPrice: \t\t$%.2f\nQuantity: \t%d\nAuthor: \t%s"
				+ "\nBook Title: \t%s\nYear: \t\t%d\n", classification, id, price, quantity, author, title, year);		
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		if(title.isBlank() || title.isEmpty()) {
			this.title = "No Value";
		}else {
			this.title = title;
		}
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if(author.isBlank() || author.isEmpty()) {
			this.author = "Author not found";
		}else {
			this.author = author;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year >= 0) {
			this.year = year;
		}else {
			this.year = 0;
		}
	}	
}
