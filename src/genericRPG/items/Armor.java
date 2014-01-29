package genericRPG.items;
import genericRPG.skills.DefensiveSkill;
import genericRPG.being.Being;
import genericRPG.skills.defensiveSkills.*;

public class Armor extends Item{
	public int base_def;
	
	DefensiveSkill skill;
	
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
		if(skill instanceof LightArmor)
			return new LightArmor();
		else
			return new HeavyArmor();
	}
}
