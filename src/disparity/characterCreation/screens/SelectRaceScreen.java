package disparity.characterCreation.screens;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import disparity.characterCreation.MainScreen;
import disparity.rpg.races.Race;
import disparity.rpg.races.player.elfin.*;
import disparity.rpg.races.player.*;

public class SelectRaceScreen extends MainScreen {
	
	
	public SelectRaceScreen() {
		init();
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	private void init() {
		frmDisparity = new JFrame();
		List<String> playableRaces = Race.getCharacterRaces();
		String[] descs = new String[allRaces.length];
		for(int i = 0;i<allRaces.length;i++){
			
		}
		ColoredTab(JTabbedPane.LEFT, wololo);
		
	}
}
