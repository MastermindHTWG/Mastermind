package de.htwg.mastermind.model;

public class Field {

	private Rectangle [] rec = {new ColorSelection(), new Solution(1)} ;
	private GameRectangle [] game;
	private int size = 1;
	private boolean [] aktiv;
	
	
	public Field(){
		this.aktiv = new boolean[1];
		aktiv[0] = true;
		this.game = new GameRectangle[size];
		this.game[0] = new GameRectangle(size);
	
		
	}
	public Field(int size) {
		this.size = size;
		this.game = new GameRectangle[size];
		this.aktiv = new boolean[size];
		this.aktiv[0] = true;
		for (int i = 0 ; i <size; i++) {
			this.game[i] = new GameRectangle(size);
		}
	}
	/*TODO logik controller*/
	public void setAktiv(int position) {
			aktiv[position-1] = true;
			aktiv[position-2] = false;	
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		
		/*Solution*/
		sb.append(this.rec[1]).append(newLine);
		for(int i = size-1; i >= 0; i--)  {
			sb.append(this.game[i].toString()).append(aktiv[i]).append(newLine);;
		}
		/*ColorSelection*/
		sb.append(this.rec[0]);
		
		return sb.toString();
	}
	
}
