package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.implementierung.Field;
import de.htwg.mastermind.model.implementierung.Square;

public class FieldTest {

	Field one;
	Field two;
	Field three;
	Field four;
	Field six;
	Square sq;
	@Before
	public void setUp() {
		one = new Field(1,2);
		two = new Field(1,2);
		three = new Field(1,5);
		four  = new Field(1,5);
		six = new Field(1,5);
		sq = new Square();
		sq.setColor('R');
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
		six.setAktiv(2);
		assertEquals(six.getAktiv(),2);
	}
	@Test
	public void setGetGameRectangleColorTest() {
		one.setGameRectangleColor(sq,0);
		
		Square [] ret = one.getGameRectangleColor();
		assertEquals(ret[0].getColor(),sq.getColor());
	}
	@Test
	public void setGetSolution() {
		
		one.setSolution(sq, 0);
		one.setSolution(sq, 9);
		Square [] ret = one.getSolution();
		assertEquals(sq.getColor(),ret[0].getColor());
	}
	
	@Test
	public void setGetInformationTest() {
		sq.setColor('B');
		one.setInformation(sq, 0);
		Square [] tmp = one.getInformation();
		assertTrue(tmp[0].getColor() == 'B');
	}
	
	@Test
	public void visibleTest(){
		one.setVisibleSolution(true);
		assertTrue(one.getVisibleSolution());
	}
	@Test
	public void setAktivTest() {
		sq.setColor('B');
		one.setAktiv(9);
		assertFalse(one.setGameRectangleColor(sq, 1));
	}
	@Test
	public void getGameRectangleColorTest() {
		one.setAktiv(9);
		assertNull(one.getGameRectangleColor());
	}
	@Test
	public void getInformationTest(){
		one.setAktiv(9);
		assertNull(one.getInformation());
	}
	@Test
	public void getPrevInformation() {
		Square[] tmp = two.getInformation();
		two.setAktiv(1);
		assertArrayEquals(tmp, two.getPrevInformation());
		two.setAktiv(10);
		assertArrayEquals(null, two.getPrevInformation());
	}
	
}
