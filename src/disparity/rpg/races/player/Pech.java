package disparity.rpg.races.player;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Warhammer;
import disparity.rpg.races.Race;

public class Pech extends Race{
	static String desc = "Pechs are a short, strong race that dominate the battlefeild with pure strength and wizdom of the magical arts. Known to crush skulls and cast powerful spells, the Pechs are fine warriors and wizards alike.";
	private static Color raceColor = new Color(185, 150, 130);
	public Pech(Being b){
		b.setName("Pech");
		b.setStr(b.getStr() + 2);
		b.settHP(b.gettHP() + 2);
		b.settMP(b.gettMP() - 3);
		b.setAgi(b.getAgi() - 2);
	}	
	public static String getDesc(){
		return desc;
	}
	
	public static Color getColor(){
		return raceColor;
	}
}