package uk.ac.cam.ap886.oopjava.tick5;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;




@SuppressWarnings("serial")
public abstract class PatternPanel extends JPanel {

	@SuppressWarnings("rawtypes")
	private JList guiList;
	private Pattern currentPattern;
	private List <Pattern> patternList;

	//---------------------------------------------
	@SuppressWarnings("rawtypes")
	public PatternPanel() {
		super();
		currentPattern=null;
		setLayout(new BorderLayout());
		guiList = new JList();	//Same here
		add(new JScrollPane(guiList));

		guiList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if ((patternList != null)) {
					int sel = guiList.getSelectedIndex();
					if (sel != -1) {
						currentPattern = patternList.get(sel);
						onPatternChange();
					}
				}
				else{
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	public void setPatterns(List<Pattern> list) {
		if (list == null) {
			currentPattern = null; //if list is null, then no valid pattern
			guiList.setListData(new String[]{}); //no list item to select
			return;
		}
		patternList = list;
		ArrayList<String> names = new ArrayList<String>();
		for(Pattern p : list){
			names.add(p.getName()+" ("+p.getAuthor()+")");
		}		
		guiList.setListData(names.toArray());
		currentPattern = list.get(0); //select first element in list
		guiList.setSelectedIndex(0);  //select first element in guiList
	} 

	public Pattern getCurrentPattern(){
		return currentPattern;
	}
	
	protected abstract void onPatternChange();

}