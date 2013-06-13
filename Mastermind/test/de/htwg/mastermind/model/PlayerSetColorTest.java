package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.implementierung.PlayerSetColor;
import de.htwg.mastermind.model.implementierung.Square;

public class PlayerSetColorTest {

	PlayerSetColor one;
	Square sq;
	@Before
	public void setUp() throws Exception {
		one = new PlayerSetColor(1);
		sq = new Square();
		
	}

	@Test
	public void getSquareColorTestEquals() {
		sq.setColor('R');
		one.setColor(sq,0);
		Square [] sqarr = one.getSquareColor();

		
		assertEquals(sq.getColor(),sqarr[0].getColor());		
	}
}
