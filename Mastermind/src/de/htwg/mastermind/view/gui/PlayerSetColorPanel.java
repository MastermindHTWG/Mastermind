package de.htwg.mastermind.view.gui;


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import de.htwg.mastermind.controller.IMastermindController;

public class PlayerSetColorPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;

	public PlayerSetColorPanel(IMastermindController controller , Color [] col) {
		IMastermindController con = controller;
		int size = con.getSize();
		int [] click = con.getClick();
		SquarePanel [] sq = new SquarePanel[size];
		
		
		setLayout(new GridLayout(1,size));
		
		
		int i = 0;
		for(SquarePanel t : sq) { 
			if(t != null) {
				remove(t);
			}
			t = new SquarePanel(con, i,true, col[i], click[i]);
			add(t);
			i++;
		}	
	}	
}
