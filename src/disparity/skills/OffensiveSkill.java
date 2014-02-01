package disparity.skills;

import disparity.being.Being;

public class OffensiveSkill extends Skill{
	public int damBonus;

	@Override
	public void level(Being b){
		if(exp >= lvlXp)
			lvl++;
		damBonus = this.getDamBonus();
		addAbilities(b);
	}

	public int getDamBonus(){
		return lvl / 2;
	}

	@Override
	public void skillStats(){
		super.skillStats();
		System.out.println("Damage Bonus "+ damBonus);
		System.out.println();
	}
}