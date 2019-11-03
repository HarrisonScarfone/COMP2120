package lab7;

public class Circle extends Shape{
	
	private double radius;
	
	public Circle(double radius) {
		super();
		setLabel("circle");
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double newRadius) {
		if(newRadius > 0.0) {
			radius = newRadius;
		}
	}
	
	@Override
	public double calculateArea() {
		return radius*Math.PI;
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
