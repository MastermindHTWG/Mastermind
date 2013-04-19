package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.ColorSelection;

public class ColorSelectionTest {

	ColorSelection one;
	
	@Before
	public void setUp() throws Exception {
		one = new ColorSelection();
	}

	@Test
	public void test() {
		one.setColor();
		assertArrayEquals( new String[] {"red","blue","black", "white","green", "yellow", "orange", "purple"},one.getSquareColor());

	}

}
