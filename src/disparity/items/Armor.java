package disparity.items;
import disparity.being.Being;
import disparity.skills.DefensiveSkill;
import disparity.skills.defensiveSkills.*;

public class Armor extends Item{
	public int base_def;
	public DefensiveSkill skill;
	
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
			return new LightArmor(b);
		else
			return new HeavyArmor(b);
	}
}
