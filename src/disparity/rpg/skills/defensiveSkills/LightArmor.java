package disparity.rpg.skills.defensiveSkills;

import disparity.rpg.being.Being;
import disparity.rpg.skills.DefensiveSkill;

public class LightArmor extends DefensiveSkill{
	public LightArmor() {
		super();
	}

	public LightArmor(Being b){
		name = "Light Armor";
		lvl = 5;
		exp = 0;
		lvlXp = 20;
		desc = "Skill that determines the usefullness of Light Armor.";
		defBonus = lvl / 5;
		agiChange = lvl;
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