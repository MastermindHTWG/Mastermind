package de.htwg.mastermind.controller.implementierung;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map.Entry;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.htwg.mastermind.controller.IMastermindController;
import de.htwg.mastermind.model.IField;
import de.htwg.mastermind.model.implementierung.Field;
import de.htwg.mastermind.model.implementierung.Square;


import de.htwg.mastermind.util.observer.Observable;
@Singleton
public class MastermindController extends Observable implements IMastermindController{

	private static final int R = 188;
	private static final int G = 210;
	private static final int B = 238;
	private IField gamefield;	
	private String statusLine;
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private int [] click;
	private Color [][] colorPlayer;
	private Color [][] colorInfo;
	private Color [] colorSolution;
	
	@Inject
	public MastermindController(IField gamefield) {
		this.gamefield = gamefield;
		this.click = new int [gamefield.getSize()];
		this.colorPlayer = new Color[gamefield.getHeight()][gamefield.getSize()];
		this.colorInfo = new Color[gamefield.getHeight()][gamefield.getSize()];
		this.colorSolution = new Color[gamefield.getSize()];
	}
	
	/*
	 * create a new Field to play
	 * @param size size of the Field
	 */
	public void createField() {
		this.gamefield = new Field(FOUR,SIX);
		statusLine = "New Field was created";
		this.setSolution(false);
		this.click = new int [gamefield.getSize()];
		this.colorPlayer = new Color[gamefield.getHeight()][gamefield.getSize()];
		this.colorInfo = new Color[gamefield.getHeight()][gamefield.getSize()];
		this.colorSolution = new Color[gamefield.getSize()];
		notifyObservers();
	}
	
	
	
	/*
	 * set the created solution
	 * param tmp the same as createSolution(..)
	 */
	public void setSolution(boolean tmp) {
				
		int pos = 0;
		Square color [] = this.createSolution(tmp);		
		
		for(Square c: color ) {
			gamefield.setSolution(c, pos);
			pos++;		
		}
	}
	/*
	 * @return the solution 
	 */
	public Square [] getSolution() {
		return gamefield.getSolution();
	}
	
	/*
	 * return a solution created by the ki
	 * @param tmp false = create an ki solution true create an fixed solution
	 * @return square []
	 */
	public Square [] createSolution(boolean tmp) {
		
		Square color[] = new Square[gamefield.getSize()];
		int rnd = 0,b = 0;
		for (int i = 0; i< gamefield.getSize();i++) {
			color[i] = new Square();
			
			rnd = (int) (Math.random() * (SIX));
			/*remove*/
			if(tmp){
				rnd = 1;
				b++;
			}
			if (b == 1) {
				rnd = 2;
			}
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
				color[i].setColor('P');
			}
		}		
		return color;
	}
	
	/*
	 * show the solution
	 * @param visible 
	 */
	public void setVisibleSolution(boolean visible) {
		gamefield.setVisibleSolution(visible);
		gamefield.setAktiv(gamefield.getHeight());
		statusLine = "You Lose!!!!";
		notifyObservers();
	}
	
	/*
	 * @return gamerectangle as string
	 */
	public String getGamfieldString(){
		return gamefield.toString();
	}

	/*
	 * cast an char to square 
	 */
	public void charToSquareAndSetForTUI(char [] color) {
		int x = 0;
		for(char c: color) {
			this.setPlayerColor(c,x,0);
			x++;
		}
	}
	/*
	 * player set color
	 * @param color
	 * @param pos
	 * @param click for color 
	 */
	public void setPlayerColor(char color, int pos, int click) {
		Square sq = new Square();
		
		sq.setColor(color);
		if(gamefield.setGameRectangleColor(sq,pos)) {
			this.click[pos] =click;
			statusLine = "Color: "+ color+" was set!";
		} else {
			statusLine = "Game is over!";
		}
			
		notifyObservers();
	}
	
	/*
	 * @return the click of an square
	 */
	public int [] getClick() {
		return this.click;
	}
	
	/*
	 * @return color[]
	 */
	public Color [][] getInfoColor(){
		Square [] getInfo = gamefield.getInformation();
		if(getInfo == null) {
			return colorInfo;
		}		
		int i = 0;
		for(Square s: getInfo) {
			if(s.getColor() == 'B') {
				colorInfo[gamefield.getAktiv()][i] = Color.BLACK;
			} else if(s.getColor() == 'W') {
				colorInfo[gamefield.getAktiv()][i] = Color.WHITE;
			} else if(s.getColor() == '_') {
				colorInfo[gamefield.getAktiv()][i] = new Color(R,G,B);
			} 
			i++;
		}
		return colorInfo;
		
	}
	
	/*
	 * @return color[][]
	 */
	public Color [][] getPlayerColor(){
		Square [] getCol =	gamefield.getGameRectangleColor();
		 
		if(getCol== null) {
			return colorPlayer;
		}		
		
		int i = 0;
		for(Square s: getCol) {
			if(s.getColor() == 'R') {
				colorPlayer[gamefield.getAktiv()][i] = Color.RED;
			} else if(s.getColor() == 'B') {
				colorPlayer[gamefield.getAktiv()][i] = Color.BLUE;
			} else if(s.getColor() == 'O') {
				colorPlayer[gamefield.getAktiv()][i] = Color.ORANGE;
			} else if(s.getColor() == 'W') {
				colorPlayer[gamefield.getAktiv()][i] = Color.WHITE;
			} else if(s.getColor() == 'G') {
				colorPlayer[gamefield.getAktiv()][i] = Color.GREEN;
			} else if(s.getColor() == 'P') {
				colorPlayer[gamefield.getAktiv()][i] = Color.PINK;
			} else {
				colorPlayer[gamefield.getAktiv()][i] = Color.GRAY;
			}
			i++;
		}
		
		return colorPlayer;
	}
	
	/*
	 * @return color[][]
	 */
	public Color [] getSolutionColor(){
		Square [] getCol =	gamefield.getSolution();
		
		
		int i = 0;
		for(Square s: getCol) {
			if(!gamefield.getVisibleSolution()){
				colorSolution[i] = Color.GRAY;
			} else if(s.getColor() == 'R') {
				colorSolution[i] = Color.RED;
			} else if(s.getColor() == 'B') {
				colorSolution[i] = Color.BLUE;
			} else if(s.getColor() == 'O') {
				colorSolution[i] = Color.ORANGE;
			} else if(s.getColor() == 'W') {
				colorSolution[i] = Color.WHITE;
			} else if(s.getColor() == 'G') {
				colorSolution[i] = Color.GREEN;
			} else if(s.getColor() == 'P') {
				colorSolution[i] = Color.PINK;
			}
			i++;
		}
		
		return colorSolution;
	}
	
	
	
	/*
	 * set the information ki algo
	 */
	public void setBlackOrWhite() {
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
		if(!this.checkWin() &&gamefield.getAktiv()+1 == gamefield.getHeight()) {			
				gamefield.setVisibleSolution(true);
				statusLine= "You lose!!!!!!!";
		}
			
		
		notifyObservers();
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
	/*
	 * @return status string
	 */
	public String getStatus() {
		return statusLine;
	}
	/*
	 * return height
	 */
	public int getHeight() {
		return gamefield.getHeight();
	}
	/*
	 * @return size
	 */
	public int getSize(){
		return gamefield.getSize();
	}
	
}