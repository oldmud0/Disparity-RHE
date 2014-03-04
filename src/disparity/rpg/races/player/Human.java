package disparity.rpg.races.player;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Shortsword;
import disparity.rpg.races.Race;

public class Human extends Race{
	private static String desc = "Humans are well spoken and educated, known for their dicipline and training. Although not as physically imposing as other races, they have used their ability as diplomats and merchants to rule the lands, united under the Empire. Humans learn new skills quickly due to their education and training.";
	private static Color raceColor = new Color(230, 210, 125);
    public Human(Being b) {
    	b.setName("Human");
    }
    
}