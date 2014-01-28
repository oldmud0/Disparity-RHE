package genericRPG.items;

import genericRPG.skills.DefensiveSkill;
import genericRPG.beingTypes.Being;

public class Armor extends Item{
	public int base_def;
	public Armor(String n){
		super(n, 1);
	}
	public void giveName(String mat, String qDesc){
		name = mat + " " + name + " " + qDesc;
	}
	public void applySkill(){
		//WILL USE LATER
	}
	//GET SKILL ARMOR DEFENSE BONUS
	public DefensiveSkill getSADB(Being b){
		return new DefensiveSkill();
	}
}
