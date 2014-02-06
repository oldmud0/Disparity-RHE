package disparity.rpg.items.armor;

import disparity.rpg.items.Armor;
import disparity.rpg.items.Quality;
import disparity.rpg.skills.DefensiveSkill;

public class Leggings extends Armor{
	public Leggings(int quality, DefensiveSkill s){
		super("Leggings");
		base_def = 3 + quality;
		skill = s;
	}
	
	public Leggings(Quality quality) {
		super(quality);
	}
}
