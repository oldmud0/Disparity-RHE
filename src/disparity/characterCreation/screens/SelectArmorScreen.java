package disparity.characterCreation.screens;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

import disparity.characterCreation.GUIresources.ColoredTabs;
import disparity.characterCreation.GUIresources.InfoPanel;
import disparity.characterCreation.GUIresources.Resources;
import disparity.rpg.skills.DefensiveSkill;

public class SelectArmorScreen extends JPanel {
	/*
	 * 
	 */
	private static final long serialVersionUID = 6031046616352225577L;
	JFrame main;
	public SelectArmorScreen(List<String> characterSettings, JFrame mainscreen){
		this.main = mainscreen;
		String[] names = DefensiveSkill.getSkillNames().toArray(new String[DefensiveSkill.getSkillNames().size()]);
		String[] descs = DefensiveSkill.getSkillDescs().toArray(new String[DefensiveSkill.getSkillNames().size()]);
		Color[] colors = DefensiveSkill.getSkillColors().toArray(new Color[DefensiveSkill.getSkillNames().size()]);		
		for(int i = 0 ;i < descs.length;i++){
			descs[i] = Resources.addEndl(descs[i]);
		}
		JComponent[] infoPanels = new InfoPanel[descs.length];
		for(int i = 0;i<descs.length;i++){
			infoPanels[i] = new InfoPanel(names[i], descs[i], "", main, "SelectArmorScreen", characterSettings);
		}
		ColoredTabs tabs = new ColoredTabs(names, colors, infoPanels);
		this.setLayout( new BorderLayout() );
		this.add(tabs, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
