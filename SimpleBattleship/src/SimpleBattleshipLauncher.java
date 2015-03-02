import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SimpleBattleshipLauncher {

	public static void main(String[] args) {

		//prompt user for autorun or user-input game
		int n = 0; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while( n != 1  && n != 2 ){
			System.out.print("Enter 1 for autoruning game or 2 for user-input game: ");
			
			try {
				n = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("");

		//create new game
		SimpleBattleshipGame g = new SimpleBattleshipGame(n);

		//run game
		g.runGame();
		
	}

}
