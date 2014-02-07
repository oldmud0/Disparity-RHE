package disparity.rpg.items.weapons;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.OffensiveSkill;

public class Broadsword extends Weapon{
	public Broadsword(int base) {
		super("Broadsword", base);
	}
	public Broadsword() {
		super();
	}
	public Broadsword(Quality quality){
		super("Broadsword", quality);
	}
	//SKILL WEAPON DAMAGE BONUS 
	public OffensiveSkill getSWDB(Being b){
		return b.twoHand;
	}
}

