package disparity.characterCreation.GUIresources;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;

public class ColoredTabs extends JTabbedPane {
	
	private static final long serialVersionUID = 1L;
	public ColoredTabs(int tabPlacement, String[] names, Color[] colors, JComponent[] components){
		super(tabPlacement);
		if(names.length != components.length || names.length != colors.length || components.length != colors.length){
			throw new IllegalArgumentException("The arguments for COMPONENTS, COLORS, and NAMES do not match up...");
		}
		setFont(Resources.getFont());
		setBackground(Color.YELLOW);
		for(int i = 0; i < names.length; i++){
			addTab(names[i], components[i]);
			setBackgroundAt(i, colors[i]);
			
		}
	}
	
	
}
