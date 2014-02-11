package disparity.rpg.items;

import disparity.rpg.being.Being;
import disparity.rpg.skills.Skill;

public class Equippable extends Item{
	Skill skill;
	public Equippable(String n){
		super(n);
	}
	
	public Equippable(){
		
	}
	
	//Item Skill 
	public Skill getSkill(Being b){
		return new Skill();
	}
	
	public void setSkill(Skill skill){
		this.skill = skill;
	}
}
