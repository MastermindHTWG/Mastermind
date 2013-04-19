package de.htwg.mastermind.model;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.Square;

public class SquareTest {

	Square one;
	Square two;
	
	@Before
	public void setUp() {
		one = new Square();
		two = new Square();
	}
	
	@Test
	public void testSquareGetColor() {
		one.setColor("red");
		assertEquals("red",one.getColor().toString());
	}
	@Test
	public void hashCodeTest() {
		one.setColor("red");
		two.setColor("red");
		assertEquals(two.hashCode(),one.hashCode());
		
	}
	
	@Test
	public void trueEqualsTest() {
		one.setColor("red");
		two.setColor("red");
		assertTrue(one.equals(two));
	}
	@Test
	public void falseEqualsTest() {
		one.setColor("red");
		two.setColor("blue");
		assertFalse(one.equals(two));
	}
}
