package de.htwg.mastermind.view.gui;

import java.awt.GridLayout;
import javax.swing.JPanel;
import de.htwg.mastermind.controller.IMastermindController;

public class InformationPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private int size;
	private IMastermindController controller;
	private SquarePanel [] sq;
	
	public InformationPanel(IMastermindController controller ,int size) {
		this.size = size;
		this.controller = controller;
		sq = new SquarePanel[this.size];
		
		
		setLayout(new GridLayout(1,this.size));
		
		
		int i = 0;
		for(SquarePanel t : sq) {
			t = new SquarePanel(this.controller, i,false);
			add(t);
			i++;
		}
		
		

		
	}
	
}


