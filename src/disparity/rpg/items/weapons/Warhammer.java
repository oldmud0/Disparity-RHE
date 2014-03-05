package disparity.rpg.items.weapons;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.Skill;

public class Warhammer extends Weapon{
	private static Color wepColor = new Color(150,50,170);
	static String desc = "A warhammer that swings the slowest of all the weapons, but does the most damage.";

	public Warhammer() {
		super();
	}
	public Warhammer(Quality quality){
		super("Warhammer", quality);
	}
	public Warhammer(int base){
		super("Warhammer", base);
	}
	//Weapon Skill 
	public Skill getSkill(Being b){
		return b.getTwoHand();
	}
}
