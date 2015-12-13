package uk.ac.cam.ap886.oopjava.tick5;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public abstract class SourcePanel extends JPanel {

	private JRadioButton current;

	//----------------------------------------
	public SourcePanel() {
		super();
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		JRadioButton none = new JRadioButton(Strings.BUTTON_SOURCE_NONE, true);
		JRadioButton file = new JRadioButton(Strings.BUTTON_SOURCE_FILE, true);
		JRadioButton library = new JRadioButton(Strings.BUTTON_SOURCE_LIBRARY, true);
		//add RadioButtons to this JPanel
		add(none);
		add(file);
		add(library);
		//create a ButtonGroup containing all four buttons
		//Only one Button in a ButtonGroup can be selected at once
		ButtonGroup group = new ButtonGroup();
		group.add(none);
		group.add(file);
		group.add(library);
		current = none;
		
		none.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if (setSourceNone()){
					current = none;
				}else{
					current.setSelected(true);
				}
			}
		}
				);

		library.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(setSourceLibrary()){
					current = library;
				}else{
					current.setSelected(true);
				}
			}

		});

		file.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (setSourceFile()) {
					//successful: file found and patterns loaded
					current = file; 
				} else {
					//unsuccessful: re-enable previous source choice
					current.setSelected(true); 
				}
			}
		}			);

	}
	protected abstract boolean setSourceNone();
	protected abstract boolean setSourceLibrary();
	protected abstract boolean setSourceFile();
}