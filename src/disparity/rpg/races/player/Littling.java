package disparity.rpg.races.player;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Dagger;
import disparity.rpg.races.Race;

public class Littling extends Race{
	String desc = "To be replaced with an actual description";
    public Littling(Being b) {
    	name = "Gnome";
    	b.agi += 2;
    	b.str += 1;
    	b.tHP -= 1;
    	b.wep = new Dagger(Quality.CRAP);
    }
    
    
}