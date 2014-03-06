package disparity.rpg.items.armor;

import disparity.rpg.items.Armor;
import disparity.rpg.items.Quality;
import disparity.rpg.skills.DefensiveSkill;

public class Boots extends Armor{

	public Boots(int baseBonus, DefensiveSkill s){
		super("Boots");
		this.setBaseDef(2 + baseBonus);
		this.setSkill(s);
	}
	
	public Boots(Quality q, DefensiveSkill s){
		super("Boots", q, s);
	}
	
	public Boots(){
		
	}
}
