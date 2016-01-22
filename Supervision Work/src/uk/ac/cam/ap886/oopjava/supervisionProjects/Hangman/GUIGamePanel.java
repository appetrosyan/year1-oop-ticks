package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUIGamePanel extends JPanel {
	private String pressedKey;
	private int hangmanStage;

	public GUIGamePanel(){
		super();
		KeyListener listener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
				String key=KeyEvent.getKeyText(e.getKeyCode());
				if(key.length()==1 && Character.isAlphabetic(key.charAt(0))){
					pressedKey = key;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}
		};
		addKeyListener(listener);
		setFocusable(true);
	}

	public String getPressedKey(){
		return pressedKey;
	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		super.setSize(new Dimension (364,364));
		g.setColor(java.awt.Color.WHITE);
		g.fillRect(0, 0, 300, 300);
		try {
			drawHangman(hangmanStage,g);
		} catch (IllegalStageException e) {
			System.err.println("Something went wrong with arithmetic");
			e.printStackTrace();
		}		
	}

	public void drawHangman(int stage, Graphics g) throws IllegalStageException{
		g.setColor(java.awt.Color.BLUE);
		switch(stage){
		case 8:
			g.fillRect(0,150 , 4, 150);
		case 7:
			g.fillRect(0, 0, 4, 150);
		case 6:
			g.fillRect(0, 0, 180, 4);
		case 5:
			g.fillRect(180, 0, 4, 80);
		case 4:
			g.fillRect(180,80,8,40);
		case 3:
			g.setColor(java.awt.Color.GREEN);
			g.fillRect(0, 250, 300, 50);
			g.setColor(java.awt.Color.BLUE);
		case 2:
			g.setColor(java.awt.Color.RED);
			g.fillRect(100, 200, 100, 20);
			g.setColor(java.awt.Color.BLUE);
		case 1:
			g.fillOval(100, 120, 80, 80);
			g.setColor(java.awt.Color.WHITE);
			g.fillOval(200, 140, 40, 40);
			g.setColor(java.awt.Color.BLUE);
		default:
			try {
				Thread.sleep(300, 500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setHangmanStage(int newHangmanStage) {
		hangmanStage = newHangmanStage;

	}



}
