package genericRPG.items.weapons;

import genericRPG.being.Being;
import genericRPG.items.Weapon;
import genericRPG.skills.OffensiveSkill;

public class Shortsword extends Weapon{
	public Shortsword(int quality){
		super("Shortsword", 1);
		base_dmg = 5 + quality;
	}
	//SKILL WEAPON DAMAGE BONUS 
	public OffensiveSkill getSWDB(Being b){
		return b.oneHand;
	}
}
