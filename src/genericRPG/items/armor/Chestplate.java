package genericRPG.items.armor;

import genericRPG.items.Armor;

public class Chestplate extends Armor{
	public Chestplate(int quality){
		super("Chestplate");
		base_def = 5 + quality;
	}
	//SKILL ARMOR DEFENSE BONUS 
	/*public DefensiveSkill getSADB(Being b){
		return b.ac;
	}*/
}
