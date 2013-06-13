package de.htwg.mastermind.view.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import de.htwg.mastermind.controller.IMastermindController;

public class StatusPanel extends JPanel{

	private static final String OK = "OK";
	private static final String SOLVE = "solve";
	private static final long serialVersionUID = 1L;
	private final JLabel statusLabel = new JLabel("");
	
	public StatusPanel(final IMastermindController controller){
		setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		add(statusLabel);
		
		
		JButton buttonSolve =new JButton(SOLVE);
		buttonSolve.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.setVisibleSolution(true);
				
			}
		});
		
		add(buttonSolve);
		
		JButton buttonOk =new JButton(OK);
		buttonOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
	
				controller.setBlackOrWith();
				
			}
		});
		
		add(buttonOk);
		
	}
	
	public final void setText(final String text) {
		statusLabel.setText(" " + text);
	}
	
	public void clear() {
		statusLabel.setText(" ");
	}
	
}
