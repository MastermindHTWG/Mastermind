package de.htwg.mastermind.view.gui;


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import de.htwg.mastermind.controller.IMastermindController;

public class PlayerSetColorPanel extends JPanel {

	private int size;
	private IMastermindController controller;
	
	private SquarePanel [] sq;
	
	
	public PlayerSetColorPanel(IMastermindController controller ,int size, Color [] col, int [] click) {
		this.size = size;
		this.controller = controller;
		sq = new SquarePanel[this.size];
		
		
		setLayout(new GridLayout(1,this.size));
		
		
		int i = 0;
		for(SquarePanel t : sq) { 
			if(t != null) {
				remove(t);
			}
			t = new SquarePanel(this.controller, i,true, col[i], click[i]);
			add(t);
			i++;
		}	
	}	
}
