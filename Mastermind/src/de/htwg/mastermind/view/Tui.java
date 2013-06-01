package de.htwg.mastermind.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import de.htwg.mastermind.controller.implementierung.MastermindController;
import de.htwg.mastermind.util.observer.Observer;


public class Tui  implements Observer{
	
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;

	private int size;
	private MastermindController controller;
	
	public Tui(MastermindController controller) {
		this.controller = controller;
		controller.addObserver(this);
	}
	/*
	 * start selection
	 */
	public void showTUI() {
		System.out.println("Welcome to Mastermind! Enjoy the game." +
				"Geben sie eine Zahl von 1-4 ein (groeﬂe des Spielfelds)."); 
	}
	/*
	 * @param next : entgegennamhe der eingabe
	 */
	public boolean input(String next) {
		
		playField(next);
		if (next.equalsIgnoreCase("q")) {
			return false;
		}
		if(next.equalsIgnoreCase("s")){
			controller.setVisibleSolution(true);
		}
		
		if(next.equalsIgnoreCase("ok")) {
			controller.setBlackOrWith();
		}
		// if the command line has the form B, set the square color on position one to Black
		if (next.matches("[RBOWGY]")) {
			controller.playerSetColor(pat (next));

		}
		// if the command line has the form RB, set the square color on position one to Red an pos two to Black
		if (next.matches("[RBOWGY][RBOWGY]")) {
			controller.playerSetColor(pat (next));

		}
		if (next.matches("[RBOWGY][RBOWGY][RBOWGY]")) {
			controller.playerSetColor(pat (next));

		}
		if (next.matches("[RBOWGY][RBOWGY][RBOWGY][RBOWGY]")) {
			controller.playerSetColor(pat (next));			
		}
		return true;
		
	}
	
	private void playField(String next) {
		if (next.equalsIgnoreCase("1")) {
			size =ONE;			
			controller.createField(ONE);
		}
		if(next.equalsIgnoreCase("2")) {
			size = TWO;
			controller.createField(TWO);
		}
		if(next.equalsIgnoreCase("3")) {
			size = THREE;
			controller.createField(THREE);
		}
		if(next.equalsIgnoreCase("4")) {
			size = FOUR;
			controller.createField(FOUR);
		}
	}
	
	/*
	 * @param String next : color entry from player
	 */
	private char [] pat(String next) {
		Pattern pat = Pattern.compile("[RBOWGY]");
		Matcher m = pat.matcher(next);
		char [] color = new char [size];
		for (int i = 0; i< size; i++ ) {
			m.find();
			char tmp[]=m.group().toCharArray();
			color[i]=tmp[0];
		}
		return  color;
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
									"Pleas enter command (q-quit,s-solve,n-new, BB for Black Black in Gamefield, ok-to confirm input");

		
	}
	
	

}
