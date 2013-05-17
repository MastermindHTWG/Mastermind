package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.GameRectangle;

public class GameRectangleTest {

	GameRectangle one;
	GameRectangle two;
	GameRectangle three;
	StringBuilder sb;
	@Before
	public void setUp() {
		one = new GameRectangle(1);
		two = new GameRectangle(1);
		three = new GameRectangle(1);
		three.playerSetColor('B', 0);
	}
	


	@Test
	public void toStringTest() {
		assertEquals( one.toString(), two.toString());
	}
	
	@Test
	public void Test() {
		char [] eingabe = new char [] {'B'}; 
		char [] ausgabe = three.getSetColor();
//assertt
//		assertTrue(eingabe[0].equals(ausgabe[0])); 
		
		
	}
}
