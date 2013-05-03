package de.htwg.mastermind.model;



public class ColorSelection extends Rectangle{

	private static final int COLORSIZE = 6;
	
	ColorSelection() {
		super(COLORSIZE);
		unit[0].setColor("R");
		unit[1].setColor("B");
		unit[2].setColor("O");
		unit[3].setColor("W");
		unit[4].setColor("G");
		unit[5].setColor("Y");
	}

}
