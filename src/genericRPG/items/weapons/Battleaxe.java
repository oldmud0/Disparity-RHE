package genericRPG.items.weapons;

import genericRPG.beingTypes.Being;
import genericRPG.items.Weapon;
import genericRPG.skills.OffensiveSkill;

public class Battleaxe extends Weapon{
	public Battleaxe(int quality){
		super("Battleaxe", 2);
		base_dmg = 7 + quality;
	}
	//SKILL WEAPON DAMAGE BONUS 
	public OffensiveSkill getSWDB(Being b){
		return b.twoHand;
	}
}
