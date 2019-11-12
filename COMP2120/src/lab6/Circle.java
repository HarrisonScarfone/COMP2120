package lab6;

public class Circle extends Shape{
	
	private double radius;
	/**
	 * Constructor for circle.  Call parent class, set the label and radius
	 * @param radius Double representing the radius of the circle
	 */
	public Circle(double radius) {
		super();
		setLabel("circle");
		setRadius(radius);
	}
	/**
	 * Get the radius of the circle
	 * @return The radius of the circle
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * Set the radius of the circle
	 * @param newRadius Needs a double to set the new radius of a circle.  Must be > 0
	 */
	public void setRadius(double newRadius) {
		if(newRadius > 0.0) {
			radius = newRadius;
		}else {
			radius = 1.0;
		}
	}
	/**
	 * Abstract method to calculate the area of the circle
	 */
	@Override
	public double calculateArea() {
		return radius*Math.PI;
	}
}
