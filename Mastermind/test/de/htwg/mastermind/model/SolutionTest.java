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
		two.setColor('B',0);
		two.setColor('G',1);
		two.setColor('R',2);
	}
	
	@Test
	public void testGetSquareColor(){
		assertArrayEquals(new char[] {'B','G','R'},two.getSquareColor());
		
	}
}




