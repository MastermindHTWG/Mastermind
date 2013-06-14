package de.htwg.mastermind.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.controller.implementierung.MastermindController;
import de.htwg.mastermind.model.implementierung.Field;
import de.htwg.mastermind.model.implementierung.Square;

public class MastermindControllerTest {

	MastermindController controller1;
	MastermindController controller2;
	Field field1;
	Field field2;
	
	@Before
	public void setUp() throws Exception {
		field1 = new Field(1,1);
		controller1 = new MastermindController(field1);
		field2 = new Field(1,1);
		controller2 = new MastermindController(field2);
		
	}

	@Test
	public void test() {
		Square sq = new Square();
		sq.setColor('B');
		controller1.setPlayerColor('B',0,0);
		Square [] ret =field1.getGameRectangleColor();
		
		assertEquals(ret[0].getColor(), sq.getColor() );
	}
	
	@Test
	public void getGamefiledTest(){
		assertEquals(controller1.getGamfieldString(), controller2.getGamfieldString());
	}
	
	@Test
	public void solutionTest() {
		String newLine = System.getProperty("line.separator");
		controller2.createSolution();
		Square[] sol = controller2.getSolution();
		controller2.setPlayerColor(sol[0].getColor(),0,0);
		controller2.setBlackOrWith();
		controller2.setVisibleSolution(true);
		assertEquals("+----+"+ newLine + "|(" + sol[0].getColor() +") |"+newLine+"+----+"+newLine+
				"+----++----+"+newLine+ "|(B) ||("+sol[0].getColor()+") |"+newLine+"+----++----+-1"+
				newLine+ "+------------------------+"+newLine+ "|(R) (B) (O) (W) (G) (Y) |"+
				newLine+"+------------------------+",controller2.getGamfieldString());
	}

	@Test
	public void createField(){
		MastermindController conOne = new MastermindController(new Field());
		MastermindController conTwo = new MastermindController(new Field());
		conOne.createField();
		conTwo.createField();
		assertEquals(conOne.getGamfieldString(), conTwo.getGamfieldString());
	}
	
	@Test
	public void chatToSquareTest(){
		MastermindController conOne = new MastermindController(new Field());
		MastermindController conTwo = new MastermindController(new Field());
		conOne.createField();
		conTwo.createField();
		conOne.charToSquareAndSetForTUI(new char [] {'A'});
		conTwo.charToSquareAndSetForTUI(new char [] {'A'});
		assertEquals(conOne.getGamfieldString(), conTwo.getGamfieldString());
	}
	
	@Test
	public void getStatusTest(){
		MastermindController conOne = new MastermindController(new Field());
		MastermindController conTwo = new MastermindController(new Field());
		assertEquals(conOne.getStatus(), conTwo.getStatus());
	}
	
	
	
	
	
	
	
	
}
