import java.util.ArrayList;


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
		ships.add(new Ship("Bismark", 3));
		ships.add(new Ship("Yamato", 3));
		ships.add(new Ship("Red October", 3));
		
		//set ships on board
		for(int x = 0; x < ships.size(); x++){
			 
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


	private String getCharForNumber(int i) {
		return i > 0 && i < 27 ? String.valueOf((char)(i + 'A' - 1)) : null;
	}

	public void placeShip(Ship s) {



	}

}
