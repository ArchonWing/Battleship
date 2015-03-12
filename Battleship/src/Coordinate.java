
public class Coordinate {

	int row;
	int column;
	
	public Coordinate(int x, int y) {
		
		row = x;
		column = y;
		
	}
	public int getX() {
		return row;
	}
	public void setX(int x) {
		this.row = x;
	}
	public int getY() {
		return column;
	}
	public void setY(int y) {
		this.column = y;
	}
	public static Coordinate convertCoordinates(String input) {
		
		int j = (int)(Character.toUpperCase(input.charAt(0)) - 65);
		
		int k = Character.getNumericValue(input.charAt(1)) - 1;
		
		return new Coordinate(k,j);
		
	}
	
	
	
}
