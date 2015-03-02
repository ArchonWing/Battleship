
public class Battlestar {

	int hull = 100;
	int vipers = 20;
	String name = "Galactica";
	
	void launchvipers(int v){
		vipers -= v;
		System.out.println(v + " Vipers deployed\n" + vipers + " remain");
	}

}
