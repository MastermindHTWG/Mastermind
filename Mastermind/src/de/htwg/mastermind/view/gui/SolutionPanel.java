package de.htwg.mastermind.view.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import de.htwg.mastermind.controller.IMastermindController;

public class SolutionPanel extends JPanel{
	private SquarePanel [] info;
	private int size;
	private IMastermindController controller;
	private  Color[] col;
	
	SolutionPanel(IMastermindController controller, int size){
		this.size = size;
		this.controller = controller;
		this.info = new SquarePanel[this.size];
		this.col = controller.getSolutionColor();
		
		 this.setLayout(new GridLayout(1,this.size));
		 
			int i = 0;
			for(SquarePanel t : info) { 
				if(t != null) {
					remove(t);
				}
				t = new SquarePanel(this.controller, i,false, col[i],0);
				add(t);
				i++;
			}
		 
	}

}
