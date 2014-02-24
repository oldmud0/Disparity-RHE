package disparity.rpg.races.player;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Dagger;
import disparity.rpg.races.Race;

public class Littling extends Race{
	static String desc = "Littlings are short, nimble, and use flanking tactics to dominate the battlefeild. wip ----";
	private static Color raceColor = new Color(230, 255, 0);
    public Littling(Being b) {
    	name = "Gnome";
    	b.agi += 2;
    	b.str += 1;
    	b.tHP -= 1;
    	b.wep = new Dagger(Quality.CRAP);
    }
	public static String getDesc(){
		return desc;
	}
	
	public static Color getColor(){
		return raceColor;
	}
    
    
}