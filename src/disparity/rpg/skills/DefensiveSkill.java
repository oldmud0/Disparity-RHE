package disparity.rpg.skills;

import java.util.ArrayList;
import java.util.List;

import disparity.rpg.being.Being;
import disparity.rpg.skills.defensiveSkills.HeavyArmor;
import disparity.rpg.skills.defensiveSkills.LightArmor;

public class DefensiveSkill extends Skill{
	public DefensiveSkill() {
		super();
	}

	public int defBonus;
	public int agiChange;
	
	@Override
	public void level(Being b){
		if(exp >= lvlXp)
			lvl++;
		addAbilities(b);
	}

	public int getBonus(){
		return defBonus;
	}

	@Override
	public void skillStats(){
		super.skillStats();
		System.out.println("Defense Bonus "+ defBonus);
		System.out.println();
	}
	public static List<String> getSkillNames() {
		List<String> names = new ArrayList<String>();
		names.add(LightArmor.getName());
		names.add(HeavyArmor.getName());
		return names;
	}
	public static List<String> getSkillDescs() {
		List<String> descs = new ArrayList<String>();
		descs.add(LightArmor.getDesc());
		descs.add(HeavyArmor.getDesc());
		return descs;
	}
	public static List<String> getSkillColors(){
		List<String> colors = new ArrayList<String>();
		colors.add(LightArmor.getDesc());
		colors.add(HeavyArmor.getDesc());
		return colors;
	}
}