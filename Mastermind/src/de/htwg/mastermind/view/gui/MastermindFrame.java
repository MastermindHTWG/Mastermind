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
//	private StatusPanel statusPanelOne;
	
	private PlayerField playerField;
	private InformationField statusField;
	private JPanel panel;
	private SolutionPanel solutionPanel;
	
	public MastermindFrame(IMastermindController controller) {
		this.controller = controller;
		this.panel = new JPanel( new GridLayout(1,3));
		this.solutionPanel = new SolutionPanel(this.controller, 4);
		
		setTitle("HTWG Mastermind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(DEFAULT_X, DEFAULT_Y);
		
		controller.addObserver(this);

		
		constructMastermindPane();
	}


	private final void constructMastermindPane() {
		 
		if(statusPanel != null) {
			remove(statusPanel);
		}
		statusPanel = new StatusPanel(this.controller);
		add(statusPanel,BorderLayout.SOUTH);
		statusPanel.setText("Hallo");
		
		
		
		if(statusField != null) {
			panel.remove(statusField);
		}
		statusField = new InformationField(controller, 4,6,controller.getInfoColor());
		panel.add(statusField);
		
		if(playerField != null) {
			panel.remove(playerField);
		}		
		playerField = new PlayerField(controller, 4,6, controller.getPlayerColor(),controller.getClick());
		panel.add(playerField);
		
		
		
		if(solutionPanel != null ) {
			remove(solutionPanel);
		}
		solutionPanel = new SolutionPanel(this.controller, 4);
		add(solutionPanel,BorderLayout.NORTH);

		
		
		
		add(panel, BorderLayout.CENTER);
		
		setVisible(true);
		repaint();
		
	}


	@Override
	public void update() {
		constructMastermindPane();
		repaint();
		
	}
	
	
}
