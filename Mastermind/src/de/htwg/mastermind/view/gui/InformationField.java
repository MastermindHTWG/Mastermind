package de.htwg.mastermind.view.gui;


import java.awt.Color;
import java.awt.GridLayout;


import javax.swing.JPanel;

import de.htwg.mastermind.controller.IMastermindController;


public class InformationField extends JPanel{

	private static final long serialVersionUID = 1L;	
	
	public InformationField(IMastermindController controller){
		IMastermindController con = controller;
		
		int height = con.getHeight();
		Color [][] colInfo = con.getInfoColor();
		
		setLayout(new GridLayout(height,1));
		InformationPanel [] info = new InformationPanel[height];
		for(int i=height-1; i>=0;i--) {
			if(info[i] != null){
				remove(info[i]);
			}
				
			info[i] = new InformationPanel(con,colInfo[i]);
			add(info[i]);
		}
		
		
	}
}







