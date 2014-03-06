package disparity.rpg.items;

import disparity.rpg.being.Being;
import disparity.rpg.skills.DefensiveSkill;
import disparity.rpg.skills.Skill;
import disparity.rpg.skills.defensiveSkills.*;

public class Armor extends Equippable{
	private int base_def;
	private DefensiveSkill skill;
	
	public Armor(String n){
		super(n);
	}
	public Armor(String name, Quality quality, DefensiveSkill skill){
		setBaseDef(getBaseDef() + quality.getValue());
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
	
	/**
	 * TODO Get rid of this!
	 * @param b
	 * @return
	 */
	public Skill getSkill(Being b){
		if(skill instanceof LightArmor)
			return new LightArmor(b);
		else
			return new HeavyArmor(b);
	}
	
	public int getBaseDef(){
		return this.base_def;
	}
	
	public void setBaseDef(int base_def){
		this.base_def = base_def;
	}
	
	public DefensiveSkill getSkill(){
		return this.skill;
	}
	
	public void setSkill(DefensiveSkill skill){
		this.skill = skill;
	}
	
}
