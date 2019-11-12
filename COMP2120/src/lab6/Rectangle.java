package lab6;

public class Rectangle extends Shape{
	
	private double width;
	private double length;
	/**
	 * Constructor for rectangle call parent, set label and rectangle parameters
	 * @param width needs a double for the width
	 * @param length needs a double for the length
	 */
	public Rectangle(double width, double length) {
		super();
		setLabel("rectangle");
		setWidth(width);
		setLength(length);
	}
	/**
	 * get the width of the rectangle
	 * @return the width of the rectangle as a double
	 */
	public double getWidth() {
		return width;
	}
	/**
	 * set the width of the rectangle must be greater than 0
	 * @param newWidth
	 */
	public void setWidth(double newWidth) {
		if(newWidth > 0.0) {
			width = newWidth;
		}else {
			width = 1.0;
		}
	}
	/**
	 * get the length of the rectangle
	 * @return length of rectangle as a double
	 */
	public double getLength() {
		return length;
	}
	/**
	 * set the length must be > 0
	 * @param newLength new length as a double
	 */
	public void setLength(double newLength) {
		if(newLength > 0.0) {
			length = newLength;
		}else {
			length = 1.0;
		}
	}
	/**
	 * abstract implementation of calculate area
	 */
	@Override
	public double calculateArea() {
		return width*length;
	}
}
