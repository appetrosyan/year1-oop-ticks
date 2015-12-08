package uk.ac.cam.ap886.oopjava.tick4;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

import uk.ac.cam.acr31.life.World;


@SuppressWarnings("serial")
public class ControlPanel extends JPanel {
	
	@SuppressWarnings("unused")
	private JSlider zoomSlider;
	@SuppressWarnings("unused")
	private JSlider stepSlider;
	@SuppressWarnings("unused")
	private JSlider speedSlider;
	
	//THe three sliders above are not used anywhere because we don't have
	//Event handlers to be able to use them for now suppressing warning is
	//fine and will free up space to some actual ones
	private JRadioButton longButton;
	private JRadioButton arrayButton;
	private JRadioButton agingButton;
	
	//-----------------------------------------
	private JSlider createNewSlider(int min, int max, int start, String s) {
		Box panel = Box.createHorizontalBox();
		add(panel);
		panel.add(new JLabel(s));
		JSlider slider = new JSlider(min,max,start);
		panel.add(slider);
		return slider;
	}
	
	private JRadioButton createNewButton(String s, ButtonGroup g, Box b) {
		JRadioButton result = new JRadioButton (s);
		g.add(result);
		b.add(result);
		return result;
		//: create a new instance of JRadioButton with text "s"
		//: add the new instance to the ButtonGroup referenced by "g"
		//: add the new instance to Box "b"
		//: return a reference to the new instance
	}
	
	public ControlPanel() {
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		zoomSlider = createNewSlider(1,20,1,Strings.CONTROL_ZOOM);
		add(Box.createVerticalStrut(10)); //add 10px of extra space
		stepSlider = createNewSlider(0,10,0,Strings.CONTROL_STEP); 
		add(Box.createVerticalStrut(10)); //add 10px of extra space
		speedSlider = createNewSlider(0,100,0,Strings.CONTROL_SPEED);
		add(Box.createVerticalStrut(10)); //add 10px of extra space
		Box worldPanel = Box.createHorizontalBox();
		add(worldPanel);
		worldPanel.add(new JLabel(Strings.STORAGE_WORLD_TYPE));
		ButtonGroup group = new ButtonGroup();
		longButton = createNewButton(Strings.STORAGE_LONG,group,worldPanel);
		arrayButton = createNewButton(Strings.STORAGE_ARRAY,group,worldPanel);
		agingButton = createNewButton(Strings.STORAGE_AGING,group,worldPanel);
		arrayButton.setSelected(true);
		add(Box.createVerticalStrut(10)); //add 10px of extra space
	} 
	
	public World initialiseWorld(Pattern p) throws PatternFormatException {
		World result = null;
		if (longButton.isSelected()) {
			result = new PackedWorld();
		} else if (arrayButton.isSelected()) {
			result = new ArrayWorld(p.getWidth(),p.getHeight());
		} else if (agingButton.isSelected()) {
			result = new AgingWorld(p.getWidth(),p.getHeight());
		}
		if (result != null)  p.initialise(result);
		return result;
	}
	
}
