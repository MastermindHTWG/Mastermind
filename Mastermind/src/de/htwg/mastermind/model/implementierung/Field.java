package de.htwg.mastermind.model.implementierung;

import com.google.inject.Inject;
import com.google.inject.name.Named;

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
	
	@Inject 
	public Field(@Named("size") int size,@Named("height") int height) {
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
	 * @return the size from the field
	 */
	public int getSize() {
		return this.size;
	}
	/*
	 * @return the height from the field
	 */
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
	 * set the color at position pos
	 * @param color
	 * @param pos
	 */
	public void setSolution(Square color, int pos) {
		if(pos < size) {
			this.rec[1].setColor(color, pos);			
		}			
	}
	/*
	 * @return the solution in an array
	 */
	public Square[] getSolution() {
		return rec[1].getSquareColor();
	}
	
	/*
	 * set the player color  to position pos
	 * @param color
	 * @param pos
	 * @return boolean
	 */
	public boolean setGameRectangleColor(Square color,int pos) {
			if(aktiv != -1) {
				game[aktiv].playerSetColor(color, pos);
				return true;
			} else {
				return false;
			}
			
		
	}
	/*
	 * @return the color in the actual gameRectangle
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
	 * set the next game rectangle activ
	 * @param pos
	 * @return boolean
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
	 * @return the pos of the actual activ gamerectangle
	 */
	public int getAktiv() {
		return this.aktiv;
	}
	
	/*
	 * set the information by KI
	 * @param color
	 * @param pos
	 */
	public Square [] getInformation() {
		int arrayPos = this.getAktiv();
		if(arrayPos != -1) {
			return game[arrayPos].informationGetColor();
		}
		return null;
		
	}
	/*
	 * @return the prev info
	 */
	public Square [] getPrevInformation() {
		int arrayPos = this.getAktiv();
		if(arrayPos != -1) {
		
			return game[0].informationGetColor();
		}
		return null;
		
	}
	
	/*
	 * set the information by KI
	 * @param color
	 * @param pos
	 */
	public void setInformation(Square color, int pos) {
		int arrayPos = this.getAktiv();
		game[arrayPos].informationSetColor(color, pos);	
	}
	
	/*
	 * set the solution visible
	 * @param visible
	 */
	public void setVisibleSolution(boolean visible) {
		((Solution) rec[1]).setVisible(visible);
	}
	/*
	 * @return true for visbile false for unvisible
	 */
	public boolean getVisibleSolution(){
		return  ((Solution)rec[1]).getVisible();
	}
	

}

