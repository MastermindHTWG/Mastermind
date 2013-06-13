package de.htwg.mastermind.model;

import de.htwg.mastermind.model.implementierung.Square;

public interface IField {
	
	int getSize();
	
	int getHeight();
	
	void setSolution(Square color, int pos);
	
	Square[] getSolution();
	
	boolean setGameRectangleColor(Square color,int pos);
	
	Square[] getGameRectangleColor();
	
	boolean setAktiv(int pos);
	
	int getAktiv();
	
	void setInformation(Square color, int pos);
	
	Square[] getInformation();
	
	void setVisibleSolution(boolean visible);
}
	



