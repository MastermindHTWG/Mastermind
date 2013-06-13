package de.htwg.mastermind.view.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import de.htwg.mastermind.controller.IMastermindController;
import de.htwg.mastermind.controller.implementierung.MastermindController;

public class SquarePanel extends JPanel {

	private final int pos;
	private IMastermindController controller;
	private final boolean listen;
	
	private Color color = new Color(100, 100, 255);

	public SquarePanel(final IMastermindController controller, final int pos, boolean listen) {
		this.pos = pos;
		this.controller = controller;
		this.listen = listen;

		
		if(this.listen) {
			addMouseListener(new MouseListener() {

		
				@Override
				public void mouseReleased(MouseEvent e) {
				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
				}

				@Override
				public void mouseEntered(MouseEvent e) {
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					setColor(Color.RED);
					controller.setPlayerColor('R',pos);
				}
			});
		}

		
	}


	@Override
	public void paintComponent(Graphics g) {

		final int inset = 3;
		
		g.setColor(color);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.draw3DRect(inset, inset, getWidth() - inset * 2, getHeight() - inset
				* 2, true);
		g.draw3DRect(inset + 1, inset + 1, getWidth() - inset * 2 - 2,
				getHeight() - inset * 2 - 2, true);

	}
	
	public void setColor(Color color) {
		this.color = color;
		repaint();
	}


}