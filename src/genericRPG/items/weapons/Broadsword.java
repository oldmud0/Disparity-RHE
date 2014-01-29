package genericRPG.items.weapons;

import genericRPG.being.Being;
import genericRPG.items.Weapon;
import genericRPG.skills.OffensiveSkill;

public class Broadsword extends Weapon{
	public Broadsword(int quality){
		super("Broadsword", 2);
		base_dmg = 6 + quality;
	}
	//SKILL WEAPON DAMAGE BONUS 
	public OffensiveSkill getSWDB(Being b){
		return b.twoHand;
	}
}

