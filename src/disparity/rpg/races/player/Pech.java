package disparity.rpg.races.player;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Warhammer;
import disparity.rpg.races.Race;

public class Pech extends Race{
	static String desc = "To be replaced with an actual description";
	private static Color raceColor = new Color(185, 150, 130);
	public Pech(Being b){
		name = "Pech";
		b.str += 2;
		b.tHP += 2;
		b.tMP -= 3;
		b.agi -= 2;
		b.wep = new Warhammer(Quality.CRAP);
	}	
	public static String getDesc(){
		return desc;
	}
	
	public static Color getColor(){
		return raceColor;
	}
}