package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RectangleTest {


	Rectangle one;
	Rectangle two;
	
	@Before
	public void setUp() {
		one = new Rectangle(1);
		one.setSquare(new Square(),0);
		two = new Rectangle(1);
		two.setSquare(new Square(),0);
	}

	@Test
	public void test() {

		assertEquals(one.toString(), two.toString());
	}
	@Test
	public void getSqaureTests() {
		assertArrayEquals(one.getSquare(), two.getSquare());
	}

}
