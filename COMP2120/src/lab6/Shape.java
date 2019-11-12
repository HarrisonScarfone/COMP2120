package lab6;

abstract class Shape {
	
	public static int counter = 0;
	
	private String label = "";
	private final int id;
	
	/**
	 * Constructor for shape that sets id
	 */
	public Shape() {
		this.id = ++counter;
	}	
	/**
	 * Gets the shape type label
	 * @return shape type label as a string
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * Takes a string label and sets the shape type to that string
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * Get the id num of a shape
	 * @return the integer id of the shape
	 */
	public int getId() {
		return id;
	}
	/**
	 * Abstract method to calculate area of shapes
	 * @return The area of the shapes
	 */
	public abstract double calculateArea();

}
