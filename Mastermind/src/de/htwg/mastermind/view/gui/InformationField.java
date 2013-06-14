package de.htwg.mastermind.view.gui;


import java.awt.Color;
import java.awt.GridLayout;


import javax.swing.JPanel;

import de.htwg.mastermind.controller.IMastermindController;


public class InformationField extends JPanel{

	private static final long serialVersionUID = 1L;
	private IMastermindController controller;
	private int size;
	private int height;
	private InformationPanel [] info;
	
	
	public InformationField(IMastermindController controller,int size, int height, Color [][]colInfo){
		this.height = height;
		this.size = size;
		this.controller = controller;
		setLayout(new GridLayout(height,1));
		info = new InformationPanel[this.height];
		for(int i=height-1; i>=0;i--) {
			if(info[i] != null)
				remove(info[i]);
			info[i] = new InformationPanel(this.controller, this.size,colInfo[i]);
			add(info[i]);
		}
		
		
	}
}







