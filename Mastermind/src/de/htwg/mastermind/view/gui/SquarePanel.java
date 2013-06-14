package de.htwg.mastermind.view.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import de.htwg.mastermind.controller.IMastermindController;



public class SquarePanel extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	private static final int NULL = 0;
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	
	private Color color;

	public SquarePanel(final IMastermindController controller, final int pos, boolean listen, Color col, final int click) {
		boolean listenOne = listen;
		this.color = col;
		
		if(listenOne) {
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
		
						controller.setPlayerColor('R',pos,ONE);
			
					} else if(click == ONE) {
			
						controller.setPlayerColor('B',pos,TWO);
						
					}  else if(click == TWO) {
			
						controller.setPlayerColor('O',pos,THREE);
				
					}  else if(click == THREE) {
		
						controller.setPlayerColor('W',pos,FOUR);
					
					}  else if(click == FOUR) {
				
						controller.setPlayerColor('G',pos,FIVE);
			
					}  else if(click == FIVE) {
				
						controller.setPlayerColor('Y',pos,NULL);
					}		
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