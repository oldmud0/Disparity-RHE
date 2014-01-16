public class Magic extends Skill{
	public int damBonus;
	public Magic(Being b){
		name = "One Handed";
		lvl = 5;
		exp = 0;
		lvlXp = 20;
		desc = "Skill that governors all abilities in magic.";
		damBonus = this.getDamBonus();
		addAbilities(b);
	}

	public int getDamBonus(){
		return lvl/2;
	}

	public void level(Being b){
		if(exp >= lvlXp)
			lvl++;
		damBonus = this.getDamBonus();
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

	public void skillStats(){
		super.skillStats();
		System.out.println("Damage Bonus "+ damBonus);
		System.out.println();
	}
}