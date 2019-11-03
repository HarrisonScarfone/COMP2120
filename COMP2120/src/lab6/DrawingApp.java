package lab6;

import java.util.ArrayList;
import java.util.Random;

public class DrawingApp {

	public static ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	enum ShapeTypes{
		
		circle, rectangle, triangle;
		
		public static void getRandomShapes(int numOfShapes) {
			
			Random rand = new Random();
			shapes.clear();
			
			for(int i=0; i<numOfShapes; i++) {
				switch((values()[rand.nextInt(values().length)])) {
				case circle:
					shapes.add(new Circle(100*rand.nextDouble()));
					break;
				case rectangle:
					shapes.add(new Rectangle(100*rand.nextDouble(), 100* rand.nextDouble()));
					break;
				case triangle:
					shapes.add(new Triangle(100*rand.nextDouble(), 100*rand.nextDouble()));
				default:
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		ShapeTypes.getRandomShapes(10);
		double totalArea = 0;
		
		
		for(Shape s: shapes) {
			switch(s.getLabel()) {
			case "circle":
				System.out.printf("type: %s, id: %s, radius: %.4f, area: %.4f\n", 
						s.getLabel(), s.getId(), ((Circle) s).getRadius(), s.calculateArea());
				break;
			case "rectangle":
				System.out.printf("type: %s, id: %s, length: %.4f, height: %.4f, area: %.4f\n", 
						s.getLabel(), s.getId(), ((Rectangle) s).getLength(), ((Rectangle) s).getWidth(), s.calculateArea());
				break;
			case "triangle":
				System.out.printf("type: %s, id: %s, base: %.4f, height: %.4f, area: %.4f\n", 
						s.getLabel(), s.getId(), ((Triangle) s).getBase(), ((Triangle) s).getHeight(), s.calculateArea());
			}
			
			totalArea += s.calculateArea();
		}
		
		System.out.println("====================================================");
		System.out.printf("The total area of the 10 shapes is %.5f", totalArea);
	}

}
