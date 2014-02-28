package disparity.rpg.skills.defensiveSkills;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.skills.DefensiveSkill;

public class HeavyArmor extends DefensiveSkill{
	public HeavyArmor() {
		super();
	}

	public HeavyArmor(Being b){
		name = "Heavy Armor";
		lvl = 5;
		exp = 0;
		lvlXp = 20;
		desc = "Skill that determines the usefullness of Heavy Armor.";
		defBonus = lvl;
		agiChange = -1 * (lvl / 1);
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
	
	public static String getName(){
		return "Heavy Armor";
	}
	
	public static String getDesc(){
		return "Heavy armor slows you down and makes you louader while sneaking, but can deflect light blows and mitigate damage.";
	}
	public static Color getColor(){
		return new Color(150, 85, 200);
	}
}