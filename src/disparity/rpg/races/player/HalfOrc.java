package disparity.rpg.races.player;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.races.Race;

public class HalfOrc extends Race{
	private final String desc = 
			"The offspring of Orcs and Humans, " + 
			"Half Orcs are tall, powerful warriors, " + 
			"known for brute force and skill in melee " + 
			"combat. Although Half Orcs lack wisdom " + 
			"and intelligence, they compensate with " + 
			"their strength.";
	private final Color raceColor = new Color(120, 150, 125);
	
	/**
	 * Basic HalfOrc constructor
	 * used as field for Being construction
	 */
	public HalfOrc(){
		super("Half Orc");
	}
	
	/**
	 * Accepts being for Being creation,
	 * applies racial Stat bonuses/penalties
	 * 
	 * HalfOrc is a Barbaric race. Will 
	 * give bonuses to str and con and penalties to wis
	 * @param being
	 */
	public void applyRacialStats(Being being){
		being.setStr(being.getStr() + 2);
		being.setCon(being.getCon() + 2);
		being.setWis(being.getWis() - 2);
		being.settHP(being.gettHP() + 2);
	}

	public String getDesc() {
		return desc;
	}

	public Color getRaceColor() {
		return raceColor;
	}
}
