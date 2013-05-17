package de.htwg.mastermind.model;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.Square;

public class SquareTest {

	Square one;
	Square two;
	Square toString;
	
	@Before
	public void setUp() {
		one = new Square();
		two = new Square();
		toString = new Square();
	}
	
	@Test
	public void testSquareGetColor() {
		one.setColor('R');
		assertEquals("(R)",one.toString());
	}

	
	@Test
	public void toStringTest() {
		toString.setColor('B');
		assertEquals(toString.toString(),"(B)");
		
		
	}
}
