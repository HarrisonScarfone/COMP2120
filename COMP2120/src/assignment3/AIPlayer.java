package assignment3;

//AIPlayer.java extends player, a type of player that implements a simple computer player. The simplest strategy is to play a valid random move. Feel free to design more difficult or "intelligent" game players.

public class AIPlayer extends Player{

	public int[] boardState;
	public int nextMove;
	
	public AIPlayer(Player.Symbol symbol) {
		this.name = "TAI";
		this.symbol = symbol;
	}
	
	public int playOrder;

	@Override
	public void play(Board b) {	
		playBeginner(b);
	}
	
	public void playBeginner(Board b) {
		System.out.println("Available moves are: " + b.availableMoves);
		int nextMoveIndex = (int) (Math.random() * b.availableMoves.size());
		nextMove = b.availableMoves.get(nextMoveIndex);
		b.makeMove(nextMove-1, getSymbol());
	}
	
	public void getBoardState(Board b) {
		if(getSymbol().equals(Player.Symbol.X)) {
			boardState = b.getBoardState(Block.State.X);
		}else {
			boardState = b.getBoardState(Block.State.O);
		}
	}
}
