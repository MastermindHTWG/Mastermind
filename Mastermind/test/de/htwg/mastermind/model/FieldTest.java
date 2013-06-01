package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.implementierung.Field;

public class FieldTest {

	Field one;
	Field two;
	Field three;
	Field four;
	Field six;
	
	@Before
	public void setUp() {
		one = new Field();
		two = new Field();
		three = new Field(1);
		four  = new Field(1);
		six = new Field(2);
	}
	
	

	@Test
	public void toStringTest() {
		assertEquals(one.toString(), two.toString());
	}
	@Test
	public void fieldTest(){
		assertEquals(three.toString(), four.toString());
	}
	@Test
	public void getSizeTest() {
		/*benutze Field three zum Test ( mit groeﬂse 1)*/
		assertEquals(three.getSize(), 1);
	}
	@Test
	public void setGetAktivTest() {
		six.setAktiv(1);
		assertEquals(six.getAktiv(),1);
	}
	@Test
	public void setGetGameRectangleColorTest() {
		one.setGameRectangleColor(new char [] {'R'});
		assertArrayEquals(new char [] {'R'}, one.getGameRectangleColor());
	}
	@Test
	public void setGetSolution() {
		one.setSolution('R', 0);
		assertArrayEquals(new char [] {'R'}, one.getSolution());
	}
	
	@Test
	public void setGetInformationTest() {
		one.setInformation('B', 0);
		char [] tmp = one.getInformation();
		assertTrue(tmp[0] == 'B');
	}
	
	
	@Test
	public void setAktiv() {
		assertFalse(one.setAktiv(2));
	}
	
}
