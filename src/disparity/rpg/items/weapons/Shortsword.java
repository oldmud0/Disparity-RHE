package disparity.rpg.items.weapons;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.Skill;

public class Shortsword extends Weapon{
	public Shortsword() {
		super();
	}
	public Shortsword(Quality quality){
		super("Shortsword", quality);
	}
	public Shortsword(int base){
		super("Shortsword", base);
	}
	//Weapon Skill 
	public Skill getSkill(Being b){
		return b.oneHand;
	}
}
