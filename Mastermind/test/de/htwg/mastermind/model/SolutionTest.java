package de.htwg.mastermind.model;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.Solution;

public class SolutionTest {
	
	Solution two;
	
	@Before
	public void setUp() {
		two = new Solution(3);
		two.setColor(0, "black");
		two.setColor(1, "green");
		two.setColor(2, "red");
	}
	
	@Test
	public void testGetSquareColor(){
		assertArrayEquals(new String[] {"black","green","red"},two.getSquareColor());
		
	}
}




