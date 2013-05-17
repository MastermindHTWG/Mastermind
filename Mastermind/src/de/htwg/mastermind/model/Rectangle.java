package de.htwg.mastermind.model;
/*
 * 
 */

public class Rectangle {

	private int size;
	private Square [] unit;
	
	public Rectangle(int size) {
		
		this.size = size;
		unit = new Square [size];
		for(int i = 0; i<size;i++) {
			unit[i] = new Square();
		}
	}
	
	public Square[] getSquare() {
		return this.unit;
	}
	
	/*
	 * farbe setzen
	 */
	public void setColor(char color, int pos) {
		unit[pos].setColor(color); 
	}
	
	public char[] getSquareColor(){
		
		char [] color = new char[unit.length];
		int i = 0;
		for(Square tmp: unit) {
	
			color[i] = tmp.getColor();
			i++;
		}
		return  color;		
	}
	
	@Override
	public String toString() {
		String newLine = System.getProperty("line.separator");
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(row());
		sb.append(newLine);
		sb.append(column());
		sb.append(newLine);
		sb.append(row());
		return sb.toString();
		
	}

	/*
	 * return a String of the form (size 1) +----+
	 */
	
	public String row() {
		StringBuilder sb = new StringBuilder();
		sb.append("+");
		for (int i = 0; i < this.size; i++) {
			sb.append("----");
		}
		sb.append("+");
		return sb.toString();
	}
	
	/*
	 * have to override for each class (for the correct content)
	 * return a string of the form |    |
	 */
	public String column() {
		StringBuilder sb = new StringBuilder();
		sb.append("|");
		for (int i = 0; i < this.size; i++) {
			sb.append(unit[i].toString()).append(" ");
		}
		sb.append("|");
		return sb.toString();
	}
}
