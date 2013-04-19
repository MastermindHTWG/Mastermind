package de.htwg.mastermind.model;

public class ColorSelection extends Rectangle{

	ColorSelection() {
		super(8);
		setColor();
	}
	
	/*
	 * Setzt farben für die Farbauswahl
	 */
	public void setColor() {
		unit[0].setColor("red");
		unit[1].setColor("blue");
		unit[2].setColor("black");
		unit[3].setColor("white");
		unit[4].setColor("green");
		unit[5].setColor("yellow");
		unit[6].setColor("orange");
		unit[7].setColor("purple");		
	}

}
