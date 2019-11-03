package lab7;

abstract class Shape implements Comparable<Shape>{
	
	public static int counter = 0;
	
	private String label = "";
	private final int id;
	
	public Shape() {
		this.id = ++counter;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	public int getId() {
		return id;
	}
	
	public abstract double calculateArea();

}
