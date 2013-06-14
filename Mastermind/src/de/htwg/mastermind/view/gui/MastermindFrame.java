package de.htwg.mastermind.view.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.inject.Inject;

import de.htwg.mastermind.controller.IMastermindController;
import de.htwg.mastermind.util.observer.Observer;

public class MastermindFrame extends JFrame implements Observer{


	private static final int ONE = 1;
	private static final int THREE = 3;
	
	private static final int DEFAULT_Y = 630;
	private static final int DEFAULT_X = 528;
	private static final long serialVersionUID = 1L;
	
	private IMastermindController controller;
	private StatusPanel statusPanel;
	
	private PlayerField playerField;
	private InformationField statusField;
	private JPanel panel;
	private SolutionPanel solutionPanel;
	@Inject
	public MastermindFrame(IMastermindController controller) {
		this.controller = controller;
		this.panel = new JPanel( new GridLayout(ONE,THREE));
		this.solutionPanel = new SolutionPanel(this.controller);
		
		setTitle("HTWG Mastermind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(DEFAULT_X, DEFAULT_Y);
		
		controller.addObserver(this);

		
		constructMastermindPane();
	}


	private void constructMastermindPane() {
		 
		if(statusPanel != null) {
			remove(statusPanel);
		}
		statusPanel = new StatusPanel(this.controller);
		add(statusPanel,BorderLayout.SOUTH);
		statusPanel.setText(controller.getStatus());
		
		
		
		if(statusField != null) {
			panel.remove(statusField);
		}
		statusField = new InformationField(controller);
		panel.add(statusField);
		
		if(playerField != null) {
			panel.remove(playerField);
		}		
		playerField = new PlayerField(controller);
		panel.add(playerField);
		
		
		
		if(solutionPanel != null ) {
			remove(solutionPanel);
		}
		solutionPanel = new SolutionPanel(this.controller);
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
