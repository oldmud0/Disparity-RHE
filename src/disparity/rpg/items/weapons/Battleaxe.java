package disparity.rpg.items.weapons;

import disparity.rpg.being.Being;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.OffensiveSkill;

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
