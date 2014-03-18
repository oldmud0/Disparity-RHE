package disparity.rpg.items;

import disparity.rpg.being.Being;

public abstract class Equippable extends Item{
	protected double bonus;
	protected Quality quality;
	/**
	 * Makes an Item that is intended to be equipped 
	 * with a specified name, such as armor.
	 * 
	 * Should never create an object of Equippable
	 * directly
	 * @param n	the item's name
	 */
	protected Equippable(String name){
		super(name);
	}
	
	/**
	 * Creates an empty Equippable object
	 */
	protected Equippable(){
	}
	
	/**
	 * Used in sublclasses to determine
	 * and create the bonus stat for
	 * the Equippable item
	 * @param being
	 */
	public void applyBonus(Being being){
		return;
	}
	
	/**
	 * Miscellaneous GETTERS/SETTERS
	 */
	public Quality getQuality(){
		return this.quality;
	}
}
