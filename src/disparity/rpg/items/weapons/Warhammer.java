package disparity.rpg.items.weapons;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.Skill;

public class Warhammer extends Weapon{
	public Warhammer() {
		super();
		desc = "A warhammer that swings the slowest of all the weapons, but does the most damage.";
	}
	public Warhammer(Quality quality){
		super("Warhammer", quality);
	}
	public Warhammer(int base){
		super("Warhammer", base);
	}
	//Weapon Skill 
	public Skill getSkill(Being b){
		return b.twoHand;
	}
}
