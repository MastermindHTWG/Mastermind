package de.htwg.mastermind.view.gui;


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import de.htwg.mastermind.controller.IMastermindController;

public class PlayerField extends JPanel{


	private static final long serialVersionUID = 1L;

	
	public PlayerField(IMastermindController controller){ 
		
		IMastermindController con = controller;
		int height = con.getHeight();
		PlayerSetColorPanel [] player;
		Color[][] color = con.getPlayerColor();


		setLayout(new GridLayout(height,1));
		
		
		player = new PlayerSetColorPanel[height];
		for(int i=height-1; i>=0;i--) {
			if(player[i] != null) {
				remove(player[i]);
			}
			
			player[i] = new PlayerSetColorPanel(con,color[i]);
			add(player[i]);
		}
	}
}
