package disparity.items.armor;

import disparity.items.Armor;
import disparity.skills.DefensiveSkill;

public class Helmet extends Armor{
	public Helmet(int quality, DefensiveSkill s){
		super("Helmet");
		base_def = 3 + quality;
		skill = s;
	}
}
