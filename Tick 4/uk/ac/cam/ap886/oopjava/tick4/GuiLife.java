package uk.ac.cam.ap886.oopjava.tick4;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.IOException;
import java.util.List;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

import uk.ac.cam.acr31.life.World;

@SuppressWarnings("serial")//Am not going to do serialisation
public class GuiLife extends JFrame {

	private PatternPanel 	patternPanel;
	private ControlPanel 	controlPanel;
	private GamePanel 		gamePanel;

	//---------------------------------------------
	public GuiLife() {
		super("GuiLife");
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JComponent optionsPanel = createOptionsPanel();
		add(optionsPanel, BorderLayout.WEST);
		Component gamePanel = createGamePanel();
		add(gamePanel, BorderLayout.CENTER);
	}

	private JComponent createOptionsPanel() {
		Box result = Box.createVerticalBox();
		result.add(createSourcePanel());
		result.add(createPatternPanel());
		result.add(createControlPanel());
		return result;
	}

	private void addBorder(JComponent component, String title) {
		Border etch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		Border tb = BorderFactory.createTitledBorder(etch,title);
		component.setBorder(tb);
	}

	private JComponent createGamePanel() {
		JPanel holder = new JPanel();
		addBorder(holder,Strings.PANEL_GAMEVIEW);
		GamePanel result = new GamePanel();
		holder.add(result);
		gamePanel = result;
		return new JScrollPane(holder);
	}

	private JComponent createSourcePanel() {
		SourcePanel result = new SourcePanel();
		addBorder(result,Strings.PANEL_SOURCE);
		return result; 
	}

	private JComponent createPatternPanel() { 
		PatternPanel result = new PatternPanel();
		addBorder(result,Strings.PANEL_PATTERN);
		patternPanel = result;
		return result;
	}

	private JComponent createControlPanel() {
		ControlPanel result = new ControlPanel();
		addBorder(result,Strings.PANEL_CONTROL);
		controlPanel = result;
		return result;

	}

	public static void main(String[] args) {
		GuiLife gui = new GuiLife();
		try {
			CommandLineOptions c = new CommandLineOptions(args);
			List<Pattern> list;
			if(c.getSource().startsWith("http://")){
				try {
					list = PatternLoader.loadFromURL(c.getSource());
				} catch (IOException e) {
					System.out.println("Error: URL " + c.getSource()+" is invlaid");
					return;
				}
			}
			else{
				try{
				list= PatternLoader.loadFromDisk(c.getSource());
				}catch (IOException e){
					System.out.println("Error opening file "  + c.getSource());
					return;
				}
			}
			gui.patternPanel.setPatterns(list);
			World w = gui.controlPanel.initialiseWorld(list.get(c.getIndex()));
			gui.gamePanel.display(w);
		} catch (PatternFormatException pfe){
			System.out.println(pfe.getMessage());
			return;
		} catch (CommandLineException e) {
			System.out.println(e.getMessage());
			return;
		} catch (IndexOutOfBoundsException e){
			System.out.println("Error: Index out of bounds");
			return;
		}
		gui.setVisible(true);
	}

}