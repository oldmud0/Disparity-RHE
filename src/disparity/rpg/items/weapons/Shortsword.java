package disparity.rpg.items.weapons;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.Skill;
public class Shortsword extends Weapon{
	private static Color wepColor = new Color(150,120,30);
	static String desc = "A one handed shortsword that swings faster than a battleaxe, but does less damage.";
	/**
	 * Create a new empty Shortsword
	 */
	public Shortsword() {
		super();
	}
	/**
	 * Create a new Shortsword with a given Quality
	 * @param quality
	 */
	public Shortsword(Quality quality){
		super("Shortsword", quality);
	}
	/**
	 * Creates new Shortsword with a given Base Damage
	 * @param base
	 */
	public Shortsword(int base){
		super("Shortsword", base);
	}
	//Weapon Skill 
	public Skill getSkill(Being b){
		return b.getOneHand();
	}
}
