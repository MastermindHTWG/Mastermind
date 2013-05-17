package de.htwg.mastermind.model;

public class Square {

	private static final int HASH = 31;
	private char color;
	
	
	public Square() {
		this.color = '_'; 
	}
	
	void setColor(char color) {
		this.color = color;
	}
	char getColor() {
		return this.color;
	}
	/*
	 * retruns a String of the form (color)
	 */
	
	@Override
	public String toString() {		
		StringBuilder sb = new StringBuilder();
		return sb.append("(").append(color).append(")").toString();
		
	}
}
