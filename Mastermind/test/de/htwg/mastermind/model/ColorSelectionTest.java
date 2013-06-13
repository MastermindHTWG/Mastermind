package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.implementierung.ColorSelection;
import de.htwg.mastermind.model.implementierung.Square;

public class ColorSelectionTest {

	ColorSelection one;
	
	@Before
	public void setUp() throws Exception {
		one = new ColorSelection();
	}

	@Test
	public void test() {
		Square [] tmp = one.getSquareColor();
		assertEquals( 'R',tmp[0].getColor());
		assertEquals( 'B',tmp[1].getColor());
		assertEquals( 'O',tmp[2].getColor());
		assertEquals( 'W',tmp[3].getColor());
		assertEquals( 'G',tmp[4].getColor());
		assertEquals( 'Y',tmp[5].getColor());
	}


}
