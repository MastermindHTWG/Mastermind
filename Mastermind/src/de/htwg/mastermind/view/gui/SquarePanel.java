package de.htwg.mastermind.view.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JPanel;

import de.htwg.mastermind.controller.IMastermindController;

public class SquarePanel extends JPanel {

	private final boolean listen;
	private int pos;
	private Color color;
	private int click;

	public SquarePanel(final IMastermindController controller, final int pos, boolean listen, Color col, final int click) {
		this.pos = pos;
		this.listen = listen;
		this.color = col;
		this.click = click;
		
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
					if(click == 0){
		
						controller.setPlayerColor('R',pos,1);
			
					} else if(click == 1) {
			
						controller.setPlayerColor('B',pos,2);
						
					}  else if(click == 2) {
			
						controller.setPlayerColor('O',pos,3);
				
					}  else if(click == 3) {
		
						controller.setPlayerColor('W',pos,4);
					
					}  else if(click == 4) {
				
						controller.setPlayerColor('G',pos,5);
			
					}  else if(click == 5) {
				
						controller.setPlayerColor('Y',pos,0);
					}		
				}
				
			});
		}

	}


	@Override
	public void paintComponent(Graphics g) {

		final int inset = 3;
		
//		if(color == null)
//			color = Color.BLACK;
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