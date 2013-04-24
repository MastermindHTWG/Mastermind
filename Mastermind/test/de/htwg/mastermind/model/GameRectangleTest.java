package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.GameRectangle;

public class GameRectangleTest {

	GameRectangle one;
	GameRectangle two;
	StringBuilder sb;
	@Before
	public void setUp() {
		one = new GameRectangle(1);
		two = new GameRectangle(1);
	}
	


	@Test
	public void toStringTest() {
		assertEquals( one.toString(), two.toString());
	}

}
