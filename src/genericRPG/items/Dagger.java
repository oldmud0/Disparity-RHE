package genericRPG.items;

import genericRPG.beingTypes.Being;
import genericRPG.skills.OffensiveSkill;

public class Dagger extends Weapon{
	public Dagger(int quality){
		super("Dagger", 1);
		base_dmg = 4 + quality;
	}
	//SKILL WEAPON DAMAGE BONUS 
	public OffensiveSkill getSWDB(Being b){
		return b.oneHand;
	}
}
