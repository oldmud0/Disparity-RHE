package disparity.rpg.races.player.elfin;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.races.Elfin;

public class Nymph extends Elfin{
	private final String desc = 
			"Nymphs are minor nature dieties, " + 
			"with power to manipulate feral flora " + 
			"and fauna to their will. Nymphs " + 
			"are well versed in the magic of " + 
			"various natural elements, such as " + 
			"Fire, Water, Wind, and Earth.";
	private final Color raceColor = new Color(250, 90, 235);
	
	/**
	 * Basic Nymph constructor
	 * used as field for Being construction
	 */	
	public Nymph(){
		super("Nymph");
	}

	/**
	 * Accepts being for Being creation,
	 * applies racial Stat bonuses/penalties
	 * 
	 * Nymph is a quick race, suited to being
	 * rogues? Have agi bonus and con penalty
	 * @param being
	 */
	@Override
	public void applyRacialStats(Being being){
		being.setAgi(being.getAgi() + 2);
		being.setCon(being.getCon() - 2);
		being.settHP(being.gettHP() + 2);
		being.settMP(being.gettMP() + 2);
	}
}
