package de.htwg.mastermind.view.gui;


import java.awt.GridLayout;


import javax.swing.JPanel;

import de.htwg.mastermind.controller.IMastermindController;

public class PlayerFieldPanel extends JPanel{


	private static final long serialVersionUID = 1L;
	private IMastermindController controller;
	private int size;
	private int height;
	private PlayerSetColorPanel [] player;
	
	public PlayerFieldPanel(IMastermindController controller,int size,int height){
		this.size = size;
		this.height = height;
		this.controller = controller;
		setLayout(new GridLayout(size,1));
		
		player = new PlayerSetColorPanel[this.height];
		for(PlayerSetColorPanel psc: player) {
			psc = new PlayerSetColorPanel(this.controller, this.size);
			add(psc);
		}
		
		
	}
}
