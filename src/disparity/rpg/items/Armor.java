package disparity.rpg.items;

import disparity.rpg.being.Being;
import disparity.rpg.skills.DefensiveSkill;
import disparity.rpg.skills.defensiveSkills.*;

public class Armor extends Item{
	public int base_def;
	public DefensiveSkill skill;
	
	public Armor(String n){
		super(n);
	}
	public Armor(String name, Quality quality, DefensiveSkill skill){
		base_def += quality.getValue();
		this.name = quality.getName()+" "+name;
		this.skill = skill;
	}
	public Armor(){
		
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
