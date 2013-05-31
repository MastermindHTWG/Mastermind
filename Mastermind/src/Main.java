import java.util.Scanner;

import de.htwg.mastermind.controller.implementierung.MastermindController;
import de.htwg.mastermind.model.implementierung.Field;
import de.htwg.mastermind.view.Tui;



public abstract class Main {

	private static final int FOUR = 4;
	private static Scanner scanner;
	public static void main(String[] args) {
		
		
		/*model*/
		Field gamefield = new Field(FOUR); 
		
		/*controller*/
		MastermindController controller = new MastermindController(gamefield);
				
		/*view*/
		Tui tui = new Tui(controller);
		
		/*main menue*/
		tui.showTUI();
		
		
		scanner = new Scanner(System.in);
		
	
		
		boolean continu = true;
		while(continu) {
			continu = tui.input(scanner.next());
		}
		
		

	}

}
