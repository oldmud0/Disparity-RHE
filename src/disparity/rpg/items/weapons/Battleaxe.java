package disparity.rpg.items.weapons;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.Skill;

public class Battleaxe extends Weapon{
	public Battleaxe() {
		super();
		desc = "A two handed battleaxe swings faster than a warhammer, but does less damage.";
	}
	public Battleaxe(Quality quality){
		super("Battleaxe", quality);
	}
	public Battleaxe(int base){
		super("Battleaxe", base);
	}
	//Weapon Skill 
	public Skill getSkill(Being b){
		return b.twoHand;
	}
}
