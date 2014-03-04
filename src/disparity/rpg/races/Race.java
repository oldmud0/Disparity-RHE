package disparity.rpg.races;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import disparity.rpg.being.Being;
import disparity.rpg.races.player.HalfOrc;
import disparity.rpg.races.player.Human;
import disparity.rpg.races.player.Littling;
import disparity.rpg.races.player.Pech;
import disparity.rpg.races.player.elfin.Elf;
import disparity.rpg.races.player.elfin.Nymph;
import disparity.rpg.races.player.elfin.Sprite;

public class Race{
	private String name;
	private static String desc = "Nobody knows about this race.";
	private static Color raceColor = new Color(0,0,0);
	
	public static String getDesc(){
		return desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Color getRaceColor() {
		return raceColor;
	}

	public static void setRaceColor(Color raceColor) {
		Race.raceColor = raceColor;
	}

	public static void setDesc(String desc) {
		Race.desc = desc;
	}

}