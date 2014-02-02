package disparity.rpg.items.weapons;

import disparity.rpg.being.Being;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.OffensiveSkill;

public class Warhammer extends Weapon{
	public Warhammer(int qnt,  int quality){
		super("Warhammer", 2);
		base_dmg = 8 + quality;
	}
	//SKILL WEAPON DAMAGE BONUS 
	public OffensiveSkill getSWDB(Being b){
		return b.twoHand;
	}
}
