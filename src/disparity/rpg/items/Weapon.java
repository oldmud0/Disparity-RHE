package disparity.rpg.items;

import disparity.rpg.being.Being;
import disparity.rpg.skills.OffensiveSkill;

public class Weapon extends Item{
	public int hand, baseDmg;
	public Weapon(String n, int hand, Quality quality, int baseDmgBonus){
		super(n, 1);
		this.hand = hand;
		this.baseDmg = quality.getValue() + baseDmgBonus;
	}
	public void giveName(String mat, String qDesc){
		name = mat + " " + name + " " + qDesc;

	}
	public void applySkill(){
		//WILL USE LATER
	}
	//GET SKILL WEAPON DAMAGE BONUS
	public OffensiveSkill getSWDB(Being b){
		return new OffensiveSkill();
	}
}
