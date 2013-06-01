package de.htwg.mastermind.model;

public interface IField {
	
	int getSize();
	
	void setSolution(char color, int pos);
	
	char[] getSolution();
	
	void setGameRectangleColor(char [] color);
	
	char[] getGameRectangleColor();
	
	boolean setAktiv(int pos);
	
	int getAktiv();
	
	void setInformation(char color, int pos);
	
	void setVisibleSolution(boolean visible);
	
	char [] getInformation();
}



