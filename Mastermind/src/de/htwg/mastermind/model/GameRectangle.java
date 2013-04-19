package de.htwg.mastermind.model;

public class GameRectangle extends Rectangle {


	Information [] info;
	//Check 
	
	GameRectangle(int size) {
		super(size);
		info = new Information[size];
	}
	
	/*
	 * @param pos : Integer ob richtige Farbe gewaehlt wurde
	 * @param color : String schwarz oder weiﬂ
	 * wird von algorithmus gesetzt
	 */
//	void setInformation(int pos, String color) {
//		info[pos].setInfoColor(color);
//	}
}
