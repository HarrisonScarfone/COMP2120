package assignment3;

//- player.java is an abstract class that maintains a design that 
//every player has a symbol (X or O), a name, 
//and an abstract play(board gameboard) method. 


//this is stupid idk
//It also maintains a reference to the game board for players to examine and make their move.

abstract class Player {
	
	protected Symbol symbol;
	protected String name;
	
	enum Symbol{
		X, O
	}
	
	public Symbol getSymbol() {
		return symbol;
	}
	
	public abstract void play(Board b);	

}
