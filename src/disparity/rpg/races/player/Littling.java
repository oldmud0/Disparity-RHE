package disparity.rpg.races.player;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.races.Race;

public class Littling extends Race{
	private static String desc = 
		"Littlings are short, "+ 
		"nimble, and use flanking tactics to ambush "+ 
		"enemies without suffering a scratch.";
	private static Color raceColor = new Color(230, 255, 0);
	
	/**
	 * Empty constructor for subclasses
	 * to set the Name variable
	 * @param name
	 */
	public Littling() {
    	super("Littling");
    }
	
	/**
	 * Accepts being for Being creation,
	 * applies racial Stat bonuses/penalties
	 * 
	 * Littling will have a agi bonus and
	 * str penalty
	 * @param being
	 */	
	public void applyRacialStats(Being being){
		being.setAgi(being.getAgi() + 4);
		being.setStr(being.getStr() - 2);
    	being.settMP(being.gettMP() + 2);
	}

	public static String getDesc() {
		return desc;
	}

	public static void setDesc(String desc) {
		Littling.desc = desc;
	}

	public static Color getRaceColor() {
		return raceColor;
	}

	public static void setRaceColor(Color raceColor) {
		Littling.raceColor = raceColor;
	}
    
}