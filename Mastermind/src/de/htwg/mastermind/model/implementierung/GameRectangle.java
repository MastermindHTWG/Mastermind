package de.htwg.mastermind.model.implementierung;


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
	
	/*
	 * @param color give color to playerSetColor
	 * @param pos give pos to playerSetColor
	 */
	public void playerSetColor(char color,int pos) {
		psc.setColor(color, pos); 
	}
	
	
	/*
	 * @retrun char [] from set color by player
	 */
	public char[] getSetColor() {
		return psc.getSquareColor();
	}
	
	
	/*
	 * @param color color on postion pos
	 * @param pos postion on array
	 */
	public void informationSetColor(char color,int pos) {
		info.setColor(color, pos);
	}
	
	
	/*
	 * @return return char [] of information Color
	 */
	public char [] informationGetColor() {
		return info.getSquareColor();
	}

	
	
	
}
