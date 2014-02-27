package disparity.rpg.items.weapons;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.Skill;

public class Dagger extends Weapon{
	private static Color wepColor = new Color(40,200,40);
	static String desc = "A one handed blade that swings faster than all other weapons, but does the least damage.";
	
	public Dagger() {
		super();
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
	public static String getDesc(){
		return desc;
	}

	public static Color getColor(){
		return wepColor;
	}
	
	public static String getName(){
		return "Dagger";
	}
}
