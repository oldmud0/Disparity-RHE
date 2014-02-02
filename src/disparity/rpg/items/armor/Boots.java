package disparity.rpg.items.armor;

import disparity.rpg.items.Armor;
import disparity.rpg.skills.DefensiveSkill;

public class Boots extends Armor{
	public Boots(int quality, DefensiveSkill s){
		super("Boots");
		base_def = 2 + quality;
		skill = s;
	}
}
