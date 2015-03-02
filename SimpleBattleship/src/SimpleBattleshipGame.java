import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class SimpleBattleshipGame {

	private int gameType;
	private int boardSize = 7;
	private int shipSize = 3;
	private int shipStart;

	private ArrayList<Integer> board;
	private ArrayList<Integer> hull;

	//constructor with argument for game type
	public SimpleBattleshipGame(int n) {
		gameType = n;
	}

	public void runGame() {

		//welcome message
		System.out.println("Welcome to Battleship!\n");

		//initialize board array list
		board = new ArrayList<Integer>();
		for(int x=0; x < boardSize; x++){
			board.add(x+1);
		}

		//initialize hull array list and randomly place ship on board
		shipStart = (int)(Math.random()*(boardSize-shipSize+1)) + 1;
		hull = new ArrayList<Integer>();
		for(int x=0; x < shipSize; x++){
			hull.add(shipStart+x);
		}

		//test array values
		//this.printValues();

		if(gameType == 1){

			System.out.println("Come back later");

		//	player input game			
		} else if(gameType ==2 ){

			this.displayBoard();
			
			//open new input scanner
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int guess = 0;

			//while there are still hull locations to hit
			while(!hull.isEmpty()){
				
				//show remaining board guesses
				//this.displayBoard();
				//this.displayHull();
				
				//get user guess
				
				System.out.print("Enter shot location: ");
				try {
					guess = Integer.parseInt(br.readLine());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				//refuse input if guess is not in board locations
				if(board.contains(guess)){
					
					//remove guess from board locations
					board.remove(board.indexOf(guess));
					
					if(hull.contains(guess)){
						System.out.println("Hit!");
						hull.remove(hull.indexOf(guess));
					} else {
						System.out.println("Miss!");
					}
					
				} else {
					System.out.println("Please enter valid board location");
				}
			}
			
			System.out.println("\nYou won!");

		}



	}

	private void displayBoard() {
		System.out.print("Board locations are at: ");
		for(int x: board){
			System.out.print(x + " ");
		}
		System.out.println("\n");

	}
	private void displayHull() {
		System.out.print("Ship locations are at: ");
		for(int x: hull){
			System.out.print(x + " ");
		}
		System.out.println("\n");
		
	}

	//	method for printing values
/*	private void printValues() {

		System.out.print("Board locations are at: ");
		for(int x: board){
			System.out.print(x + " ");
		}
		System.out.println("\n");

		System.out.println("Ship start is: " + shipStart);
		System.out.print("Ship hull locations are at: ");
		for(int x: hull){
			System.out.print(x + " ");
		}
		System.out.println("\n");

	}*/






}
