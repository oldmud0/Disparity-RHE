package disparity.rpg.items.armor;

import disparity.rpg.items.Armor;
import disparity.rpg.items.Quality;
import disparity.rpg.skills.DefensiveSkill;

public class Chestplate extends Armor{
	public Chestplate() {
		super();
	}

	public Chestplate(int quality, DefensiveSkill s){
		super("Chestplate");
		this.setBaseDef(5 + quality);
		this.setSkill(s);
	}

	public Chestplate(Quality q, DefensiveSkill s) {
		super("Chestplate", q, s);
	}
}
