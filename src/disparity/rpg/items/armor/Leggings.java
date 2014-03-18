package disparity.rpg.items.armor;

import disparity.rpg.items.Armor;
import disparity.rpg.items.Quality;

public class Leggings extends Armor{
	
	/**
	 * Leggings constructor
	 * 
	 * Leggings have a base AC bonus of 2
	 */
	public Leggings(Quality quality){
		super("Leggings", quality, 2);
	}
	
	/**
	 * Empty Constructor for reading
	 * Beings from JSON files
	 */
	public Leggings() {
	}
}
