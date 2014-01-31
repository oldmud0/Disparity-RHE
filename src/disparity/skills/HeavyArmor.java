package disparity.skills;

import disparity.being.Being;
import disparity.skills.DefensiveSkill;

public class HeavyArmor extends DefensiveSkill{
	public HeavyArmor(Being b){
		name = "Heavy Armor";
		lvl = 5;
		exp = 0;
		lvlXp = 20;
		desc = "Skill that determines the usefullness of Heavy Armor.";
		defBonus = this.getDefBonus();
		addAbilities(b);
	}

	@Override
	public void addAbilities(Being b){
		switch(lvl){
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				System.out.println("Does not have any skills to add...");
				break;
		}
	}
}