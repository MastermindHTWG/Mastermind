package de.htwg.mastermind.controller;

import java.awt.Color;

import de.htwg.mastermind.model.implementierung.Square;
import de.htwg.mastermind.util.observer.IObservable;

public interface IMastermindController extends IObservable{

	/*
	 * return a solution created by the ki
	 * @param tmp false = create an ki solution true create an fixed solution
	 * @return square []
	 */
	Square[] createSolution(boolean tmp);
	
	/*
	 * set the created solution
	 * param tmp the same as createSolution(..)
	 */
	void setSolution(boolean tmp);
	
	/*
	 * player set color
	 * @param color
	 * @param pos
	 * @param click for color 
	 */
	void setPlayerColor(char color, int pos, int click);
	
	/*
	 * set the information ki algo
	 */
	void setBlackOrWhite();
	
	/*
	 * show the solution
	 * @param visible 
	 */
	void setVisibleSolution(boolean visible);
		
	/*
	 * create an fixed filed 1
	 */
	void createField();
	
	/*
	 * @return string 
	 */
	String getGamfieldString();
	
	/*
	 * @return status string
	 */
	String getStatus();

	/*
	 * cast an char to square 
	 */
	void charToSquareAndSetForTUI(char[] pat);
	
	/*
	 * @return color[][]
	 */
	Color [][]getPlayerColor();
	
	/*
	 * @return the click of an square
	 */
	int [] getClick();
	
	/*
	 * @return color[]
	 */
	Color [][] getInfoColor();
	
	/*
	 * @return color[][]
	 */
	Color [] getSolutionColor();
	
	/*
	 * @return size
	 */
	int getSize();
	
	/*
	 * return height
	 */
	int getHeight();
	
}
