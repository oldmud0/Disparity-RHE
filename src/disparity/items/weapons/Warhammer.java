package disparity.items.weapons;

import disparity.being.Being;
import disparity.items.Weapon;
import disparity.skills.OffensiveSkill;

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
