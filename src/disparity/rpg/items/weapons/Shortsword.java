package disparity.rpg.items.weapons;

import disparity.rpg.items.Quality;
import disparity.rpg.items.Type;
import disparity.rpg.items.Weapon;

public class Shortsword extends Weapon{
	
	/**
	 * Create a Shortsword with a given quality
	 * @param quality
	 */
	public Shortsword(Quality quality){
		super("Shortsword", quality, Type.ONE_HANDED, 1);
	}
}
