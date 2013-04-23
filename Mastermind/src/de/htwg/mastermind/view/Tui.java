package de.htwg.mastermind.view;

import de.htwg.mastermind.controller.MastermindController;


public class Tui {

	private MastermindController controller;
	
	public Tui(MastermindController controller) {
		this.controller = controller;
	}
	/*fehler*/
	public void showTUI() {
		controller.toString(); 
	}

}
