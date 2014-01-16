public class Archery extends Skill{
	public int damBonus;
	public Archery(Being b){
		name = "Archery";
		lvl = 5;
		exp = 0;
		lvlXp = 20;
		desc = "Skill that is the basis of all physical ranged attacks.";
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
				System.out.println("Does not have any skills to add...");
				break;
		}
	}

	public void skillStats(){
		super.skillStats();
		System.out.println("Damage Bonus "+ damBonus);
		System.out.println();
	}
}