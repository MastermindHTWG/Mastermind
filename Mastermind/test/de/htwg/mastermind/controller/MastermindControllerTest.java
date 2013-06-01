package de.htwg.mastermind.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.mastermind.controller.implementierung.MastermindController;
import de.htwg.mastermind.model.IField;
import de.htwg.mastermind.model.implementierung.Field;

public class MastermindControllerTest {

	private IField field;
	MastermindController controller;
	
	@Before
	public void setUp() {
		field = new Field();
		controller = new MastermindController(field);
	}

	
}
