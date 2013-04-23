package de.htwg.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.Information;

public class InformationTest {

	Information one;
	
	@Before
	public void setUp() {
		one = new Information(1);	
	}

	@Test
	public void setGetInfoColortest() {
		one.setColor(0,"blue");
		assertArrayEquals(new String[] {"blue"},one.getSquareColor());
	}

}
