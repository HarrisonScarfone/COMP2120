package lab6;

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
}
