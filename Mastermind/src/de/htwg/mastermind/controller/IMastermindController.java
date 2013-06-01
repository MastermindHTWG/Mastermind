package de.htwg.mastermind.controller;

public interface IMastermindController {

	
	public  char [] createSolution();
	
	public String getGamfieldString();
	
	public void playerSetColor(char [] color);
	
	public void setBlackOrWith();
	
	public void setVisibleSolution(boolean visible);
	
	public void setSolution();
}
