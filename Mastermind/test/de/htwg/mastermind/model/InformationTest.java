package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.implementierung.Information;

public class InformationTest {

	Information one;
	
	@Before
	public void setUp() {
		one = new Information(1);	
	}

	@Test
	public void setGetInfoColortest() {
		one.setColor('B',0);
		assertArrayEquals(new char[] {'B'},one.getSquareColor());
	}

}
