package disparity.items.weapons;

import disparity.being.Being;
import disparity.items.Weapon;
import disparity.skills.OffensiveSkill;

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
