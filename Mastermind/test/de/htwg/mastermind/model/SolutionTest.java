package de.htwg.mastermind.model;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.model.implementierung.Solution;
import de.htwg.mastermind.model.implementierung.Square;

public class SolutionTest {
	
	Solution two;
	Square sq;
	
	@Before
	public void setUp() {
		sq = new Square();
		sq.setColor('B');
		two = new Solution(1);
		two.setColor(sq,0);
	
	}
	
//	@Test
//	public void testGetSquareColor(){
//		assertArrayEquals(new char[] {'B','G','R'},two.getSquareColor());
//	}
	
	@Test
	public void visibleTest() {
		two.setVisible(true);
		String newLine = System.getProperty("line.separator");
		assertEquals("+----+"+newLine+"|(B) |"+newLine+"+----+",two.toString());
		assertTrue(two.getVisible());
	}
	
	
	
}





