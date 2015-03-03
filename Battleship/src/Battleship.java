import java.util.ArrayList;


public class Battleship {


	
	//counter for number of player guesses
	int numGuesses;
	
	//board dimensions
	int rows = 5;
	int columns = 7;
	
	
	//method to setup new game
	public void setUpGame() {
	
		//create board
		Board gameBoard = new Board(rows, columns);
		
		//test display board
		gameBoard.displayBoard();
		
		
	}

	//method to run game
	public void runGame(){
	
		//run turn loop while ships exist
		
	}

}
