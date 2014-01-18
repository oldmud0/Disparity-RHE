package genericRPG.items;

import genericRPG.beingTypes.Being;
import genericRPG.skills.OffensiveSkill;

public class Weapon extends Item{
	public int hand, base_dmg;
	public Weapon(String n, int hand){
		super(n, 1);
		this.hand = hand;
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
