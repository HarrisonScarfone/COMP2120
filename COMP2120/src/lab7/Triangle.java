package lab7;

public class Triangle extends Shape{
	
	private double base;
	private double height;
	
	public Triangle(double base, double height) {
		super();
		setLabel("triangle");
		this.base = base;
		this.height = height;
	}
	
	public double getBase() {
		return base;
	}
	
	public void setBase(double newBase) {
		if(newBase > 0) {
			base = newBase;
		}
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double newHeight) {
		if(newHeight > 0) {
			height = newHeight;
		}
	}

	@Override
	public double calculateArea() {
		return base*height/2.0;
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
