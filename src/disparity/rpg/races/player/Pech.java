package disparity.rpg.races.player;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.races.Race;

public class Pech extends Race{
	static String desc = 
		"Pechs are a short, strong race "
		+ "that dominate the battlefeild with pure strength "
		+ "and wizdom of the magical arts. Known to crush "
		+ "skulls and cast powerful spells, the Pechs are "
		+ "fine warriors and wizards alike.";
	private static Color raceColor = new Color(185, 150, 130);
	
	/**
	 * Basic Pech constructor
	 * used as field for Being construction
	 */	
	public Pech(){
		super("Pech");
	}	
	
	/**
	 * Accepts being for Being creation,
	 * applies racial Stat bonuses/penalties
	 * 
	 * Pech is a hardy, so they get a con
	 * bonus, and a agi penalty
	 * @param being
	 */
	@Override
	public void applyRacialStats(Being being){
		being.setStr(being.getStr() + 4);
		being.setAgi(being.getAgi() - 2);
		being.setCon(being.getCon() + 2);
		being.settHP(being.gettHP() + 2);
		being.settMP(being.gettMP() - 2);
	}
	
	public static String getDesc(){
		return desc;
	}
	
	public static Color getColor(){
		return raceColor;
	}
}