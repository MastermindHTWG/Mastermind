package de.htwg.mastermind.model;

public class ColorSelection extends Rectangle{

	ColorSelection() {
		super(6);
		setColor();
	}
	
	/*
	 * Setzt farben für die Farbauswahl
	 */
	public void setColor() {
		unit[0].setColor("R");
		unit[1].setColor("B");
		unit[2].setColor("O");
		unit[3].setColor("W");
		unit[4].setColor("G");
		unit[5].setColor("Y");

	}
	
//	@Override
//	public String toString() {
//		System.out.println(Geben Sie die Position);
//	}

}
