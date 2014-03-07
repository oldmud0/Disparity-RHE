package disparity.rpg.items.weapons;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.Skill;

public class Battleaxe extends Weapon{	
	private static Color wepColor = new Color(175,1,1);
	static String desc = "A two handed battleaxe swings faster than a warhammer, but does less damage.";
	/**
	 * Create an empty Battleaxe
	 */
	public Battleaxe() {
		super();
	}
	/**
	 * Create a Battleaxe with a given Quality
	 * @param quality
	 */
	public Battleaxe(Quality quality){
		super("Battleaxe", quality);
	}
	/**
	 * Create a Battleaxe with a given Base Damage
	 * @param base_dmg
	 */
	public Battleaxe(int base_dmg){
		super("Battleaxe", base_dmg);
	}
	//Weapon Skill 
	public Skill getSkill(Being b){
		return b.getTwoHand();
	}
}
