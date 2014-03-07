package disparity.rpg.items.weapons;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.Skill;

public class Dagger extends Weapon{
	private static Color wepColor = new Color(40,200,40);
	static String desc = "A one handed blade that swings faster than all other weapons, but does the least damage.";
	/**
	 * Create a new empty Dagger
	 */
	public Dagger() {
		super();
	}
	/**
	 * Create a new Dagger with a given Quality
	 * @param quality
	 */
	public Dagger(Quality quality){
		super("Dagger", quality);
	}
	/**
	 * Create a new Dagger with given Base Damage
	 * @param base
	 */
	public Dagger(int base){
		super("Dagger", base);
	}

	//Weapon Skill 
	public Skill getSkill(Being b){
		return b.getOneHand();
	}
}
