package de.htwg.mastermind.view.gui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import de.htwg.mastermind.controller.IMastermindController;

public class InformationPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	
	public InformationPanel(IMastermindController controller, Color [] col) {
		IMastermindController con = controller;
		int size = con.getSize();
		SquarePanel [] sq = new SquarePanel[size];
		Color [] colInfo =col;
		
		setLayout(new GridLayout(1,size));
		
		
		int i = 0;
		for(SquarePanel t : sq) {
			if(t != null) {
				remove(t);
			}
			t = new SquarePanel(con, i,false, colInfo[i],0);
			add(t);
			i++;
		}
	}
	
}


