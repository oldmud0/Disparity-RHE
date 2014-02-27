package disparity.characterCreation.screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import disparity.characterCreation.GUIresources.ColoredTabs;
import disparity.characterCreation.GUIresources.InfoPanel;
import disparity.characterCreation.GUIresources.Resources;
import disparity.rpg.items.Weapon;
import disparity.rpg.races.Race;

public class SelectWeaponScreen extends JPanel {
	JFrame main;
	public SelectWeaponScreen(List<String> characterSettings, JFrame mainscreen){
		this.main = mainscreen;
		String[] descs = Weapon.getWeaponDesc().toArray(new String[Weapon.getWeaponDesc().size()]);
		for(int i = 0 ;i < descs.length;i++){
			descs[i] = Resources.addEndl(descs[i]);
		}
		String[] names = Weapon.getWeaponNames().toArray(new String[Weapon.getWeaponNames().size()]);
		Color[] colors = Weapon.getWeaponColors().toArray(new Color[Weapon.getWeaponColors().size()]);
		JComponent[] infoPanels = new InfoPanel[descs.length];
		for(int i = 0;i<descs.length;i++){
			infoPanels[i] = new InfoPanel(names[i], descs[i], "", main, "ArmorSelectionScreen", characterSettings);
			System.out.println(names[i]);
		}
		ColoredTabs tabs = new ColoredTabs(names, colors, infoPanels);
		this.setLayout( new BorderLayout() );
		this.add(tabs, BorderLayout.CENTER);
		this.setVisible(true);
	}
}	
