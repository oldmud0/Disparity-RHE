package disparity.rpg.races.player.elfin;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Dagger;
import disparity.rpg.races.Elfin;

public class Nymph extends Elfin{
	private final String desc = 
			"Nymphs are minor nature dieties, " + 
			"with power to manipulate feral flora " + 
			"and fauna to their will. Nymphs " + 
			"are well versed in the magic of " + 
			"various natural elements, such as " + 
			"Fire, Water, Wind, and Earth.";
	private final Color raceColor = new Color(250, 90, 235);
	public Nymph(Being b){
		name = "Nymph";
		b.con += 2;
		b.tHP += 2;
		b.tMP -= 3;
		b.agi -= 2;
		b.wep = new Dagger(Quality.CRAP);
	}
}
