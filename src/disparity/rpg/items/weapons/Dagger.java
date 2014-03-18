package disparity.rpg.items.weapons;

import disparity.rpg.items.Quality;
import disparity.rpg.items.Type;
import disparity.rpg.items.Weapon;

public class Dagger extends Weapon{

	/**
	 * Create a Dagger with a given Quality
	 * @param quality
	 */
	public Dagger(Quality quality){
		super("Dagger", quality, Type.ONE_HANDED, 0);
	}
}
