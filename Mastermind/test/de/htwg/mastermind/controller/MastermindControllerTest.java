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
		conOne.setSolution();
		Square [] sq = conOne.getSolution();
		Color[] c = conOne.getSolutionColor();
	}
	@Test
	public void getHeightTest() {
		MastermindController conOne = new MastermindController(new Field());
		assertEquals(conOne.getHeight(), 1);
	}
	@Test
	public void getSizeTest() {
		MastermindController conOne = new MastermindController(new Field());
		assertEquals(conOne.getSize(), 1);
	}
	
	
}
