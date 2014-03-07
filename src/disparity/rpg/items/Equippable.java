package disparity.rpg.items;

import disparity.rpg.being.Being;
import disparity.rpg.skills.Skill;

public class Equippable extends Item{
	private Skill skill;
	private Quality quality;
	/**
	 * Makes an Item that is intended to be equipped 
	 * with a specified name, such as armor.
	 * @param n	the item's name
	 */
	public Equippable(String n){
		super(n);
	}
	/**
	 * Makes an empty Equippable Item
	 */
	public Equippable(){
		
	}
	public Skill getSkill(){
		return this.skill;
	}
	public void setSkill(Skill skill){
		this.skill = skill;
	}
	public Quality getQuality(){
		return this.quality;
	}
	public void setQuality(Quality quality){
		this.quality = quality;
	}
}
