package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerSetColorTest {

	PlayerSetColor one;
	@Before
	public void setUp() throws Exception {
		one = new PlayerSetColor(4);
	}

	@Test
	public void getSquareColorTestEquals() {
		one.setColor(0, "R");
		one.setColor(1, "R");
		one.setColor(2, "R");
		one.setColor(3, "R");
		
		assertArrayEquals(new String [] {"R","R","R","R"},one.getSquareColor());		
	}
}
