package disparity.characterCreation.GUIresources;

import java.awt.Color;
import java.awt.Window;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import disparity.rpg.races.Race;

public class ColoredTabs extends JTabbedPane {
	
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
