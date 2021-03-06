package de.htwg.mastermind.view.tui;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.google.inject.Inject;


import de.htwg.mastermind.controller.IMastermindController;
import de.htwg.mastermind.util.observer.Observer;


public class TUI  implements Observer{
	
	private IMastermindController controller;
	private static final int FOUR = 4;
	private Logger logger = Logger.getLogger("de.htwg.mastermind.view.tui");
	
	
	@Inject
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
			controller.setBlackOrWhite();
		}
		if(next.equalsIgnoreCase("n")) {
			controller.createField();
		}
		if (next.matches("[RBOWGP][RBOWGP][RBOWGP][RBOWGP]")) { 
			char [] c = pat(next);
			controller.charToSquareAndSetForTUI(c);			
		}
		return true;
		
	}
	
	
	/*
	 * @param String next : color entry from player
	 */
	private char [] pat(String next) {
		Pattern pat = Pattern.compile("[RBOWGP]");
		Matcher m = pat.matcher(next);
		char [] color = new char [FOUR];
		for (int i = 0; i< FOUR; i++ ) {
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
		logger.info(controller.getGamfieldString() + "\n" +
								controller.getStatus()+"\n" +
									"Please enter command (q-quit,s-solve,n-new, BB for Black Black in Gamefield, ok-to confirm input)");

		
	}
	
	

}
