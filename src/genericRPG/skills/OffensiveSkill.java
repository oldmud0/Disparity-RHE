package genericRPG.skills;

import genericRPG.beingTypes.Being;

public class OffensiveSkill extends Skill{
	public int damBonus;

	public void level(Being b){
		if(exp >= lvlXp)
			lvl++;
		damBonus = this.getDamBonus();
		addAbilities(b);
	}

	public int getDamBonus(){
		return lvl / 2;
	}

	public void skillStats(){
		super.skillStats();
		System.out.println("Damage Bonus "+ damBonus);
		System.out.println();
	}
}