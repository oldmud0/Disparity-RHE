package disparity.items.armor;

import disparity.items.Armor;
import disparity.skills.DefensiveSkill;

public class Leggings extends Armor{
	public Leggings(int quality, DefensiveSkill s){
		super("Leggings");
		base_def = 3 + quality;
		skill = s;
	}
}
