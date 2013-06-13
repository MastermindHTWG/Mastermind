package de.htwg.mastermind.controller;

import de.htwg.mastermind.model.implementierung.Square;
import de.htwg.mastermind.util.observer.IObservable;

public interface IMastermindController extends IObservable{

	
	Square[] createSolution();
	
	void setSolution();
	
	public void setPlayerColor(char color, int pos);
	
	void setBlackOrWith();
	
	void setVisibleSolution(boolean visible);
		
	void createField();
	
	String getGamfieldString();
	
	String getStatus();

	void charToSquareAndSetForTUI(char[] pat);
}
