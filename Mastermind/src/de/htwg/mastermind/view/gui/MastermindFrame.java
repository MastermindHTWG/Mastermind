package de.htwg.mastermind.view.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.htwg.mastermind.controller.IMastermindController;
import de.htwg.mastermind.util.observer.Observer;

public class MastermindFrame extends JFrame implements Observer{

	private static final int DEFAULT_Y = 630;
	private static final int DEFAULT_X = 528;
	private static final long serialVersionUID = 1L;
	
	private IMastermindController controller;
	private StatusPanel statusPanel;
	private StatusPanel statusPanelOne;
	
	private PlayerFieldPanel playerField;
	private InformationFiledPanel statusField;
	
	public MastermindFrame(IMastermindController controller) {
		this.controller = controller;
		controller.addObserver(this);
		
		setTitle("HTWG Mastermind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(DEFAULT_X, DEFAULT_Y);
		
		

		
		constructMastermindPane();
	}


	private final void constructMastermindPane() {
		
		statusPanel = new StatusPanel(this.controller);
		add(statusPanel,BorderLayout.SOUTH);
		statusPanel.setText("Hallo");
		
		playerField = new PlayerFieldPanel(controller, 4,4);
		statusField = new InformationFiledPanel(controller, 4,4);
		
		statusPanelOne = new StatusPanel(controller);
		add(statusPanelOne,BorderLayout.NORTH);
		statusPanelOne.setText("Winer");
		
		
		
		
		JPanel panel = new JPanel( new GridLayout(1,2));
		
		panel.add(statusField);
		panel.add(playerField);
		
		add(panel, BorderLayout.CENTER);
		
		setVisible(true);
		repaint();
		
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
