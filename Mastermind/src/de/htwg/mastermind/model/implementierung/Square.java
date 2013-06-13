package de.htwg.mastermind.model.implementierung;




public class Square {

	private char color;
	
	
	public Square() {
		this.color = '_'; 
	}
	
	/*
	 * @param color, color of the circles
	 */
	public void setColor(char color) {
		this.color = color;
	}
	/*
	 * @return color of the square
	 */
	public char getColor() {
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
