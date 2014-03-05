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
	
	/**
	 * Empty constructor for subclasses
	 * to set the Name variable
	 * @param name
	 */
	protected Race(String name){
		this.setName(name);
	}
	
	/**
	 * Accepts being for Being creation,
	 * applies racial Stat bonuses/penalties
	 * @param being
	 */
	public void applyRacialBonus(Being being){
		return;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}