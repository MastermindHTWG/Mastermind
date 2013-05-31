package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.implementierung.GameRectangle;

public class GameRectangleTest {

	GameRectangle one;
	GameRectangle two;
	GameRectangle three;
	@Before
	public void setUp() {
		one = new GameRectangle(1);
		two = new GameRectangle(1);
		three = new GameRectangle(1);
		three.playerSetColor('B', 0);
	}
	
	@Test
	public void infoTest() {
		one.informationSetColor('B', 0);
		char [] tmp = one.informationGetColor();
		assertTrue('B' == tmp[0]);
	}
	


	@Test
	public void toStringTest() {
		assertEquals( one.toString(), two.toString());
	}
	
//	@Test
//	public void Test() {
//		char [] eingabe = new char [] {'B'}; 
//		char [] ausgabe = three.getSetColor();
//
//		assertTrue(eingabe[0] ==ausgabe[0]); 		
//	}
	
}
