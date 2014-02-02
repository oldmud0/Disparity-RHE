package disparity.rpg.items.weapons;

import disparity.rpg.being.Being;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.OffensiveSkill;

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
