package disparity.rpg.races.player;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.races.Race;

public class Human extends Race{
	private final String desc = 
			"Humans are well spoken and educated, " + 
			"known for their dicipline and training. " + 
			"Although not as physically imposing " + 
			"as other races, they have used their " + 
			"ability as diplomats and merchants to " + 
			"rule the lands, united under the Empire. " + 
			"Humans learn new skills quickly due to " + 
			"their education and training.";
	private final Color raceColor = new Color(230, 210, 125);
    
	/**
	 * Basic Human constructor
	 * used as field for Being construction
	 */
	public Human() {
    	super("Human");
    }
	
	/**
	 * Accepts being for Being creation,
	 * applies racial Stat bonuses/penalties
	 * 
	 * Human will be a simpler race as 
	 * they will not have any racial stat
	 * bonuses
	 * @param being
	 */
	@Override
    public void applyRacialStats(Being being){
		being.settHP(being.gettHP() + 2);
		being.settMP(being.gettMP() + 2);
	}

	public String getDesc() {
		return desc;
	}

	public Color getRaceColor() {
		return raceColor;
	}
}