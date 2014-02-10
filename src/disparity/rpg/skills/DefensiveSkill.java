package disparity.rpg.skills;

import disparity.rpg.being.Being;

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
}