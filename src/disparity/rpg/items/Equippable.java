package disparity.rpg.items;

import disparity.rpg.being.Being;
import disparity.rpg.skills.Skill;

public class Equippable extends Item{
	private Skill skill;
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
	/**
	 * Returns Skill that modifies Equippable Item
	 * @return 
	 */
	public Skill getSkill(){
		return this.skill;
	}
	/**
	 * Sets Skill that modifies Equippable Item
	 * @param skill
	 */
	public void setSkill(Skill skill){
		this.skill = skill;
	}
}
