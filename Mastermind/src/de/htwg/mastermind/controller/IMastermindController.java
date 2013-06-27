package de.htwg.mastermind.controller;

import java.awt.Color;

import de.htwg.mastermind.model.implementierung.Square;
import de.htwg.mastermind.util.observer.IObservable;

public interface IMastermindController extends IObservable{

	
	Square[] createSolution(boolean tmp);
	
	void setSolution(boolean tmp);
	
	void setPlayerColor(char color, int pos, int click);
	
	void setBlackOrWhite();
	
	void setVisibleSolution(boolean visible);
		
	void createField();
	
	String getGamfieldString();
	
	String getStatus();

	void charToSquareAndSetForTUI(char[] pat);
	
	 Color [][]getPlayerColor();
	
	int [] getClick();
	
	Color [][] getInfoColor();
	
	Color [] getSolutionColor();
	
	int getSize();
	
	int getHeight();
	
}
