package disparity.rpg.races.player;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Warhammer;
import disparity.rpg.races.Race;

public class Pech extends Race{

	public Pech(Being b){
		name = "Pech";
		b.str += 2;
		b.tHP += 2;
		b.tMP -= 3;
		b.agi -= 2;
		b.wep = new Warhammer(Quality.CRAP);
	}
}