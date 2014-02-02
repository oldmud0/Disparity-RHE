package disparity.rpg.items.weapons;

import disparity.rpg.being.Being;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.OffensiveSkill;

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
