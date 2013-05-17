package de.htwg.mastermind.controller;

import java.util.HashMap;
import java.util.Map;

import de.htwg.mastermind.model.Field;
import de.htwg.mastermind.observer.Observable;

public class MastermindController extends Observable {

	private Field gamefield;
	private Map<Character, HashMap<Integer,Character>> solution = new HashMap<Character, HashMap<Integer,Character>>();
	
	
	public MastermindController(Field gamefield) {
		this.gamefield = gamefield; 
	}
	/*
	 * bestimme farbkombination der loesung
	 */
	public void createSolutionOne() {
		gamefield.setSolution('R', 0);
	}
	
	public void createSolutionThree() {
		char color[] = {'R','G','B'};
		int pos = 0;
		for(char col : color) {
			gamefield.setSolution(col, pos);
			pos++;		
		}
		notifyObservers();
	}
	
	/*
	 * gibt das Spielfeld als String zurueck
	 */
	public String getGamfieldString(){
		return gamefield.toString();
	}

	public void setColor(char [] color) {
		gamefield.setGameRectangleColor(color);
		notifyObservers();
	}
	
	public void solveInformation() {
		char [] playerSetColor = gamefield.getGameRectangleColor();
		char [] solutionColor = gamefield.getSolution();
		int size = gamefield.getSize();


		for (int x = 0; x < size;x++) {
			for(int y = 0; y < size;y++) {
				if (playerSetColor[x] ==solutionColor[y]) {
					if(x == y){
						HashMap<Integer,Character> tmp = new HashMap<Integer,Character>();
						tmp.put(y,playerSetColor[x]);
						solution.put(playerSetColor[x],tmp);
						
						
						gamefield.setInformation('B', x);
						System.out.println("Sch");
					} else {
						gamefield.setInformation('W', x);
						System.out.println("wei");
					}				
				}				
			}
		}		
		/*algo zum vergleich nach farben*/
		
		
		/*if fuer ende der Spielrunde*/
		gamefield.setAktiv(gamefield.getAktiv()+1);	
		notifyObservers();
		
	}
	
}