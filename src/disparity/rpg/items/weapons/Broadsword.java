package disparity.rpg.items.weapons;

import disparity.rpg.items.Quality;
import disparity.rpg.items.Type;
import disparity.rpg.items.Weapon;

public class Broadsword extends Weapon{
	
	/**
	 * Create a Brodsword with a given quality
	 * @param quality
	 */
	public Broadsword(Quality quality) {
		super("Broadsword", quality, Type.TWO_HANDED, 2);
	}
}
