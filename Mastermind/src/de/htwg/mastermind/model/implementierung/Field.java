package de.htwg.mastermind.model.implementierung;

import de.htwg.mastermind.model.IField;


public class Field implements IField{

	private Rectangle [] rec;
	private GameRectangle [] game;
	
	private int size = 1;
	private boolean [] aktiv;

	
	public Field(){
		this.aktiv = new boolean[1];
		aktiv[0] = true;
		this.game = new GameRectangle[size];
		this.game[0] = new GameRectangle(size);
		this.rec = new Rectangle[2];
		this.rec[0] =  new ColorSelection();
		this.rec[1] =new Solution(1);
		
	}
	
	public Field(int size) {
		this.size = size;
		this.game = new GameRectangle[size];
		this.aktiv = new boolean[size];
		this.aktiv[0] = true;
		this.rec = new Rectangle[2];
		this.rec[0] =  new ColorSelection();
		this.rec[1] = new Solution(size);
		for (int i = 0 ; i <size; i++) {
			this.game[i] = new GameRectangle(size);
		}
	}
	
	/*
	 * @return numbers of squares in a Gamefield
	 */
	public int getSize() {
		return this.size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		
		/*Solution*/
		sb.append(this.rec[1].toString()).append(newLine);
		/*GameRectangle*/
		for(int i = size-1; i >= 0; i--)  {
			sb.append(this.game[i].toString()).append(aktiv[i]).append(newLine);
		}
		/*ColorSelection*/
		sb.append(this.rec[0]);
		
		return sb.toString();
	}
	
	/*
	 *@param color color of one solution
	 *qparam pos at postion pos
	 */
	public void setSolution(char color, int pos) {
		if(pos < size) {
			this.rec[1].setColor(color, pos);			
		}			
	}
	/*
	 *@return char [] of solution
	 */
	public char[] getSolution() {
		return rec[1].getSquareColor();
	}
	
	/*
	 *@ param color: set the player Color
	 */
	public void setGameRectangleColor(char [] color) {
		int pos = 0,x = 0;
		pos = this.getAktiv(); 
		for(char tmp: color) {
			game[pos].playerSetColor(tmp, x);
			x++;
		}		
	}
	/*
	 *@ return char[] of color form Player
	 */
	public char[] getGameRectangleColor() {
		int pos = this.getAktiv(); 
		return game[pos].getSetColor();
	}

	
	/*
	 * setze eine Spieleinheit aktiv
	 * @return 
	 * false = weiterspielen
	 * true = spiel fertig
	 */
	public boolean setAktiv(int pos) {
		if (pos < size) {
			aktiv[pos-1] = false;
			aktiv[pos] = true;
			return true;
		} else {
			aktiv[size-1] = false;
			return false;
		}			
	}
	
	/*
	 * @return position of the active GameRectangle 
	 */
	public int getAktiv() {
		int pos = 0;
		for(int i = 0; i < size; i++ ) {
			if (aktiv[i]) {
				pos = i;
			}				
		}			
		return pos;
	}
	
	/*
	 *@ return Information as char []
	 */
	public char [] getInformation() {
		int arrayPos = this.getAktiv();
		return game[arrayPos].informationGetColor();
	}
	
	/*
	 * set the Informations white or black if the color in 
	 * PlayerSetColor is right (position)
	 * @param color
	 * @param pos position of the array in Information
	 */
	public void setInformation(char color, int pos) {
		int arrayPos = this.getAktiv();
		game[arrayPos].informationSetColor(color, pos);	
	}
	
	/*
	 *@param visible true visible show solution
	 *				 false show *
	 */
	public void setVisibleSolution(boolean visible) {
		((Solution) rec[1]).setVisible(visible);
	}
	
	public boolean getVisibleSolution() {
		return ((Solution) rec[1]).getVisible();
	}
}

