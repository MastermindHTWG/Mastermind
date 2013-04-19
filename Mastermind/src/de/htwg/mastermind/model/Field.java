package de.htwg.mastermind.model;

public class Field {

	Rectangle [] rec;
	
	public Field(){
		rec = new Rectangle[3];
		rec[0] =  new ColorSelection();
		rec[1] = new Rectangle(1);
		rec[2] = new Solution(1);
		
	}
	public Field(int size, int length) {
	
		rec = new Rectangle[length+2];
		rec[0] = new ColorSelection();
		for (int i = 1 ; i <=length; i++) {
			rec[i] = new Rectangle(size);
		}
		rec[length+1] = new Solution(size);
	}
	
}
