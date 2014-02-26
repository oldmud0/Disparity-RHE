package disparity.rpg.items.weapons;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.Skill;

public class Dagger extends Weapon{

	public Dagger() {
		super();
		desc = "A one handed blade that swings faster than all other weapons, but does the least damage.";
	}
	public Dagger(Quality quality){
		super("Dagger", quality);
	}
	public Dagger(int base){
		super("Dagger", base);
	}

	//Weapon Skill 
	public Skill getSkill(Being b){
		return b.oneHand;
	}
}
