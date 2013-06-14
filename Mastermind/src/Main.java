import java.util.Scanner;

import de.htwg.mastermind.controller.implementierung.MastermindController;
import de.htwg.mastermind.model.implementierung.Field;
import de.htwg.mastermind.view.gui.MastermindFrame;
import de.htwg.mastermind.view.tui.TUI;

public abstract class Main { 

	private static final int FOUR = 4;
	private static final int SIX = 6;
	private static Scanner scanner;
		
	
	public static void main(String[] args) {
		
		/*model*/
		Field gamefield = new Field(FOUR,SIX); 
		
		/*controller*/
		MastermindController controller = new MastermindController(gamefield);
		
		MastermindFrame gui = new MastermindFrame(controller);
		
		/*view*/
		TUI tui = new TUI(controller);
		
		/*main menue*/
		controller.createField();	
		
		scanner = new Scanner(System.in);

		boolean continu = true;
		while(continu) {
			continu = tui.input(scanner.next());
		}
	}
}
