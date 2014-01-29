package genericRPG.items.armor;

import genericRPG.items.Armor;

public class Leggings extends Armor{
	public Leggings(int quality){
		super("Leggings");
		base_def = 3 + quality;
	}
	//SKILL ARMOR DEFENSE BONUS 
//	public DefensiveSkill getSADB(Being b){
//		return b.ac;
//	}
}
