package disparity.rpg.races.player;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Shortsword;
import disparity.rpg.races.Race;

public class Human extends Race{

    public Human(Being b) {
    	name = "Human";
    	b.wep = new Shortsword(Quality.CRAP);
    }
}