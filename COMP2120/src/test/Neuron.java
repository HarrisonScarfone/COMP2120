package test;

import java.util.ArrayList;
import java.util.HashMap;

public class Neuron {
	
	public final int neuronId;
	public final String neuronLayer;

	public HashMap<Neuron, Double> forwardLinks = new HashMap<Neuron, Double>();
	public ArrayList<Integer> outputs;
	
	public boolean isFiring;
	
	public Neuron(int neuronId, String neuronLayer) {
		this.neuronLayer = neuronLayer;
		this.neuronId = neuronId;
		System.out.println("made a neuron ");
	}
	
	public String toString() {
		return "Layer: " + this.neuronLayer + " Id: " + this.neuronId + " ";
	}
	
	public void linkLayer(Neuron neuron, ArrayList<Neuron> nextLayer) {
		for(Neuron n: nextLayer) {
			neuron.forwardLinks.put(n, Math.random());
		}
	}
	
	public void adjustLink(boolean adjust) {
		if(adjust) {
			for(HashMap.Entry<Neuron, Double> pair : forwardLinks.entrySet()) {
				forwardLinks.put(pair.getKey(), pair.getValue());
			}
		}
	}
	
	public void fireNeuronFromInput() {
		isFiring = true;
	}
	
	public void fireNeuronFromLink(double inputSum) {
		if(activation(inputSum) > 0.5) {
			isFiring = true;
			return;
		}
		isFiring = false;
	}
	
	public double activation(double number) {
		return (1/(1 + Math.pow(Math.E, (-1*number))));
	}
	
}
