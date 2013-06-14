package de.htwg.mastermind.view.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import de.htwg.mastermind.controller.IMastermindController;

public class SolutionPanel extends JPanel{
	
	
	private static final long serialVersionUID = 1L;

	SolutionPanel(IMastermindController controller){
		
		IMastermindController con = controller;
		int size = con.getSize();
		Color[] col = con.getSolutionColor();
		SquarePanel [] info = new SquarePanel[size];

		
		 this.setLayout(new GridLayout(1,size));
		 
			int i = 0;
			for(SquarePanel t : info) { 
				if(t != null) {
					remove(t);
				}
				t = new SquarePanel(con, i,false, col[i],0);
				add(t);
				i++;
			}
		 
	}

}
