package disparity.rpg.items;

import disparity.rpg.being.Being;

public class Armor extends Equippable{

	/**
	 * Constructor for Armor object subclasses,
	 * All instances of Armor should use this constructor 
	 * #natzi
	 */
	protected Armor(String name, Quality quality, int baseArmorVal){
		this.bonus  = quality.getValue() + baseArmorVal;
		this.name = quality.getName() + " " + name;
		this.quality = quality;
	}
	
	/**
	 * Empty Constructor for reading
	 * Beings from JSON files
	 */
	public Armor(){
	}
	
	/**
	 * TODO implement
	 * skills that can be applied
	 * to Items
	 */
	public void applySkill(){
	}
	
	/**
	 * Applies Skill bonus of Being to
	 * Weapon, so that Being can have an
	 * updated AC stat
	 */
	public void applyBonus(Being being){
		switch(this.quality.getType()){
		case HEAVY:
			this.bonus += being.getHeavyArmorBonus();
			break;
		case LIGHT:
			this.bonus += being.getLightArmorBonus();
			break;
		case MEDIUM:
			//TODO implement MEDIUM armor
			break;
		}
	}	
	
	@Override
	public String toString(){
		return this.name;
	}
	
	/**
	 * Miscellaneous GETTERS/SETTERS
	 */	
	public double getBonus(){
		return this.bonus;
	}
	
	public void setBonus(int bonus){
		this.bonus = bonus;
	}
}
