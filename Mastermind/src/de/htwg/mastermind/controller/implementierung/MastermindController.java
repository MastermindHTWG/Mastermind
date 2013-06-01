package de.htwg.mastermind.controller.implementierung;

import java.util.HashMap;
import java.util.Map.Entry;

import de.htwg.mastermind.controller.IMastermindController;
import de.htwg.mastermind.model.IField;
import de.htwg.mastermind.model.implementierung.Field;


import de.htwg.mastermind.util.observer.Observable;

public class MastermindController extends Observable implements IMastermindController{

	private IField gamefield;	
	private String statusLine;
	private boolean win = false;
	
	public MastermindController(IField gamefield) {  
		this.gamefield = gamefield;
	}
	
	/*
	 * create a new Field to play
	 * @param size size of the Field
	 */
	public void createField(int size) {
		this.gamefield = new Field(size);
		statusLine = "New Field was created";
		this.setSolution();
		notifyObservers();
	}
	
	
	
	/*
	 * bestimme farbkombination der loesung
	 */
	public void setSolution() {
				
		int pos = 0;
		char color [] = this.createSolution();		
		
		for(char c: color ) {
			gamefield.setSolution(c, pos);
			pos++;		
		}
	}
	
	public char [] createSolution() {
		
		char color[] = new char[gamefield.getSize()];
				
		for (int i = 0; i< gamefield.getSize();i++) {
			int rnd = (int) (Math.random() * (6));
			if (rnd == 0) {
				color [i] = 'R';
			} else if(rnd == 1) {
				color [i] = 'B';
			} else if (rnd == 2) {
				color [i] = 'O'; 
			} else if (rnd == 3) {
				color[i] = 'W';
			} else if ( rnd == 4) {
				color[i] = 'G';
			} else if( rnd == 5) {
				color[i] = 'Y';
			} else {
				color[i] = '_';
			}
		}
		
		return color;
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
	/*
	 * auswerten der Farbkombinationen die vom Spieler gesetzt wurden
	 * und ueberpruefen ob der spieler gewonnen hat
	 */
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
		
		this.checkWin();
		/*if fuer ende der Spielrunde*/
		gamefield.setAktiv(gamefield.getAktiv()+1);	
		notifyObservers();
		
		
	}
	
	
	private boolean checkWin() {
		char[] unit = gamefield.getInformation();
		int size = gamefield.getSize();
		for(int x = 0; x< size; x++) {
			if(!(unit[x] == 'B')) {
				return false;
			}
		}
		statusLine = "You win, continue with yes.";
		return true;
	}
	
	public boolean getWin() {
		return win;
	}
	
	public String getStatus() {
		return statusLine;
	}
}