package disparity.rpg.items.armor;

import disparity.rpg.items.Armor;
import disparity.rpg.items.Quality;

public class Helmet extends Armor{

	/**
	 * Helmet constructor
	 * 
	 * Helmet have a base AC bonus of 1
	 */
	public Helmet(Quality quality){
		super("Helmet", quality, 2);
	}
	
	/**
	 * Empty Constructor for reading
	 * Beings from JSON files
	 */
	public Helmet() {
	}
}
