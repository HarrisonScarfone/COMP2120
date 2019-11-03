package lab7;

public class Rectangle extends Shape{
	
	private double width;
	private double length;
	private double area;
	
	
	public Rectangle(double width, double length) {
		super();
		setLabel("rectangle");
		this.width = width;
		this.length = length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double newWidth) {
		if(newWidth > 0.0) {
			width = newWidth;
		}
	}
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double newLength) {
		if(newLength > 0.0) {
			length = newLength;
		}
	}
	
	@Override
	public double calculateArea() {
		return width*length;
	}

	@Override
	public int compareTo(Shape arg0) {
		if(calculateArea() == arg0.calculateArea()) {
			return 0;
		}
		if(calculateArea() > arg0.calculateArea()) {
			return -1;
		}
		return 1;
	}
}
