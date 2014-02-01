package disparity.skills;

import disparity.being.Being;

public class DefensiveSkill extends Skill{
	public int defBonus;
	public int agiChange;
	
	@Override
	public void level(Being b){
		if(exp >= lvlXp)
			lvl++;
		defBonus = this.getDefBonus();
		addAbilities(b);
	}

	public int getDefBonus(){
		return lvl / 2;
	}

	@Override
	public void skillStats(){
		super.skillStats();
		System.out.println("Defense Bonus "+ defBonus);
		System.out.println();
	}
}