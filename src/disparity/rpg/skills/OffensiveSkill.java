package disparity.rpg.skills;

import disparity.rpg.being.Being;

public class OffensiveSkill extends Skill{
	public OffensiveSkill() {
		super();
	}

	public int damBonus;

	@Override
	public void level(Being b){
		if(exp >= lvlXp)
			lvl++;
		damBonus = this.getBonus();
		addAbilities(b);
	}

	public int getBonus(){
		return lvl / 2;
	}

	@Override
	public void skillStats(){
		super.skillStats();
		System.out.println("Damage Bonus "+ damBonus);
		System.out.println();
	}
}