package de.htwg.mastermind.model;

public class GameRectangle {


	PlayerSetColor psc;
	Information info;
	 
	
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
}
