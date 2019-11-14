package assignment3;

//- block.java a block represents a playable cell and maintains a state attribute that is either EMPTY, 
//occupied by X, or occupied by O) . 
//By default it is EMPTY, would require setState, getState, and a toString where EMPTY is just a blank space.

public class Block {
	
	State currentState;

	public enum State{
		EMPTY, X, O		
	}
	
	public Block() {
		currentState = State.EMPTY;
	}
	
	public void setState(State newState) {	
		currentState = newState;
	}
	
	public State getState() {
		return currentState;
	}
	
	public String toString(){
		switch(currentState) {
		case X:
			return "X";
		case O:
			return "O";
		default:
			return "";
		}
	}
}
