package de.htwg.mastermind.model.implementierung;

import de.htwg.mastermind.model.IField;



public class Field implements IField{

	private Rectangle [] rec;
	private GameRectangle [] game;
	private int height = 1;
	private int size = 1;
	private int aktiv;

	
	public Field(){
		this.aktiv = 0;
		this.game = new GameRectangle[1];
		this.game[0] = new GameRectangle(size);
		this.rec = new Rectangle[2];
		this.rec[0] =  new ColorSelection();
		this.rec[1] =new Solution(1);	
	}
	
	public Field(int size,int height) {
		this.height = height;
		this.size = size;
		this.game = new GameRectangle[height];
		this.aktiv = 0;
		this.rec = new Rectangle[2];
		this.rec[0] =  new ColorSelection();
		this.rec[1] = new Solution(size);
		for (int i = 0 ; i <height; i++) {
			this.game[i] = new GameRectangle(size);
		}
	}
	
	/*
	 * @return numbers of squares in a Gamefield
	 */
	public int getSize() {
		return this.size;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		
		/*Solution*/
		sb.append(this.rec[1].toString()).append(newLine);
		/*GameRectangle*/
		for(int i = height-1; i >= 0; i--)  {
			sb.append(this.game[i].toString()).append(aktiv).append(newLine);
		}
		/*ColorSelection*/
		sb.append(this.rec[0]);
		
		return sb.toString();
	}
	
	/*
	 *@param color color of one solution
	 *qparam pos at postion pos
	 */
	public void setSolution(Square color, int pos) {
		if(pos < size) {
			this.rec[1].setColor(color, pos);			
		}			
	}
	/*
	 *@return char [] of solution
	 */
	public Square[] getSolution() {
		return rec[1].getSquareColor();
	}
	
	/*
	 *@ param color: set the player Color
	 */
	public boolean setGameRectangleColor(Square color,int pos) {
		int aktiv = this.getAktiv();
			if(aktiv != -1) {
				game[aktiv].playerSetColor(color, pos);
				return true;
			} else {
				return false;
			}
			
		
	}
	/*
	 *@ return char[] of color form Player
	 */
	public Square[] getGameRectangleColor() {
		int pos = this.getAktiv(); 
		if(pos != -1) {
			return game[pos].getSetColor();
		} else {
			return null;
		}
		
	}

	
	/*
	 * setze eine Spieleinheit aktiv
	 * @return 
	 * false = weiterspielen
	 * true = spiel fertig
	 */
	public boolean setAktiv(int pos) {
		if(pos < this.height) {
			this.aktiv = pos;
			return true;
		} else {
			this.aktiv = -1;
			return false;
		}
			
	}
	
	/*
	 * @return position of the active GameRectangle 
	 */
	public int getAktiv() {
		return this.aktiv;
	}
	
	/*
	 *@ return Information as char []
	 */
	public Square [] getInformation() {
		int arrayPos = this.getAktiv();
		if(arrayPos != -1) {
			return game[arrayPos].informationGetColor();
		}
		return null;
		
	}
	
	/*
	 * set the Informations white or black if the color in 
	 * PlayerSetColor is right (position)
	 * @param color
	 * @param pos position of the array in Information
	 */
	public void setInformation(Square color, int pos) {
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






	
}

