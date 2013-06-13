package de.htwg.mastermind.view.gui;


import java.awt.GridLayout;


import javax.swing.JPanel;

import de.htwg.mastermind.controller.IMastermindController;


public class InformationFieldPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private IMastermindController controller;
	private int size;
	private int height;
	private InformationPanel [] info;
	
	
	public InformationFieldPanel(IMastermindController controller,int size, int height){
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
}


