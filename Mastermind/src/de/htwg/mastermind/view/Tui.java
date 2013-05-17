package de.htwg.mastermind.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import de.htwg.mastermind.controller.MastermindController;
import de.htwg.mastermind.model.Field;
import de.htwg.mastermind.observer.Observer;


public class Tui  implements Observer{
	
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;

	private int size;
	private MastermindController controller;
	Field gamefield;
	
	public Tui(MastermindController controller) {
		this.controller = controller;
	}
	/*
	 * start selection
	 */
	public void showTUI() {
		System.out.println("Wilkommen bei Mastermind! " +
				"Geben sie eine Zahl von 1-4 ein (groeﬂe des Spielfelds"); 
	}
	/*
	 * @param next : entgegennamhe der eingabe
	 */
	public boolean input(String next) {

		if (next.equalsIgnoreCase("q")) {
			return false;
		}
		if (next.equalsIgnoreCase("1")) {
			size =ONE;			
			return createField(ONE);
		}
		if(next.equalsIgnoreCase("2")) {
			size = TWO;
			return createField(TWO);
		}
		if(next.equalsIgnoreCase("3")) {
			size = THREE;
			
			return createField(THREE);
		}
		if(next.equalsIgnoreCase("4")) {
			size = FOUR;
			return createField(FOUR);
		}
		if (next.equalsIgnoreCase("s")) {
//			controller.solveSolution();
		}
		if(next.equalsIgnoreCase("ok")) {
			controller.solveInformation();
		}
		if (next.matches("[RBOWGY]")) {
			controller.setColor(pat (next));
			return true;
			
		}
		if (next.matches("[RBOWGY][RBOWGY]")) {
			controller.setColor(pat (next));
			return true;
			
		}
		if (next.matches("[RBOWGY][RBOWGY][RBOWGY]")) {
			controller.setColor(pat (next));
			return true;
			
		}
		if (next.matches("[RBOWGY][RBOWGY][RBOWGY][RBOWGY]")) {
			controller.setColor(pat (next));
			return true;
			
		}
		return true;
		
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
	
	public boolean createField(int size) {
		gamefield = new Field(size);
		controller = new MastermindController(gamefield);
		controller.createSolutionThree();
		this.printTUI();
		controller.addObserver(this);
		return true;
	}
	/*
	 * Observer update()
	 */
	@Override
	public void update() {
		printTUI();
	}
	
	private void printTUI() {
		System.out.println(controller.getGamfieldString());
		System.out.println("Pleas enter a command q - quit, s - solve");
		
	}

}
