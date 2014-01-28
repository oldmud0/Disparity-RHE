package genericRPG.items.armor;

import genericRPG.items.Armor;

public class Helmet extends Armor{
	public Helmet(int quality){
		super("Helmet");
		base_def = 3 + quality;
	}
	//SKILL ARMOR DEFENSE BONUS 
//	public DefensiveSkill getSADB(Being b){
//		return b.ac;
//	}
}
