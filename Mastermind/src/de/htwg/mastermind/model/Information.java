package de.htwg.mastermind.model;

/*
 * Kontrollanzeige f�r Spieler ob er die Farben richtig erraten hat
 */
public class Information {

	String color;
	
	Information() {
		this.color = null;
	}
	
	void setInfoColor( String color) {
		this.color = color;
	}
}
