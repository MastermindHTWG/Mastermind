package de.htwg.mastermind.controller;

public interface IMastermindController {

	
	char [] createSolution();
	
	void setSolution();
	
	void setPlayerColor(char [] color);
	
	void setBlackOrWith();
	
	void setVisibleSolution(boolean visible);
		
	void createField(int size);
	
	String getGamfieldString();
}
