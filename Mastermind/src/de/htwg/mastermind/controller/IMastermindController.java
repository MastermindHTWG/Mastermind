package de.htwg.mastermind.controller;

public interface IMastermindController {

	
	char [] createSolution();
	
	String getGamfieldString();
	
	void playerSetColor(char [] color);
	
	void setBlackOrWith();
	
	void setVisibleSolution(boolean visible);
	
	void setSolution();
}
