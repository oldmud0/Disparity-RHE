package disparity.rpg.items.weapons;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.OffensiveSkill;

public class Warhammer extends Weapon{
	public Warhammer(String n, int baseDmgBonus) {
		super(n, baseDmgBonus);
		
	}
	public Warhammer(String n, Quality q) {
		super(n, q);
		
	}
	public Warhammer() {
		super();
	}
	//SKILL WEAPON DAMAGE BONUS 
	public OffensiveSkill getSWDB(Being b){
		return b.twoHand;
	}
}
