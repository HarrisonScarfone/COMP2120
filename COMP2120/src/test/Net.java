//package test;
//
//import java.util.ArrayList;
//
//import assignment3.Board;
//
//public class Net {
//	
//	Board board;
//	public ArrayList<Neuron> inputLayer = new ArrayList<Neuron>();
//	public ArrayList<Neuron> hiddenLayer = new ArrayList<Neuron>();
//	public ArrayList<Neuron> outputLayer = new ArrayList<Neuron>();
////	public ArrayList<Move> inputMoves = new ArrayList<Move>();
////	public ArrayList<Move> hiddenMoves = new ArrayList<Move>();
//	public int[] currentBoardState;
//	
//	public Net(Board board) {
//		this.board = board;
//		currentBoardState = new int[27];
//		fillLayers();
//		linkNet();
//		updateBoardState();
//	}
//
//	public void fillLayers() {
//		for(int i=0; i<27; i++) {
//			inputLayer.add(new Neuron(i, "input"));
//		}
//		for(int i=0; i<18; i++) {
//			hiddenLayer.add(new Neuron(i, "hidden"));
//		}
//		for(int i=0; i<9; i++) {
//			outputLayer.add(new Neuron(i, "output"));
//		}
//	}
//	
//	public void linkNet() {
//		for(Neuron n: hiddenLayer) {
//			n.linkLayer(n, outputLayer);
//		}
//		
//		for(Neuron n: inputLayer) {
//			n.linkLayer(n, hiddenLayer);
//		}
//	}
//	
//	public void updateBoardState() {
//		currentBoardState = board.getBoardState();
//	}
//	
//	public void displayBoardState() {
//		for(int i=0; i<27; i++) {
//			System.out.println(currentBoardState[i]);
//		}
//	}
//	
//	public void showLinks() {
//		for(Neuron n: hiddenLayer) {
//			System.out.println(n.forwardLinks);
//		}
//		
//		System.out.println("=====================");
//		
//		for(Neuron n: inputLayer) {
//			System.out.println(n.forwardLinks);
//		}
//	}
//	
//	public void actOnInput() {
//		for(int i=0; i<27; i++) {
//			if(currentBoardState[i] == 1) {
//				inputLayer.get(i).fireNeuronFromInput();
//			}
//		}
//	}
//	
//	public void propogateInputToHidden() {
//		double sum = 0.0;
//		for(Neuron hiddenNeuron: hiddenLayer) {
//			sum = 0.0;
//			for(Neuron inputNeuron: inputLayer) {
//				if(inputNeuron.isFiring) {
//					sum += inputNeuron.forwardLinks.get(hiddenNeuron);
//					Move m = new Move(inputNeuron.neuronId, true);
//					inputMoves.add(m);
//				}
//			}
//			hiddenNeuron.fireNeuronFromLink(hiddenNeuron.activation(sum));
//		}
//	}
//	
//	public int propogateHiddenToOutput() {
//		double greatest = 0.0;
//		double sum = 0.0;
//		int fireAtLocation = -1;
//		for(Neuron outputNeuron: outputLayer) {
//			sum = 0.0;
//			for(Neuron inputNeuron: inputLayer) {
//				if(inputNeuron.isFiring) {
//					sum += inputNeuron.forwardLinks.get(outputNeuron);
//					Move m = new Move(outputNeuron.neuronId, true);
//					hiddenMoves.add(m);
//				}
//			}
//			if(sum > greatest) {
//				greatest = sum;
//				fireAtLocation = outputNeuron.neuronId;
//			}
//		}
//		return fireAtLocation;
//	}
//	
//	public void adjustWeights() {
//		for(Move m: inputMoves) {
//			
//		}
//	}
//}
