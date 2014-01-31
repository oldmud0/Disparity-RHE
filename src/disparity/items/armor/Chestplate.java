package disparity.items.armor;

import disparity.items.Armor;
import disparity.skills.DefensiveSkill;

public class Chestplate extends Armor{
	public Chestplate(int quality, DefensiveSkill s){
		super("Chestplate");
		base_def = 5 + quality;
		skill = s;
	}
}
