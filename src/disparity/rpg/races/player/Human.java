package disparity.rpg.races.player;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Shortsword;
import disparity.rpg.races.Race;

public class Human extends Race{
	private static String desc = "To be replaced with an actual description";
	private static Color raceColor = new Color(230, 210, 125);
    public Human(Being b) {
    	name = "Human";
    	b.wep = new Shortsword(Quality.CRAP);
    }
	public static String getDesc(){
		return desc;
	}
	
	public static Color getColor(){
		return raceColor;
	}
    
    
}