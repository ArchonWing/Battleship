
public class Ship {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getShipNumber() {
		return shipNumber;
	}

	public void setShipNumber(int shipNumber) {
		this.shipNumber = shipNumber;
	}

	private String name;
	private int size;
	private int shipNumber;

	public Ship(String n, int s, int x) {
		name = n;
		size = s;
		shipNumber = x;
		
	}

}
