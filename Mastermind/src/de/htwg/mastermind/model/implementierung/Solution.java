package de.htwg.mastermind.model.implementierung;


public class Solution extends Rectangle{
	private boolean  visible = false;
	
	public Solution( int count ) {
		super(count);
		
	}
	
	/*
	 * set the visible of solution
	 * @param visible 
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	/*
	 * @return the state of visibke
	 */
	public boolean getVisible() {
		return this.visible;
	}

	@Override
	public String column() {
		int size = this.getSize();
		Square [] sq = this.getSquare();
	
		StringBuilder sb = new StringBuilder();
		sb.append("|");
		for (int i = 0; i < size; i++) {
			if(visible) {
				sb.append(sq[i].toString()).append(" ");
			} else {
				sb.append("(*)").append(" ");
			}
			
		}
		sb.append("|");
		return sb.toString();
	}
}
