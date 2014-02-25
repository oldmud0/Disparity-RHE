package disparity.rpg.races.player.elfin;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Dagger;
import disparity.rpg.races.Elfin;

public class Sprite extends Elfin{
	private static String desc = "Sprites are small, nimble, magical beings with wings that use their natural magical abilities to quickly scout the battlefield and ambush enemies.";
	private static Color raceColor = new Color(120, 150, 125);
	public Sprite(Being b){
		name = "Sprite";
		b.agi += 2;
		b.tHP += 2;
		b.tMP -= 3;
		b.con -= 2;
		b.wep = new Dagger(Quality.CRAP);
	}
	public static String getDesc(){
		return desc;
	}
	
	public static Color getColor(){
		return raceColor;
	}
}
