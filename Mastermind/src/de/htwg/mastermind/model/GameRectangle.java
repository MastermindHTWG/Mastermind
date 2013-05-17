package de.htwg.mastermind.model;

public class GameRectangle {


	private PlayerSetColor psc;
	private Information info;
	 
	
	public GameRectangle(int size) {
		
		psc = new PlayerSetColor(size);
		info = new Information(size);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		
		
		sb.append(info.row()).append(psc.row()).append(newLine);
		sb.append(info.column()).append(psc.column()).append(newLine);
		sb.append(info.row()).append(psc.row());
		return sb.toString();
	}
	public void playerSetColor(char color,int pos) {
		psc.setColor(color, pos); 
	}
	/*
	 * gebe info farben zurueck
	 */
	public void infoSetColor(char color,int pos) {
		info.setColor(color, pos);
	}
	/*
	 * gebe gesetzte farben zurueck
	 */
	public char[] getSetColor() {
		return psc.getSquareColor();
	}
	
	
	
}
