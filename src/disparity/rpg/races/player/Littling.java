package disparity.rpg.races.player;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Dagger;
import disparity.rpg.races.Race;

public class Littling extends Race{
	private static String desc = "Littlings are short, nimble, and use flanking tactics to ambush enemies without suffering a scratch.";
	private static Color raceColor = new Color(230, 255, 0);
    public Littling(Being b) {
    	this.setName("Gnome");
    	b.setAgi(b.getAgi() + 2);
    	b.setStr(b.getStr() + 1);
    	b.settHP(b.gettHP() - 1);
    }
	public static String getDesc(){
		return desc;
	}
	
	public static Color getColor(){
		return raceColor;
	}
    
    
}