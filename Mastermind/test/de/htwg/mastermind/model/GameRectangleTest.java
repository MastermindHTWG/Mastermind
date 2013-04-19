package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.GameRectangle;

public class GameRectangleTest {

	GameRectangle one;
	
	@Before
	public void setUp() {
		one = new GameRectangle(1);
		one.setSquare(0, "red");
	}

	@Test
	public void test() {
		
		assertArrayEquals(new String[] {"red"},one.getSquareColor());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testException() {
		one.setSquare(10, "blue");
	}

}
