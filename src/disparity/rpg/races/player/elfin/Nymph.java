package disparity.rpg.races.player.elfin;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Dagger;
import disparity.rpg.races.Elfin;

public class Nymph extends Elfin{
	private static String desc = "To be replaced with an actual description";
	private static Color raceColor = new Color(250, 90, 235);
	public Nymph(Being b){
		name = "Nymph";
		b.con += 2;
		b.tHP += 2;
		b.tMP -= 3;
		b.agi -= 2;
		b.wep = new Dagger(Quality.CRAP);
	}
	public static String getDesc(){
		return desc;
	}
	
	public static Color getColor(){
		return raceColor;
	}
}
