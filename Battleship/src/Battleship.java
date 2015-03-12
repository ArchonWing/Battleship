import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Battleship {


	
	//counter for number of player guesses
	int numGuesses;
	
	//board dimensions
	int rows = 6;
	int columns = 6;
	
	
	//method to run new game
	public void runGame() throws IOException {
	
		//welcome message
		System.out.println("Welcome to battleship!\n");
		
		//create board
		Board gameBoard = new Board(rows, columns);
		
		//display board
		gameBoard.displayPlayerBoard();
		
		Coordinate shot;
		
		//while loop to run turns while ships remain
		while(gameBoard.shipsLeft()){
			
			shot = getUserGuess();
			
			gameBoard.checkShot(shot);
			
		}
		
		//victory message
	
		System.out.println("Congratulations, you won!!!\n");
		
		
		
		
	}


	private Coordinate getUserGuess() throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Please enter shot coordinates: ");
		
		String input = in.readLine(); 
		
		return Coordinate.convertCoordinates(input);
		
	}



}
