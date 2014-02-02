package disparity.rpg.items.armor;

import disparity.rpg.items.Armor;
import disparity.rpg.skills.DefensiveSkill;

public class Chestplate extends Armor{
	public Chestplate(int quality, DefensiveSkill s){
		super("Chestplate");
		base_def = 5 + quality;
		skill = s;
	}
}
