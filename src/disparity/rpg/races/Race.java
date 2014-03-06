package disparity.rpg.races;

import java.awt.Color;
import disparity.rpg.being.Being;

public class Race{
	protected String name;
	protected static String desc = "Nobody knows about this race.";
	protected static Color raceColor = new Color(0,0,0);
	
	/**
	 * Empty constructor for subclasses
	 * to set the Name variable
	 * @param name
	 */
	protected Race(String name){
		this.setName(name);
	}
	
	/**
	 * Empty Race constructor for
	 * general use of creating Races
	 */
	public Race(){
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