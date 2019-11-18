package assignment3;

import java.util.ArrayList;
import java.util.Stack;

import assignment3.Player.Symbol;
import test.Move;

public class Board {
	
	public Block[] blocks = new Block[9];
	public State state;
	public ArrayList<Integer> availableMoves;
	public Stack<Move> moveHistory = new Stack<Move>();
	
	public enum State{
		EMPTY, X_WIN, O_WIN, DRAW
	}
	
	public int[][] winningCombinations = new int[][]{{0,3,6}, {1,4,7},{2,5,8},{0,1,2},
			{3,4,5},{6,7,8},{0,4,8},{2,4,6}};
	
	public Board() {
		for(int i=0; i<9; i++) {
			blocks[i] = new Block();
		}
		state = Board.State.EMPTY;
		availableMoves = new ArrayList<Integer>();
		for(int i=1; i<10; i++) {
			availableMoves.add(i);
		}
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
	
	public boolean isEmpty() {
		for(Block b: blocks) {
			if(!b.getState().equals(Block.State.EMPTY)) {
				return false;
			}
		}
		return true;
	}
	
	public int[] getBoardState(Block.State xOrO) {
		int[] return_ = new int[9];
		for(int i=0; i<9; i++) {
			if(blocks[i].getState().equals(xOrO)) {
				return_[i] = 1;
			}else if(blocks[i].getState().equals(Block.State.EMPTY)){
				return_[i] = 0;
			}else {
				return_[i] = -1;
			}
		}
		return return_;
	}
	
	public void updateState() {
		for(int[] combo: winningCombinations) {
			if(blocks[combo[0]].getState().equals(blocks[combo[1]].getState()) &&
					blocks[combo[1]].getState().equals(blocks[combo[2]].getState())){	
				if(blocks[combo[0]].getState().equals(Block.State.X)) {
					state = Board.State.X_WIN;
					return;
				}
				if(blocks[combo[0]].getState().equals(Block.State.O)) {
					state = Board.State.O_WIN;
					return;
				}
			}
		}
		if(availableMoves.size() == 0) {
			state = Board.State.DRAW;
		}
	}
	
	public void makeMove(int location, Symbol p) {
		if(p.equals(Player.Symbol.X)) {
			blocks[location].setState(Block.State.X);
			updateAvailableMoves(location);
			moveHistory.push(new Move(true, location));
			return;
		}else {
			blocks[location].setState(Block.State.O);
			updateAvailableMoves(location);
			moveHistory.push(new Move(false, location));
			return;
		}
	}
		
	public void updateAvailableMoves(int locationToRemove) {
		for(int i = 0; i<availableMoves.size(); i++) {
			if(availableMoves.get(i).equals(locationToRemove+1)) {
				availableMoves.remove(i);
			}
		}
	}
}

//X | X | O
//X | O | O
//O | O | X