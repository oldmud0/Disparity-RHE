package disparity.rpg.items.armor;

import disparity.rpg.items.Armor;
import disparity.rpg.items.Quality;

public class Boots extends Armor{
	
	/**
	 * Boots constructor
	 * 
	 * Boots have a base AC bonus of 1
	 */
	public Boots(Quality quality){
		super("Boots", quality, 1);
	}
	
	/**
	 * Empty Constructor for reading
	 * Beings from JSON files
	 */
	public Boots() {
	}
	
}
