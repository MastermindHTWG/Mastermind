package de.htwg.mastermind.model;

public class Square {

	private static final int HASH = 31;
	private String color;
	
	
	public Square() {
		this.color = "_"; 
	}
	
	void setColor(String color) {
		this.color = color;
	}
	String getColor() {
		return this.color;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Square && this.color.equals(((Square) obj).getColor())) {
			return true;
		} 
			return false;
	}	
	@Override
	public int hashCode() {
		int adr = 0;
		for(int i = 0 ; i< this.color.length(); i++) {
			adr = adr*HASH + this.color.charAt(i);
		}
		return adr;
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
