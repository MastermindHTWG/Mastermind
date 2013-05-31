package de.htwg.mastermind.model;

public interface IField {
	
	public int getSize();
	
	public void setSolution(char color, int pos);
	
	public char[] getSolution();
	
	public void setGameRectangleColor(char [] color);
	
	public char[] getGameRectangleColor();
	
	public boolean setAktiv(int pos);
	
	public int getAktiv();
	
	public void setInformation(char color, int pos);
	
	public void setVisibleSolution(boolean visible);
	
	public char [] getInformation();
}



