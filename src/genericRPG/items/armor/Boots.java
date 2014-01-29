package genericRPG.items.armor;

import genericRPG.items.Armor;
import genericRPG.skills.DefensiveSkill;

public class Boots extends Armor{
	public Boots(int quality, DefensiveSkill s){
		super("Boots");
		base_def = 2 + quality;
	}
	//SKILL ARMOR DEFENSE BONUS 
	/*public DefensiveSkill getSADB(Being b){
		return b.ac;
	}
	ERROR: we can't use DefensiveSkill yet until there's a way to instantiate it*/
}
