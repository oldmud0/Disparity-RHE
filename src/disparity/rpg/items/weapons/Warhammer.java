package disparity.rpg.items.weapons;

import disparity.rpg.items.Quality;
import disparity.rpg.items.Type;
import disparity.rpg.items.Weapon;

public class Warhammer extends Weapon{
	
	/**
	 * Create a Warhammer with the given Quality
	 * @param quality
	 */
	public Warhammer(Quality quality){
		super("Warhammer", quality, Type.TWO_HANDED, 4);
	}
}
