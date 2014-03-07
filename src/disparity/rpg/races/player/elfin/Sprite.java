package disparity.rpg.races.player.elfin;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.races.Elfin;

public class Sprite extends Elfin{
	private final String desc = "Sprites are small, nimble, magical beings with wings that use their natural magical abilities to quickly scout the battlefield and ambush enemies.";
	private final Color raceColor = new Color(120, 150, 125);
	
	/**
	 * Basic Sprite constructor
	 * used as field for Being construction
	 */	
	public Sprite(Being b){
		super("Sprite");
	}

	/**
	 * Accepts being for Being creation,
	 * applies racial Stat bonuses/penalties
	 * 
	 * Sprite is a Wizard race, they get a
	 * bonus to Wis, and a penalty to Str
	 * @param being
	 */
	@Override
	public void applyRacialStats(Being being){
		being.setStr(being.getStr() - 2);
		being.setWis(being.getWis() + 2);
		being.settHP(being.gettHP() + 2);
		being.settMP(being.gettMP() + 2);
	}
}
