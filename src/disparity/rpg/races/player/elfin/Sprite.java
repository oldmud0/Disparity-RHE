package disparity.rpg.races.player.elfin;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Dagger;
import disparity.rpg.races.Elfin;

public class Sprite extends Elfin{
	public Sprite(Being b){
		name = "Sprite";
		b.agi += 2;
		b.tHP += 2;
		b.tMP -= 3;
		b.con -= 2;
		b.wep = new Dagger(Quality.CRAP);
	}
}
