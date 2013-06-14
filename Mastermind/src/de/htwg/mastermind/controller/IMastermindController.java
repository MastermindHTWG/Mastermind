package de.htwg.mastermind.controller;

import java.awt.Color;

import de.htwg.mastermind.model.implementierung.Square;
import de.htwg.mastermind.util.observer.IObservable;

public interface IMastermindController extends IObservable{

	
	Square[] createSolution();
	
	void setSolution();
	
	void setPlayerColor(char color, int pos, int click);
	
	void setBlackOrWith();
	
	void setVisibleSolution(boolean visible);
		
	void createField();
	
	String getGamfieldString();
	
	String getStatus();

	void charToSquareAndSetForTUI(char[] pat);
	
	 Color [][]getPlayerColor();
	
	int [] getClick();
	
	Color [][] getInfoColor();
	
	Color [] getSolutionColor();
	
}
