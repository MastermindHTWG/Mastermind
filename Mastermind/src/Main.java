import java.util.Scanner;

import de.htwg.mastermind.controller.MastermindController;
import de.htwg.mastermind.model.*;
import de.htwg.mastermind.view.Tui;



public class Main {


	
	public static void main(String[] args) {
		
		/*Scanner scanner;*/

		GameRectangle one = new GameRectangle(1);
		String newLine = System.getProperty("line.separator");

		
		
		StringBuilder tmp = new StringBuilder();
		tmp.append(one.toString()).toString();
		
		System.out.print(tmp);
		StringBuilder sb= new StringBuilder();
		sb.append("+----++----+").append(newLine).append("|(_) ||(_) |").append(newLine).append("+----++----+");
		sb.toString();
		
		System.out.print(sb);
		System.out.print("aa");
		/*model*/
		//Field gamefield = new Field(1);
		
		//System.out.println(gamefield);

		/*controller*/
		/*MastermindController controller = new MastermindController(gamefield);*/
				
		/*view*/
		/*Tui tui = new Tui(controller);
		
		scanner = new Scanner(System.in);
		
		
		
		
		boolean continu = true;
		while(continu) {
			
		}
		*/
		

	}

}
