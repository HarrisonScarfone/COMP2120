package assignment3;

//- game.java contains a game board and two players, playerX and playerO. 
//It manages the iteration with the players. First by getting the player names,
//does a coin toss to decide the turn and allows each player 
//to take a turn and make a move. It finally announces the winner/draw when the game ends.

public class Game implements Global{
	
	Player playerX;
	Player playerO;
	boolean playerXTurn = false;
	boolean playerOTurn = false;
	Board board;
	
	public Game() {
		board = new Board();
	}
	
	public void start() {
		setPlayers();
		coinToss();
		while(board.state.equals(Board.State.EMPTY)) {
			playerTurn();
			board.updateState();
		}
		board.draw();
		switch(board.state){
		case DRAW:
			System.out.println("The game is a draw!");
			break;
		case X_WIN:
			System.out.println("Xs Win!");
			break;
		case O_WIN:
			System.out.println("Os Win!");
			break;
		default:
			System.out.println("If your seeing this...lol");
			break;			
		}
	}
	
	public void setPlayers() {
		System.out.println("Welcome to Tic Tac Toe");
		System.out.println("=======================");
		System.out.println("1. Human vs. Human");
		System.out.println("2. Human vs Computer");
		System.out.println("3. Computer vs Computer");
		System.out.println("4. Exit");
		System.out.println("=======================");
		switch(getValidInt()) {
		case 1:
			humanVsHumanGame();
			break;
		case 2:
			humanVsAiGame();
			break;
		case 3:
			AiVsAiGame();
		}
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
	
	public void makeHumanXPlayer() {
		System.out.printf("Enter the X player Name: ");
		String name = scanner.nextLine();
		playerX = new HumanPlayer(name, Player.Symbol.X);
	}
	
	public void makeHumanOPlayer() {
		System.out.printf("Enter the O player Name: ");
		String name = scanner.nextLine();
		playerO = new HumanPlayer(name, Player.Symbol.O);
	}
	//
	//TO-DO
	//
	public void makeAIPlayerX() {
		System.out.println("X will be played by TAI, the Tic Tac Toe AI!");
		playerX = new AIPlayer(Player.Symbol.X);
	}
	//
	//TO-DO
	//
	public void makeAIPlayerO() {
		System.out.println("O will be played by TAI, the Tic Tac Toe AI!");
		playerO = new AIPlayer(Player.Symbol.O);
	}
	
	public void coinToss() {
		int i = (int) (Math.random() * 2 + 1);
		if(i == 1) {
			System.out.println(playerX.name + " won the toss! X goes first.");
			playerXTurn = true;
		}else {
			System.out.println(playerO.name + " won the toss! O goes first.");
			playerOTurn = true;
		}
	}
	
	public void humanVsHumanGame() {
		makeHumanXPlayer();
		makeHumanOPlayer();
	}

	public void humanVsAiGame() {
		makeHumanXPlayer();
		makeAIPlayerO();
	}
	
	public void AiVsAiGame() {
		makeAIPlayerX();
		makeAIPlayerO();
	}
	
	public void playerTurn() {
		board.draw();	
		if(playerXTurn == true) {
			System.out.println("Player X to move.");
			playerX.play(this.board);
			playerXTurn = false;
		}else {
			System.out.println("Player O to move.");
			playerO.play(this.board);
			playerXTurn = true;
		}		
	}	
}
