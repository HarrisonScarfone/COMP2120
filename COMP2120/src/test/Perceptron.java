package test;

import java.util.ArrayList;

public class Perceptron {
	
	class Link {
		int pointsToIndex;
		double weight;
		public Link(int pointsToIndex, double weight) {
			this.pointsToIndex = pointsToIndex;
			this.weight = weight;
		}
		
		public void setWeight(double weight) {
			this.weight = weight;
		}
	}

	public double input;
	public double weights;
	public ArrayList<Link> links;
	
	public Perceptron() {
		
	}
	
	public Perceptron(double input) {
		this.input = input;		
	}
	
	public Perceptron(double input, double weight, ArrayList<Perceptron> pointsTo) {
		this.input = input;
		for(int i=0; i<pointsTo.size(); i++) {
			links.add(new Link(i, weight));
		}
	}
	
	public void updateWeights(int linkIndex) {
		links.get(linkIndex).setWeight(1);
	}
	
}
