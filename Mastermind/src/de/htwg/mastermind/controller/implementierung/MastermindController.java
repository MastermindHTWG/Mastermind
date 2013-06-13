package de.htwg.mastermind.controller.implementierung;

import java.util.HashMap;
import java.util.Map.Entry;
import de.htwg.mastermind.controller.IMastermindController;
import de.htwg.mastermind.model.IField;
import de.htwg.mastermind.model.implementierung.Field;
import de.htwg.mastermind.model.implementierung.Square;


import de.htwg.mastermind.util.observer.Observable;

public class MastermindController extends Observable implements IMastermindController{

	private IField gamefield;	
	private String statusLine;
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	
	public MastermindController(IField gamefield) {  
		this.gamefield = gamefield;
	}
	
	/*
	 * create a new Field to play
	 * @param size size of the Field
	 */
	public void createField() {
		this.gamefield = new Field(FOUR,SIX);
		statusLine = "New Field was created";
		this.setSolution();
		notifyObservers();
	}
	
	
	
	/*
	 * bestimme farbkombination der loesung
	 */
	public void setSolution() {
				
		int pos = 0;
		Square color [] = this.createSolution();		
		
		for(Square c: color ) {
			gamefield.setSolution(c, pos);
			pos++;		
		}
	}
	
	public Square [] getSolution() {
		return gamefield.getSolution();
	}
	
	public Square [] createSolution() {
		
		Square color[] = new Square[gamefield.getSize()];
	
		for (int i = 0; i< gamefield.getSize();i++) {
			color[i] = new Square();
			int rnd = (int) (Math.random() * (SIX));
			if (rnd == 0) {
				color [i].setColor('R');
			} else if(rnd == ONE) {
				color [i].setColor('B');
			} else if (rnd == TWO) {
				color [i].setColor('O'); 
			} else if (rnd == THREE) {
				color[i].setColor('W');
			} else if ( rnd == FOUR) {
				color[i].setColor('G');
			} else if( rnd == FIVE) {
				color[i].setColor('Y');
			} else {
				color[i].setColor('_');
			}
		}		
		return color;
	}
	
	
	public void setVisibleSolution(boolean visible) {
		gamefield.setVisibleSolution(visible);
		gamefield.setAktiv(gamefield.getHeight());
		statusLine = "You Lose!!!!";
		notifyObservers();
	}
	
	/*
	 * gibt das Spielfeld als String zurueck
	 */
	public String getGamfieldString(){
		return gamefield.toString();
	}

	public void charToSquareAndSetForTUI(char [] color) {
		int x = 0;
		for(char c: color) {
			this.setPlayerColor(c,x);
			x++;
		}
	}
	
	//TODO
	//Komponenten 
	public void setPlayerColor(char color, int pos) {
		Square sq = new Square();

		sq.setColor(color);
		if(gamefield.setGameRectangleColor(sq,pos)) {
			statusLine = "Color: "+ color+" was set!";
		} else {
			statusLine = "Game ist over!";
		}
			
		notifyObservers();
	}
	
	/*
	 * auswerten der Farbkombinationen die vom Spieler gesetzt wurden
	 * und ueberpruefen ob der spieler gewonnen hat
	 */
	public void setBlackOrWith() {
		Square [] playerSetColor = gamefield.getGameRectangleColor();
		Square [] solutionColor = gamefield.getSolution();
		int size = gamefield.getSize(),count = 0;
		boolean whihteAvaliable = false;
		
		HashMap<Integer,Character> blackWhiteContainer = new HashMap<Integer,Character>();
		
		if(solutionColor == null || playerSetColor == null ) {
			statusLine= "FAIL";
			return;
		}
		
		
		for (int x = 0; x < size;x++) {
			whihteAvaliable = false;
			for(int y = 0; y < size;y++) {
				
				/*wenn farbe und positionen gleich ist*/
				if (playerSetColor[x].getColor() == solutionColor[y].getColor()) {
					if(x == y) {
						blackWhiteContainer.put(x, 'B');
						break;
					} 
					else if(blackWhiteContainer.containsKey(x) && blackWhiteContainer.get(x) != 'B' &&  !whihteAvaliable) {
							blackWhiteContainer.put(x, 'W');
							 whihteAvaliable = true;
					} else if (!whihteAvaliable){
						 whihteAvaliable = true;
						 blackWhiteContainer.put(x, 'W');
					}
				}
			}
		}		
		for( Entry<Integer, Character> entry :blackWhiteContainer.entrySet()) {
			if(entry.getValue() =='B') {
				Square sq = new Square();
				sq.setColor('B');
				gamefield.setInformation(sq, count);
				count++;
			}			
		}
		for( Entry<Integer, Character> entry :blackWhiteContainer.entrySet()) {
			if(entry.getValue() == 'W') {
				Square sq = new Square();
				sq.setColor('W');
				gamefield.setInformation(sq, count);
				count++;
			}
		}	
		
		if(!this.checkWin()) {
			if(gamefield.getAktiv()+1 == gamefield.getHeight()) {				
				gamefield.setVisibleSolution(true);
				statusLine= "You lose!!!!!!!";
			}
		}
			
		/*if fuer ende der Spielrunde*/
		gamefield.setAktiv(gamefield.getAktiv()+1);	
		notifyObservers();
	}
	
	
	private boolean checkWin() {
		Square[] unit = gamefield.getInformation();
		int size = gamefield.getSize();
		for(int x = 0; x< size; x++) {
			if(!(unit[x].getColor() == 'B')) {
				statusLine = "Noch einen Versuch";
				return false;
			}
		}
		statusLine = "You win.";
		return true;
	}	
	public String getStatus() {
		return statusLine;
	}
}