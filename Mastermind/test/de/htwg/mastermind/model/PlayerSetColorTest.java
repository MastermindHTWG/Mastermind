package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.implementierung.PlayerSetColor;

public class PlayerSetColorTest {

	PlayerSetColor one;
	@Before
	public void setUp() throws Exception {
		one = new PlayerSetColor(4);
	}

	@Test
	public void getSquareColorTestEquals() {
		one.setColor('R',0);
		one.setColor('R',1);
		one.setColor('R',2);
		one.setColor('R',3);
		
		assertArrayEquals(new char [] {'R','R','R','R'},one.getSquareColor());		
	}
}
