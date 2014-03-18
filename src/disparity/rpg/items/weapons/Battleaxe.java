package disparity.rpg.items.weapons;

import disparity.rpg.items.Quality;
import disparity.rpg.items.Type;
import disparity.rpg.items.Weapon;

public class Battleaxe extends Weapon{	

	/**
	 * Create a Battleaxe with a given Quality
	 * @param quality
	 */
	public Battleaxe(Quality quality){
		super("Battleaxe", quality, Type.TWO_HANDED, 3);
	}
}
