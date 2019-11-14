package assignment3;

//- board.java a board has or contains 9 blocks in a 2D array (3x3) that shapes the game space of tic-tac-toe. 
//It also maintains an internal state which can be one of the following: 
//EMPTY (the initial state of the board), X (X claims a win), Y (Y claims a win), 
//or DRAW (where neither X nor Y can claim a win and no further moves are possible). 
//The board has the key methods makeMove( ) that is called by a player making a move and 
//getState() or updateState() that updates the state of the board after 
//every move. It checks for a win or a draw when they occur. Note that the board instantiates and maintains all the blocks.

public class Board {
	
	public static void main(String[] args) {
		Board b = new Board();
		b.draw();
		
	}
	
	public Block[] blocks = new Block[9];
	public State state;
	
	public enum State{
		EMPTY, X_WIN, Y_WIN, DRAW
	}
	
	public int[][] winningCombinations = new int[][]{{1,4,7}, {2,5,8},{3,6,9},{1,2,3},
			{4,5,6},{7,8,9},{1,5,9},{3,5,7}};
	
	public Board() {
		for(int i=0; i<9; i++) {
			blocks[i] = new Block();
		}
		state = Board.State.EMPTY;
	}
	
	public void draw() {
		for(int i=0; i<9; i++) {
			if(i%3 == 1) {
				if(blocks[i].getState().equals(Block.State.EMPTY)) {
					System.out.printf(" | %d"
							+ " | ", i+1);
				}else {
					System.out.printf(" | %s | ", blocks[i]);
				}
			}else {
				if(blocks[i].getState().equals(Block.State.EMPTY)) {
					System.out.printf("%d", i+1);
				}else {
					System.out.printf("%s", blocks[i]);
				}
			}
			if(i%3 == 2) {
				System.out.printf("\n");
			}
		}
	}
	
//	public void updateState() {
//		for(int[] combo: winningCombinations) {
//				if(blocks[combo[0]].getState().equals(blocks[combo[1]]))
//			}
//		}
//	}
//	
}
