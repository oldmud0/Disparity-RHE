package disparity.rpg.items.weapons;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.OffensiveSkill;

public class Battleaxe extends Weapon{
	public Battleaxe() {
		super();
	}
	public Battleaxe(Quality quality){
		super("Battleaxe", quality);
	}
	public Battleaxe(int base){
		super("Battleaxe", base);
	}
	//SKILL WEAPON DAMAGE BONUS 
	public OffensiveSkill getSWDB(Being b){
		return b.twoHand;
	}
}
