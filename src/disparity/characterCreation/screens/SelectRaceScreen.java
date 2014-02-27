package disparity.characterCreation.screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import disparity.characterCreation.MainScreen;
import disparity.characterCreation.GUIresources.ColoredTabs;
import disparity.characterCreation.GUIresources.InfoPanel;
import disparity.characterCreation.GUIresources.Resources;
import disparity.rpg.races.Race;
import disparity.rpg.races.player.elfin.*;
import disparity.rpg.races.player.*;

public class SelectRaceScreen extends JPanel{
	JFrame main;
	
	public SelectRaceScreen(JFrame jframe) {
		this.main = jframe;
		init();
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	private void init() {
		String[] descs = Race.getCharacterRacesDesc().toArray(new String[Race.getCharacterRacesDesc().size()]);
		String[] names = Race.getAllRaces().toArray(new String[Race.getAllRaces().size()]);
		for(int i = 0 ;i < descs.length;i++){
			descs[i] = Resources.addEndl(descs[i]);
		}
		Color[] colors = Race.getAllRaceColors().toArray(new Color[Race.getAllRaceColors().size()]);
		JComponent[] components = new JComponent[descs.length];
		for(int i = 0;i<descs.length;i++){
			components[i] = new InfoPanel(names[i], descs[i], "", main, "selectWeaponScreen", new ArrayList<String>());
		}
		UIManager.put("TabbedPane.selected",getBackground());
		ColoredTabs tab = new ColoredTabs(names, colors, components);
		this.setLayout( new BorderLayout() );
		this.add(tab, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
