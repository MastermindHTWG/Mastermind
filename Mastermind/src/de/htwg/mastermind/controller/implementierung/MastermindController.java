package de.htwg.mastermind.controller.implementierung;

import java.util.HashMap;
import java.util.Map.Entry;

import de.htwg.mastermind.controller.IMastermindController;
import de.htwg.mastermind.model.IField;


import de.htwg.mastermind.observer.Observable;

public class MastermindController extends Observable implements IMastermindController{

	private IField gamefield;	
	
	public MastermindController(IField gamefield) {
		this.gamefield = gamefield;
	}
	/*
	 * bestimme farbkombination der loesung
	 */
	public void createSolutionThree() {
		
		char color[] = {'R','G','B'};
		int pos = 0;
		for(char col : color) {
			gamefield.setSolution(col, pos);
			pos++;		
		}
		notifyObservers();
	}
	public void setVisibleSolution(boolean visible) {
		gamefield.setVisibleSolution(visible);
		notifyObservers();
	}
	
	/*
	 * gibt das Spielfeld als String zurueck
	 */
	public String getGamfieldString(){
		return gamefield.toString();
	}

	public void playerSetColor(char [] color) {
		gamefield.setGameRectangleColor(color);
		notifyObservers();
	}
	
	public void setBlackOrWith() {
		char [] playerSetColor = gamefield.getGameRectangleColor();
		char [] solutionColor = gamefield.getSolution();
		int size = gamefield.getSize(),count = 0;
		boolean whihteAvaliable = false;
		HashMap<Integer,Character> blackWhiteContainer = new HashMap<Integer,Character>();
		
		for (int x = 0; x < size;x++) {
			whihteAvaliable = false;
			for(int y = 0; y < size;y++) {
				
				/*wenn farbe und positionen gleich ist*/
				if (playerSetColor[x] == solutionColor[y]) {
					if(x == y) {
						blackWhiteContainer.put(x, 'B');
						break;
					} else {
						if(blackWhiteContainer.containsKey(x) && blackWhiteContainer.get(x) != 'B' &&  !whihteAvaliable) {
							blackWhiteContainer.put(x, 'W');
							 whihteAvaliable = true;
						} else if (!whihteAvaliable){
							 whihteAvaliable = true;
							 blackWhiteContainer.put(x, 'W');
						}	
					}
				}
			}
		}		
		for( Entry<Integer, Character> entry :blackWhiteContainer.entrySet()) {
			if(entry.getValue() =='B') {
				gamefield.setInformation('B', count);
				count++;
			}			
		}
		for( Entry<Integer, Character> entry :blackWhiteContainer.entrySet()) {
			if(entry.getValue() == 'W') {
				gamefield.setInformation('W', count);
				count++;
			}
		}
		
		
		/*if fuer ende der Spielrunde*/
		gamefield.setAktiv(gamefield.getAktiv()+1);	
		notifyObservers();
		
		
	}
	
	
	
	boolean checkWin() {
		char[] unit = gamefield.getInformation();
		int size = gamefield.getSize();
		for(int x = 0; x< size; x++) {
			if(!(unit[x] == 'B')) {
				return false;
			}
		}		
		return true;
	}
	
}