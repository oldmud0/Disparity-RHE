package disparity.rpg.skills;

import disparity.rpg.being.Being;

public class DefensiveSkill extends Skill{
	public DefensiveSkill() {
	}

	protected int bonus;
	protected int agiBonus;
	
	@Override
	public void level(Being b){
		if(exp >= lvlXp)
			lvl++;
		addAbilities(b);
	}

	public int getBonus(){
		return bonus;
	}

	@Override
	public void skillStats(){
		super.skillStats();
		System.out.println("Defense Bonus "+ bonus);
	}

	public int getAgiBonus() {
		return agiBonus;
	}

	public void setAgiBonus(int agiBonus) {
		this.agiBonus = agiBonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	
}