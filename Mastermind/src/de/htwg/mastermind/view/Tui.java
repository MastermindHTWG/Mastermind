package de.htwg.mastermind.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import de.htwg.mastermind.controller.MastermindController;
import de.htwg.mastermind.model.Field;


public class Tui {

	private int size;
	private MastermindController controller;
	Field gamefield;
	
	public Tui(MastermindController controller) {
		this.controller = controller;
	}
	/*fehler*/
	public void showTUI() {
		System.out.println("Wilkommen bei Mastermind! " +
				"Geben sie eine Zahl von 1-4 ein (groeﬂe des Spielfelds"); 
	}
	/*
	 * @param next : entgegennamhe der eingabe
	 */
	public boolean input(String next) {

		if (next.equalsIgnoreCase("exit")) {
			return false;
		}
		if (next.equalsIgnoreCase("1")) {
			size = 1;
			gamefield = new Field();
			controller = new MastermindController(gamefield);
			return true;
		}
		if(next.equalsIgnoreCase("2")) {
			size = 2;
			gamefield = new Field(2);
			controller = new MastermindController(gamefield);
			return true;
		}
		if(next.equalsIgnoreCase("3")) {
			size = 3;
			gamefield = new Field(3);
			controller = new MastermindController(gamefield);
			return true;
		}
		if(next.equalsIgnoreCase("4")) {
			size = 4;
			gamefield = new Field(4);
			controller = new MastermindController(gamefield);
			return true;
		}
		if (next.matches("[RBDWGY]")) {
			System.out.println("ja");
			pat (next);
			return true;
			
		}
		if (next.matches("[RBDWGY][RBDWGY]")) {
			pat (next);
			return true;
			
		}
		if (next.matches("[RBDWGY][RBDWGY][RBDWGY]")) {
			pat (next);
			return true;
			
		}
		if (next.matches("[RBDWGY][RBDWGY][RBDWGY][RBDWGY]")) {
			pat (next);
			return true;
			
		}
		return true;
		
	}
	
	/*
	 * @param String next : color entry from player
	 */
	private String [] pat(String next) {
		Pattern pat = Pattern.compile("[RBDWGY]");
		Matcher m = pat.matcher(next);
		String [] color = new String [size];
		for (int i = 0; i< size; i++ ) {
			m.find();
			color[i]=m.group();
		}
		for ( String a : color) {
			System.out.println("das haben sie eingegeben" + a);
		}
		return  color;
	}

}
