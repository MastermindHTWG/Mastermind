package de.htwg.mastermind.controller;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.controller.implementierung.MastermindController;
import de.htwg.mastermind.model.implementierung.Field;
import de.htwg.mastermind.model.implementierung.Square;

public class MastermindControllerTest {

	MastermindController controller1;
	MastermindController controller2;
	MastermindController controller3;
	MastermindController controller4;
	Field field1;
	Field field2;
	Field field3;
	Field field4;
	@Before
	public void setUp() throws Exception {
		field1 = new Field(1,1);
		controller1 = new MastermindController(field1);
		field2 = new Field(1,1);
		controller2 = new MastermindController(field2);
		field3 = new Field(1,2);
		controller3 = new MastermindController(field3);
		field4 = new Field(1,2);
		controller4 = new MastermindController(field4);
	}

	@Test
	public void getColortest() {
		Square sq = new Square();
		sq.setColor('B');
		controller1.setPlayerColor('B',0,0);
		Square [] ret =field1.getGameRectangleColor();
		field3.setAktiv(4);
		
		controller3.setPlayerColor('B', 5, 0);
		assertTrue("Game is over!".equals(controller3.getStatus()));
		
		
		assertEquals(ret[0].getColor(), sq.getColor() );
	}
	
	@Test
	public void getGamefiledTest(){
		assertEquals(controller1.getGamfieldString(), controller2.getGamfieldString());
	}
	
	@Test
	public void solutionTest() {
		String newLine = System.getProperty("line.separator");
		controller2.createSolution(false);
		Square[] sol = controller2.getSolution();
		controller2.setPlayerColor(sol[0].getColor(),0,0);
		controller2.setBlackOrWhite();
		controller2.setVisibleSolution(true);
		controller2.getSolutionColor();
		assertEquals("+----+"+ newLine + "|(" + sol[0].getColor() +") |"+newLine+"+----+"+newLine+
				"+----++----+"+newLine+ "|(B) ||("+sol[0].getColor()+") |"+newLine+"+----++----+-1"+
				newLine+ "+------------------------+"+newLine+ "|(R) (B) (O) (W) (G) (P) |"+
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
		conOne.setSolution(false);
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
	
	@Test
	public void clickTest(){
		MastermindController conOne = new MastermindController(new Field());
		int [] ar = conOne.getClick();
		assertEquals(ar[0], 0);
	}
	@Test
	public void nor(){
		MastermindController conOne = new MastermindController(new Field());
		Color [][] col = conOne.getInfoColor();
		assertEquals(col[0][0], new Color(188,210,238));
	}
	@Test
	public void Red(){
		MastermindController conOne = new MastermindController(new Field());
		conOne.setPlayerColor('R', 0, 0);
		Color [][] col = conOne.getPlayerColor();
		assertEquals(col[0][0], Color.RED);
	}
	@Test
	public void Orange(){
		MastermindController conOne = new MastermindController(new Field());
		conOne.setPlayerColor('O', 0, 0);
		Color [][] col = conOne.getPlayerColor();
		assertEquals(col[0][0], Color.ORANGE);
	}
	@Test
	public void W(){
		MastermindController conOne = new MastermindController(new Field());
		conOne.setPlayerColor('W', 0, 0);
		Color [][] col = conOne.getPlayerColor();
		assertEquals(col[0][0], Color.WHITE);
	}
	@Test
	public void G(){
		MastermindController conOne = new MastermindController(new Field());
		conOne.setPlayerColor('G', 0, 0);
		Color [][] col = conOne.getPlayerColor();
		assertEquals(col[0][0], Color.GREEN);
	}
	@Test
	public void P(){
		MastermindController conOne = new MastermindController(new Field());
		conOne.setPlayerColor('P', 0, 0);
		Color [][] col = conOne.getPlayerColor();
		assertEquals(col[0][0], Color.PINK);
	}
	@Test
	public void Gray(){
		MastermindController conOne = new MastermindController(new Field());
		conOne.setPlayerColor(' ', 0, 0);
		Color [][] col = conOne.getPlayerColor();
		assertEquals(col[0][0], Color.GRAY);
	}
	@Test
	public void B(){
		MastermindController conOne = new MastermindController(new Field());
		conOne.setPlayerColor('B', 0, 0);
		Color [][] col = conOne.getPlayerColor();
		assertEquals(col[0][0], Color.BLUE);
	}
	
	
	@Test
	public void getSolutionTest(){
		MastermindController conOne = new MastermindController(new Field());
		conOne.setSolution(false);
		Square [] sq = conOne.getSolution();
		Color[] c = conOne.getSolutionColor();
	}
	@Test
	public void getHeightTest() {
		MastermindController conOne = new MastermindController(new Field());
		conOne.getSolutionColor();
		assertEquals(conOne.getHeight(), 1);
	}
	@Test
	public void getSizeTest() {
		MastermindController conOne = new MastermindController(new Field());
		assertEquals(conOne.getSize(), 1);
	}
	@Test
	public void setBlackTestOne(){
		MastermindController conOne = new MastermindController(new Field());
		conOne.setSolution(true);
		conOne.setPlayerColor('B', 0, 0);
		conOne.setBlackOrWhite();
		conOne.setBlackOrWhite();
		assertNotNull(conOne.getInfoColor());
	}
	@Test
	public void setBlackTestTwo(){
		MastermindController conOne = new MastermindController(new Field(2,2));
		conOne.setSolution(true);
		conOne.setPlayerColor('W', 0, 0);
		conOne.setPlayerColor('B', 1, 0);
		conOne.setBlackOrWhite();
		conOne.setBlackOrWhite();
		conOne.getInfoColor();
		assertNotNull(conOne.getInfoColor());
	}
	@Test
	public void setBlackTestThree(){
		MastermindController conOne = new MastermindController(new Field(2,2));
		conOne.setSolution(true);
		conOne.setPlayerColor('B', 0, 0);
		conOne.setPlayerColor('W', 1, 0);
		conOne.setBlackOrWhite();
		conOne.getInfoColor();
		conOne.setBlackOrWhite();
		conOne.getInfoColor();
		assertNotNull(conOne.getInfoColor());
		conOne.setVisibleSolution(true);
		conOne.getSolutionColor();
	}
	@Test
	public void getSolTestOne(){
		MastermindController conOne = new MastermindController(new Field(4,2));
		conOne.setSolution(false);
		conOne.setVisibleSolution(true);
		conOne.getSolutionColor();
	}
	@Test
	public void getSolTestTwo(){
		MastermindController conOne = new MastermindController(new Field(4,2));
		conOne.setSolution(false);
		conOne.setVisibleSolution(true);
		conOne.getSolutionColor();
	}
	@Test
	public void getSolTestThree(){
		MastermindController conOne = new MastermindController(new Field(4,2));
		conOne.setSolution(false);
		conOne.setVisibleSolution(true);
		conOne.getSolutionColor();
	}

	
	
}
