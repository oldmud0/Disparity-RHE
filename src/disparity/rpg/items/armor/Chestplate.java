package disparity.rpg.items.armor;

import disparity.rpg.items.Armor;
import disparity.rpg.items.Quality;

public class Chestplate extends Armor{

	/**
	 * Chestplate constructor
	 * 
	 * Chestplate have a base AC bonus of 3
	 */
	public Chestplate(Quality quality){
		super("Chestplate", quality, 3);
	}
	
	/**
	 * Empty Constructor for reading
	 * Beings from JSON files
	 */
	public Chestplate() {
	}
}
