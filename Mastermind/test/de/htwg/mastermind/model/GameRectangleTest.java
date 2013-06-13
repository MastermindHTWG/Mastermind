package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.implementierung.GameRectangle;
import de.htwg.mastermind.model.implementierung.Square;

public class GameRectangleTest {

	GameRectangle one;
	GameRectangle two;
	GameRectangle three;
	Square sq;
	@Before
	public void setUp() {
		one = new GameRectangle(1);
		two = new GameRectangle(1);
		three = new GameRectangle(1);
		sq = new Square();
		sq.setColor('B');
		three.playerSetColor(sq, 0);
	}
	
	@Test
	public void infoTest() {
		one.informationSetColor(sq, 0);
		Square [] tmp = one.informationGetColor();
		assertTrue('B' == tmp[0].getColor());
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
