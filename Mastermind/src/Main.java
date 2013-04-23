import java.util.Scanner;

import de.htwg.mastermind.controller.MastermindController;
import de.htwg.mastermind.model.*;
import de.htwg.mastermind.view.Tui;



public class Main {

	/**
	 * @param args
	 */
	static Scanner scanner;
	
	public static void main(String[] args) {
		
		
		
		//model
		Field gamefield = new Field(3);
		System.out.println(gamefield);
		gamefield.setAktiv(2);
		System.out.println(gamefield);
		gamefield.setAktiv(3);
		System.out.println(gamefield);
		
		System.out.println(gamefield);
		//controller
		MastermindController controller = new MastermindController(gamefield);
				
		//view
		Tui tui = new Tui(controller);
		
		scanner = new Scanner(System.in);
		
		
		
		
		boolean continu = true;
//		while(continu) {
//			
//		}
		
		

	}

}
