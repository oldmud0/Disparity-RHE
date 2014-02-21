package disparity.rpg.races.player;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Broadsword;
import disparity.rpg.races.Race;

public class HalfOrc extends Race{
	String desc = "To be replaced with an actual description";
	public HalfOrc(Being b){
		name = "Half-Orc";
		b.str += 2;
		b.tHP += 2;
		b.tMP -= 3;
		b.agi -= 2;
		b.wep = new Broadsword(Quality.CRAP);
	}
}
