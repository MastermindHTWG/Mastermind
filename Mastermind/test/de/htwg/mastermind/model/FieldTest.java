package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.Field;

public class FieldTest {

	Field one;
	Field two;
	Field three;
	Field four;
	
	@Before
	public void setUp() {
		one = new Field();
		two = new Field();
		three = new Field(1);
		four  = new Field(1);
	}

	@Test
	public void toStringTest() {
		assertEquals(one.toString(), two.toString());
	}
	@Test
	public void fieldTest(){
		assertEquals(three.toString(), four.toString());
	}
	
}
