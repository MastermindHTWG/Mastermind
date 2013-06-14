package de.htwg.mastermind.model.implementierung;

public class ColorSelection extends Rectangle{

	private static final int COLORSIZE = 6;
	private static final int NULL = 0;
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	
	public ColorSelection() {
		super(COLORSIZE);
		Square [] unit = this.getSquare();
		
		
		unit[NULL].setColor('R');
		unit[ONE].setColor('B');
		unit[TWO].setColor('O');
		unit[THREE].setColor('W');
		unit[FOUR].setColor('G');
		unit[FIVE].setColor('P');
	}

}
