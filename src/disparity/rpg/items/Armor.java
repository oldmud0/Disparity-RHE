package disparity.rpg.items;

import disparity.rpg.being.Being;
import disparity.rpg.skills.DefensiveSkill;
import disparity.rpg.skills.Skill;
import disparity.rpg.skills.defensiveSkills.*;

public class Armor extends Equippable{
	public int base_def;
	public DefensiveSkill skill;
	
	public Armor(String n){
		super(n);
	}
	public Armor(String name, Quality quality, DefensiveSkill skill){
		base_def += quality.getValue();
		this.setName(quality.getName()+" "+name);
		this.skill = skill;
	}
	public Armor(){
		
	}
	public void giveName(String mat, String qDesc){
		this.setName(mat + " " + this.getName() + " " + qDesc);
	}
	public void applySkill(){
		//Placeholder
	}
	//Get armor skill bonus
	public Skill getSkill(Being b){
		if(skill instanceof LightArmor)
			return new LightArmor(b);
		else
			return new HeavyArmor(b);
	}
}
