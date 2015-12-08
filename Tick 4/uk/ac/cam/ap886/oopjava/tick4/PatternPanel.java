package uk.ac.cam.ap886.oopjava.tick4;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;




@SuppressWarnings("serial")
public class PatternPanel extends JPanel {
	
	@SuppressWarnings("rawtypes")
	private JList guiList;//SHould have been parametrised
	
	//---------------------------------------------
	@SuppressWarnings("rawtypes")
	public PatternPanel() {
		super();
		setLayout(new BorderLayout());
		guiList = new JList();	//Same here
		add(new JScrollPane(guiList));
	}
	
	@SuppressWarnings("unchecked")
	public void setPatterns(List<Pattern> list) {
		ArrayList<String> names = new ArrayList<String>();
		for(Pattern p : list){
			names.add(p.getName()+" ("+p.getAuthor()+")");
		}
		guiList.setListData(names.toArray());
	} 
	
}