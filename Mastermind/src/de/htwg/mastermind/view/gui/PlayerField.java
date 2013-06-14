package de.htwg.mastermind.view.gui;


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import de.htwg.mastermind.controller.IMastermindController;

public class PlayerField extends JPanel{


	private static final long serialVersionUID = 1L;
	private IMastermindController controller;
	private int size;
	private int height;
	private PlayerSetColorPanel [] player;
	
	public PlayerField(IMastermindController controller,int size,int height,Color [][] col, int [] click){
		this.size = size;
		this.height = height;
		this.controller = controller;
		setLayout(new GridLayout(height,1));
		
		
		player = new PlayerSetColorPanel[this.height];
		for(int i=height-1; i>=0;i--) {
			if(player[i] != null)
				remove(player[i]);
			player[i] = new PlayerSetColorPanel(this.controller, this.size,col[i],click);
			add(player[i]);
		}
	}
}
