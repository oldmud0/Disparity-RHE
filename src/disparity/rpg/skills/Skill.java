package disparity.rpg.skills;

import disparity.rpg.being.Being;
import disparity.rpg.items.Weapon;

public class Skill{
	public String name;
	public double exp, lvlXp;
	public int lvl;
	public String desc;

	public Skill() {}

	public void skillStats(){
		System.out.println("-"+name+"-");
		System.out.println(desc);
		System.out.println("Level " + lvl);
		System.out.println("Experience " + exp + "/"+lvlXp);
	}
	
	//ABILITIES

	public static byte doesHit(Being a, Weapon w, Being b){//Min + (int)(Math.random() * ((Max - Min) + 1)) 
		int i = 0;
		double max = 100.0;
		double min = w.baseDmg + w.getSkill(a).getBonus();
		if(min + Math.random() * ((max - min) + 1) <= b.calcAC())	i += 1; 		//checks to see if target blocked the attack [1 = block]
		else if(min + Math.random() * ((max - min) + 1) <= b.dodge)	i += 2; //checks to see if target dodged the attack [2 = dodge]
																			//if target does not block or dodge, attack hits [default = hit]
		switch(i){
			case 1:
				return 1; 
			case 2:
				return 2;
			default:
				return 0;
		}
	}

	public void level(Being b){
		if(exp >= lvlXp)
			lvl++;
		addAbilities(b);
	}

	public void addAbilities(Being b){
	}
	
	public int getBonus(){
		return 0;
	}
}