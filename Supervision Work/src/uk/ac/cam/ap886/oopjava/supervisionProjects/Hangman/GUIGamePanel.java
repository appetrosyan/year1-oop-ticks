package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUIGamePanel extends JPanel {
	private String pressedKey;

	public GUIGamePanel(){
		super();
		KeyListener listener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
				String key=KeyEvent.getKeyText(e.getKeyCode());
				switch (key){
				case "Shift":
				case "Windows":
				case "Ctrl":
				case "Alt":
				case "Caps Lock":
				case "Space":
				case "Comma":
				case "0":
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "9":
				case "8":
				case "Minus":
				case "Equals":
				case "Backspace":
				case "Open Bracket":
				case "Close Bracket":
				case "Semicolon":
				case "Quote":
				case "Slash":
				case "Back Slash":
				case "Alt Graph":
				case "Context Menu":
				
					return;
				default:
					pressedKey= key;
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		};
		addKeyListener(listener);
		setFocusable(true);
	}
	
	public String getPressedKey(){
		return pressedKey;
	}
	
	

}
