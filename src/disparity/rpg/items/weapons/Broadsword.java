package disparity.rpg.items.weapons;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.Skill;

public class Broadsword extends Weapon{
	private static Color wepColor = new Color(80,150,240);
	static String desc = "A two handed broadsword that swings faster than a shortsword, but does more damage.";
	/**
	 * Create a new Broadsword with a given Base Damage
	 * @param base
	 */
	public Broadsword(int base) {
		super("Broadsword", base);
	}
	/**
	 * Create a new empty Broadsword
	 */
	public Broadsword() {
		super();
	}
	/**
	 * Create a new Broadsword with a given Quality
	 * @param quality
	 */
	public Broadsword(Quality quality){
		super("Broadsword", quality);
	}
	//Weapon Skill 
	public Skill getSkill(Being b){
		return b.getTwoHand();
	}
}
