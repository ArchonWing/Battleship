import java.util.ArrayList;
import java.util.Random;


public class Board {

	//character cells to represent the board to the player
	private char[][] cells;

	//board dimensions
	int rows;
	int columns;

	//board spacing
	String spacing = "   ";

	//array list to hold ships
	ArrayList<Ship> ships;

	//int to hold remaining ship count
	int shipsLeft;

	//integer to represent ship length



	//constructor to build board based on provided height and width
	public Board(int r, int c) {

		//set board dimensions
		rows = r;
		columns = c;

		//cells to represent locations.  '0' is unknown, 'X' is a hit, and 'M' is a miss
		cells = new char[rows][columns];

		//initialize all cell locations to '0'
		for(int x=0; x < rows; x++){
			for(int y=0; y< columns; y++){
				cells[x][y] = '0';
			}
		}

		//initialize ships
		ships = new ArrayList<Ship>();
		ships.add(new Ship("my Carrier", 5, 1));
		ships.add(new Ship("my Battleship", 4, 2));
		ships.add(new Ship("my Submarine", 3, 3));
		ships.add(new Ship("my Destroyer", 3, 4));
		ships.add(new Ship("my Patrol Boat", 2, 5));

		//initialize ships left counter
		shipsLeft = 5;


		//set ships on board
		for(Ship x: ships){
			if(!this.placeShip(x)){
				System.out.println("Too many ships for board size, exiting application.");
				System.exit(0);
			}

		}

	}

	public void displayBoard(){
		//build first row 
		String row = spacing + " ";
		for(int x = 0; x < columns; x++){
			row += (String.valueOf(x+1) + spacing);
		}
		//display first row
		System.out.println(row + "\n");

		//display remaining rows
		for(int x=0; x < rows; x++){

			row = "";

			//display row letter
			row += getCharForNumber(x+1) + spacing;

			//populate board
			for(int y=0; y< columns; y++){
				row += cells[x][y] + spacing;
			}

			//display row
			System.out.println(row + "\n");
		}

	}


	public void displayPlayerBoard(){
		//build first row 
		String row = spacing + " ";
		for(int x = 0; x < columns; x++){
			row += (String.valueOf(x+1) + spacing);
		}
		//display first row
		System.out.println(row + "\n");

		//display remaining rows
		for(int x=0; x < rows; x++){

			row = "";

			//display row letter
			row += getCharForNumber(x+1) + spacing;

			//populate board
			for(int y=0; y< columns; y++){
				if(cells[x][y] == 'H'  || cells[x][y] == 'M'  )
					row += cells[x][y] + spacing;
				else
					row += "0" + spacing;
			}

			//display row
			System.out.println(row + "\n");
		}

		//print spacing line
		System.out.println("");

	}


	private String getCharForNumber(int i) {
		return i > 0 && i < 27 ? String.valueOf((char)(i + 'A' - 1)) : null;
	}


	public boolean placeShip(Ship s) {

		//randomize vertical or horizontal placement
		Random rnd = new Random();
		boolean across = rnd.nextBoolean();

		//try to place ship horizontally, the vertically
		if(across){
			if(this.placeShipHorizontal(s)){
				return true;
			}
			else if(this.placeShipVertical(s)){
				return true;
			}
		}
		//try to place ship vertically, then horizontally
		else{
			if(this.placeShipVertical(s)){
				return true;
			}
			else if(this.placeShipHorizontal(s)){
				return true;
			}

		}

		//return whether or not ship has been successfully placed or not
		return false;
	}



	private boolean placeShipHorizontal(Ship s) {



		//find all locations where a ship can be placed horizontally

		//array list to hold all possible coordinates
		ArrayList<Coordinate> spots = new ArrayList<Coordinate>();

		for(int y = 0; y < this.rows; y++){
			for(int x = 0; x < (this.columns - s.getSize() + 1); x++){

				boolean room = true;

				for(int z = x; z < x + s.getSize(); z++){
					if (this.cells[y][z] != '0'){
						room = false;
						break;
					}
				}

				if(room){
					spots.add(new Coordinate(x,y));
				}
			}
		}

		//		//select random available coordinate to add ship
		if(spots.size() > 0){
			Random rnd = new Random();
			int position = rnd.nextInt(spots.size());

			int j = spots.get(position).getX();
			int k = spots.get(position).getY();

			//			System.out.println("Number of possible positions: " + spots.size());
			//			System.out.println("Start position is: " + (j+1) + ", " + (k+1));

			for(int x = j; x < j + s.getSize(); x ++){
				this.cells[k][x] = s.getCharShipNumber();
			}

			return true;

		} else {
			return false;
		}
	}

	private boolean placeShipVertical(Ship s) {



		//find all locations where a ship can be placed vertically

		//array list to hold all possible coordinates
		ArrayList<Coordinate> spots = new ArrayList<Coordinate>();

		for(int y = 0; y < this.rows - s.getSize() + 1; y++){
			for(int x = 0; x < this.columns; x++){

				boolean room = true;

				for(int z = y; z < y + s.getSize(); z++){
					if (this.cells[z][x] != '0'){
						room = false;
						break;
					}
				}

				if(room){
					spots.add(new Coordinate(x,y));
				}
			}
		}

		if(spots.size() > 0){
			Random rnd = new Random();
			int position = rnd.nextInt(spots.size());

			int j = spots.get(position).getX();
			int k = spots.get(position).getY();

			//			System.out.println("Number of possible positions: " + spots.size());
			//			System.out.println("Start position is: " + (j+1) + ", " + (k+1));

			for(int y = k; y < k + s.getSize(); y ++){
				this.cells[y][j] = s.getCharShipNumber();
			}

			return true;

		} else {
			return false;
		}


	}

	//main for testing things 'n stuff
	public static void main(String[] args){

		Board b = new Board(8, 8);
		b.displayBoard();
		b.displayPlayerBoard();


	}

	

	public void checkShot(Coordinate shot) {

		int x = shot.getX();
		int y = shot.getY();

		//check to make sure coordinate falls on board
		if( x < 0 || x > (columns - 1) || y < 0 || y > (rows -1)){
			System.out.println("Please enter valid coordinate.\n");
			return;
		}

		//check to make sure shot has not been guessed before
		if(cells[y][x] == 'H' || cells[y][x] == 'M'){
			System.out.println("You have already guessed this location, please guess again.\n");
			return;
		}

		//miss result
		if(cells[y][x] == '0'){
			cells[y][x] = 'M';
			System.out.println("Miss!\n");
			this.displayPlayerBoard();


			//hit result
		} else {
			int shipNum = Character.digit(cells[y][x], 10) - 1;

			cells[y][x] = 'H';
			System.out.println("Hit!\n");

			Ship targetShip = ships.get(shipNum);

			targetShip.takeDamage();

			if (targetShip.getSize() == 0){
				shipsLeft --;
				System.out.println("You sunk " + targetShip.getName() + "!!!\n");
			}

			this.displayPlayerBoard();
		}




	}

	public boolean shipsLeft() {

		if(shipsLeft > 0)
			return true;
		else 
			return false;
		
	}


}
