package disparity.rpg.items.armor;

import disparity.rpg.items.Armor;
import disparity.rpg.items.Quality;
import disparity.rpg.skills.DefensiveSkill;

public class Boots extends Armor{

	public Boots(int baseBonus, DefensiveSkill s){
		super("Boots");
		base_def = 2 + baseBonus;
		skill = s;
	}
	
	public Boots(Quality q, DefensiveSkill s){
		super("Boots", q, s);
	}
	
	public Boots(){
		
	}
}
