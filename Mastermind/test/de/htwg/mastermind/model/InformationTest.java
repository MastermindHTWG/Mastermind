package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.implementierung.Information;
import de.htwg.mastermind.model.implementierung.Square;

public class InformationTest {

	Information one;
	Square sq;
	
	@Before
	public void setUp() {
		one = new Information(1);
		sq = new Square();
		sq.setColor('B');
	}

	@Test
	public void setGetInfoColortest() {
		one.setColor(sq,0);
		Square [] sqarr = one.getSquareColor();
		assertEquals(sq.getColor(),sqarr[0].getColor());
	}

}
