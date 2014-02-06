package disparity.rpg.items.weapons;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.OffensiveSkill;

public class Dagger extends Weapon{
	public Dagger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dagger(Quality quality){
		super("Dagger", 1, quality, 4);
	}
	//SKILL WEAPON DAMAGE BONUS 
	public OffensiveSkill getSWDB(Being b){
		return b.oneHand;
	}
}
