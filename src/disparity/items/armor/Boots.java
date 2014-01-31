package disparity.items.armor;

import disparity.items.Armor;
import disparity.skills.DefensiveSkill;

public class Boots extends Armor{
	public Boots(int quality, DefensiveSkill s){
		super("Boots");
		base_def = 2 + quality;
		skill = s;
	}
}
