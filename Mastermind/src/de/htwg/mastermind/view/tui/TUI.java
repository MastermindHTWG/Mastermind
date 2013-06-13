package de.htwg.mastermind.view.tui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import de.htwg.mastermind.controller.IMastermindController;
import de.htwg.mastermind.controller.implementierung.MastermindController;
import de.htwg.mastermind.util.observer.Observer;


public class TUI  implements Observer{
	
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;

	private IMastermindController controller;
	
	public TUI(IMastermindController controller) {
		this.controller = controller;
		controller.addObserver(this);
	}

	/*
	 * @param next : entgegennamhe der eingabe
	 */
	public boolean input(String next) {

		if (next.equalsIgnoreCase("q")) {
			return false;
		}
		if(next.equalsIgnoreCase("s")){
			controller.setVisibleSolution(true);
		}
		
		if(next.equalsIgnoreCase("ok")) {
			controller.setBlackOrWith();
		}
		if(next.equalsIgnoreCase("n")) {
			controller.createField();
		}
		if (next.matches("[RBOWGY][RBOWGY][RBOWGY][RBOWGY]")) { 
			char [] c = pat(next);
			controller.charToSquareAndSetForTUI(c);			
		}
		return true;
		
	}
	
	
	/*
	 * @param String next : color entry from player
	 */
	private char [] pat(String next) {
		Pattern pat = Pattern.compile("[RBOWGY]");
		Matcher m = pat.matcher(next);
		char [] color = new char [4];
		for (int i = 0; i< 4; i++ ) {
				m.find();
				char tmp[]=m.group().toCharArray();
				color[i]=tmp[0];
		}
		return color;
	}
	

	/*
	 * Observer update()
	 */
	@Override
	public void update() {
		printTUI();
	}
	
	private void printTUI() {
		System.out.println(controller.getGamfieldString() + "\n" +
								controller.getStatus()+"\n" +
									"Pleas enter command (q-quit,s-solve,n-new, BB for Black Black in Gamefield, ok-to confirm input)");

		
	}
	
	

}
