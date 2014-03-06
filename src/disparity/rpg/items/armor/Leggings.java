package disparity.rpg.items.armor;

import disparity.rpg.items.Armor;
import disparity.rpg.items.Quality;
import disparity.rpg.skills.DefensiveSkill;

public class Leggings extends Armor{
	public Leggings() {
		super();
		
	}

	public Leggings(int quality, DefensiveSkill s){
		super("Leggings");
		this.setBaseDef(3 + quality);
		this.setSkill(s);
	}
	
	public Leggings(Quality q, DefensiveSkill s) {
		super("Leggings", q, s);
	}
}
