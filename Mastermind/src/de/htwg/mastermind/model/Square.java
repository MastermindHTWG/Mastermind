package de.htwg.mastermind.model;

public class Square {

	private String color;
	
	
	Square() {
		this.color = "brown"; // object zu viel
	}
	
	void setColor(String color) {
		this.color = color;
	}
	String getColor() {
		return this.color;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Square) {
			if (this.color.equals(((Square) obj).getColor())) {
				return true;
			}
		} 
			return false;
	}	
	@Override
	public int hashCode() {
		int adr = 0;
		for(int i = 0 ; i< this.color.length(); i++) {
			adr = adr*31 + this.color.charAt(i);
		}
		return adr;
	}
}
