package de.htwg.mastermind.model;

import de.htwg.mastermind.model.implementierung.Square;

public interface IField {
	/*
	 * @return the size from the field
	 */
	int getSize();
	
	/*
	 * @return the height from the field
	 */
	int getHeight();
	
	/*
	 * set the color at position pos
	 * @param color
	 * @param pos
	 */
	void setSolution(Square color, int pos);
	
	/*
	 * @return the solution in an array
	 */
	Square[] getSolution();
	
	/*
	 * set the player color  to position pos
	 * @param color
	 * @param pos
	 * @return boolean
	 */
	boolean setGameRectangleColor(Square color,int pos);
	
	/*
	 * @return the color in the actual gameRectangle
	 */
	Square[] getGameRectangleColor();
	
	/*
	 * set the next game rectangle activ
	 * @param pos
	 * @return boolean
	 */
	boolean setAktiv(int pos);
	
	/*
	 * @return the pos of the actual activ gamerectangle
	 */
	int getAktiv();
	
	/*
	 * set the information by KI
	 * @param color
	 * @param pos
	 */
	void setInformation(Square color, int pos);
	
	/*
	 * return the information in an square array
	 * @return square
	 */
	Square[] getInformation();
	
	/*
	 * set the solution visible
	 * @param visible
	 */
	void setVisibleSolution(boolean visible);
	
	/*
	 * @return true for visbile false for unvisible
	 */
	boolean getVisibleSolution();

}
	



