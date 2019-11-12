package lab6;

public class Triangle extends Shape{
	
	private double base;
	private double height;
	
	public Triangle(double base, double height) {
		super();
		setLabel("triangle");
		setBase(base);
		setHeight(height);
	}
	
	public double getBase() {
		return base;
	}
	
	public void setBase(double newBase) {
		if(newBase > 0.0) {
			base = newBase;
		}else {
			base = 1.0;
		}
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double newHeight) {
		if(newHeight > 0.0) {
			height = newHeight;
		}else {
			height = 1.0;
		}
	}

	@Override
	public double calculateArea() {
		return base*height/2.0;
	}
}
