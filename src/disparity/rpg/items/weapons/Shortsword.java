package disparity.rpg.items.weapons;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.OffensiveSkill;

public class Shortsword extends Weapon{
	public Shortsword(String n, int baseDmgBonus) {
		super(n, baseDmgBonus);
		// TODO Auto-generated constructor stub
	}
	public Shortsword(String n, Quality q) {
		super(n, q);
		// TODO Auto-generated constructor stub
	}
	public Shortsword() {
		super();
	}
	//SKILL WEAPON DAMAGE BONUS 
	public OffensiveSkill getSWDB(Being b){
		return b.oneHand;
	}
}
