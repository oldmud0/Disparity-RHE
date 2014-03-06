package disparity.rpg.races.player.elfin;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.races.Elfin;

public class Elf extends Elfin{
	private static String desc = 
			"The elven people are either light " + 
			"or dark skinned, red eyed people who " + 
			"inhabit [SOME PLACE WHERE ELVES LIVE]. " + 
			"Their intellect and agility combined " + 
			"with their respect to nature makes them " + 
			"powerful wizards and archers.";
	private static Color raceColor = new Color(0, 165, 50);
	
	/**
	 * TODO Elf notes
	 */
	public Elf(){
		super("Elf");
	}
	
	/**
	 * 
	 * @param being
	 */
	public void applyRacialStats(Being being){
		being.setWis(being.getWis() + 2);
		being.setCon(being.getCon() - 2);
		being.settHP(being.getHp() + 2);
		being.settMP(being.gettMP() + 2);
	}
	
	public static String getDesc(){
		return desc;
	}
	
	public static Color getColor(){
		return raceColor;
	}
}
