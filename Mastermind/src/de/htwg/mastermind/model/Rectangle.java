package de.htwg.mastermind.model;
/*
 * 
 */

public class Rectangle {

	int size;
	Square [] unit;

	
	Rectangle(int size) {
		this.size = size;
		unit = new Square [size];
		for(int i = 0; i<size;i++) {
			unit[i] = new Square();
		}
	}
	
	public void setSquare(int pos, String color) throws  IllegalArgumentException {
		if (pos >= size) {
			throw new  IllegalArgumentException("pos is not in range of size");
		}
		unit[pos].setColor(color); //TODO anpassen circle kann anwender setzen
	}
	
	public String[] getSquareColor(){
		
		String [] color = new String[unit.length];
		int i = 0;
		for(Square tmp: unit) {
	
			color[i] = tmp.getColor();
			i++;
		}
		return  color;		
	}

}
