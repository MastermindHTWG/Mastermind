package de.htwg.mastermind.view.gui;


import java.awt.Graphics;
import java.awt.GridLayout;


import javax.swing.JPanel;

import de.htwg.mastermind.controller.IMastermindController;


public class InformationFiledPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private IMastermindController controller;
	private int size;
	private int height;
	InformationPanel [] info;
	
	
	public InformationFiledPanel(IMastermindController controller,int size, int height){
		this.height = height;
		this.size = size;
		this.controller = controller;
		setLayout(new GridLayout(size,1));
		
		info = new InformationPanel[this.height];
		for(InformationPanel psc: info) {
			psc = new InformationPanel(this.controller, this.size);
			add(psc);
		}
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
}


