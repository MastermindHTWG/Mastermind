package de.htwg.mastermind.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.controller.implementierung.MastermindController;
import de.htwg.mastermind.model.implementierung.Field;

public class MastermindControllerTest {

	MastermindController controller1;
	MastermindController controller2;
	Field field1;
	Field field2;
	
	@Before
	public void setUp() throws Exception {
		field1 = new Field(1);
		controller1 = new MastermindController(field1);
		field2 = new Field(1);
		controller2 = new MastermindController(field2);
	}

	@Test
	public void test() {
		controller1.setPlayerColor(new char [] {'B'});
		assertArrayEquals(field1.getGameRectangleColor(), new char [] {'B'});
	}
	
	@Test
	public void getGamefiledTest(){
		assertEquals(controller1.getGamfieldString(), controller2.getGamfieldString());
	}

}
