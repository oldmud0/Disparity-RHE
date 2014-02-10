package disparity.rpg.skills.offensiveSkills;

import disparity.rpg.being.Being;
import disparity.rpg.skills.OffensiveSkill;

public class Magic extends OffensiveSkill{
	public Magic() {
		super();
	}

	public Magic(Being b){
		name = "One Handed";
		lvl = 5;
		exp = 0;
		lvlXp = 20;
		desc = "Skill that governors all abilities in magic.";
		damBonus = this.getBonus();
		addAbilities(b);
	}

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
				System.out.println("Does not have any Abilitys to add...");
				break;
		}
	}
}