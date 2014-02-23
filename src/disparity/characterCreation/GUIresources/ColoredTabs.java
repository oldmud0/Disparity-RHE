package disparity.characterCreation.GUIresources;

import java.awt.Color;
import java.awt.Window;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import disparity.rpg.races.Race;

public class ColoredTabs extends JTabbedPane {
	
	public static void main(String[] args){
		String[] descs = Race.getCharacterRacesDesc().toArray(new String[Race.getCharacterRacesDesc().size()]);
		String[] names = Race.getAllRaces().toArray(new String[Race.getAllRaces().size()]);
		for(int i = 0 ;i < names.length;i++){
			names[i] = Resources.addEndl(names[i]);
		}
		Color[] colors = Race.getAllRaceColors().toArray(new Color[Race.getAllRaceColors().size()]);
		JComponent[] components = new JComponent[descs.length];
		for(int i = 0;i<descs.length;i++){
			components[i] = new InfoPanel(names[i], descs[i], "");
		}
		ColoredTabs tab = new ColoredTabs(names, colors, components);
		JFrame f= new JFrame();
		JPanel j = new JPanel();
		j.add(tab);
		f.add(j);
		f.pack();
		f.setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
	public ColoredTabs(String[] names, Color[] colors, JComponent[] components){
		super(JTabbedPane.LEFT);
		if(names.length != components.length || names.length != colors.length || components.length != colors.length){
			throw new IllegalArgumentException("The arguments for COMPONENTS, COLORS, and NAMES do not match up...");
		}
		setFont(Resources.getFont());
		for(int i = 0; i < names.length; i++){
			addTab(names[i], components[i]);
			setBackgroundAt(i, colors[i]);
		}
	}
	
	
}
