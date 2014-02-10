package disparity.rpg.items.weapons;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.OffensiveSkill;

public class Dagger extends Weapon{

	public Dagger() {
		super();
		
	}

	public Dagger(String n, int baseDmgBonus) {
		super(n, baseDmgBonus);
		
	}

	public Dagger(String n, Quality q) {
		super(n, q);
		
	}

	//SKILL WEAPON DAMAGE BONUS 
	public OffensiveSkill getSWDB(Being b){
		return b.oneHand;
	}
}
