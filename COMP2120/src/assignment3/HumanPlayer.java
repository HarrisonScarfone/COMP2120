package assignment3;

//- HumanPlayer.java extends player, a type of player that requests its input 
//from the user and submit the move (or play) to the gameboard.

public class HumanPlayer extends Player implements Global{
	
	public int playOrder;
	
	public HumanPlayer(String name, Player.Symbol symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	
	public int getValidInt() {
		System.out.printf("Enter choice: ");
		String input = scanner.nextLine();
		try {
			return Integer.parseInt(input);
		}catch(Exception e) {
			System.out.println("Invalid input. Try Again.");
			return getValidInt();
		}
	}
	
	@Override
	public void play(Board b) {	
		System.out.println("Available moves are: " + b.availableMoves);
		System.out.printf("Select location: ");
		int input = getValidInt();
		if(b.availableMoves.contains(input)) {
			b.makeMove(input-1, getSymbol());
		}else {
			System.out.println("Invalid move selection.");
			play(b);
		}
	}		
}
