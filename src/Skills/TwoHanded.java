public class TwoHanded extends OffensiveSkill{
	public TwoHanded(Being b){
		name = "Two Handed";
		lvl = 5;
		exp = 0;
		lvlXp = 20;
		desc = "Skill that is the basis of all physical Two handed attacks.";
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
}