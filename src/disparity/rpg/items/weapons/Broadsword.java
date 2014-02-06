package disparity.rpg.items.weapons;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.OffensiveSkill;

public class Broadsword extends Weapon{
	public Broadsword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Broadsword(Quality quality){
		super("Broadsword", 2, quality, 6);
	}
	//SKILL WEAPON DAMAGE BONUS 
	public OffensiveSkill getSWDB(Being b){
		return b.twoHand;
	}
}

