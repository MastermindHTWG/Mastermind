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
		two = new Rectangle(1);
	}

	@Test
	public void test() {

		assertEquals(one.toString(), two.toString());
	}

}
