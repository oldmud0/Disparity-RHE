package disparity.rpg.skills;

import disparity.rpg.being.Being;
import disparity.rpg.items.Weapon;

public class Skill{
	protected String name;
	protected double exp, lvlXp;
	protected int lvl;
	protected String desc;

	public void skillStats(){
		System.out.println("-"+name+"-");
		System.out.println(desc);
		System.out.println("Level " + lvl);
		System.out.println("Experience " + exp + "/"+lvlXp);
	}

	public void level(Being b){
		if(exp >= lvlXp)
			lvl++;
		addAbilities(b);
	}

	public void addAbilities(Being b){
		//TODO implement
	}
	
	public int getBonus(){
		return 0;
	}
	
	protected final String getName() {
		return name;
	}

	protected final void setName(String name) {
		this.name = name;
	}

	protected final double getExp() {
		return exp;
	}

	protected final void setExp(double exp) {
		this.exp = exp;
	}

	protected final double getLvlXp() {
		return lvlXp;
	}

	protected final void setLvlXp(double lvlXp) {
		this.lvlXp = lvlXp;
	}

	protected final int getLvl() {
		return lvl;
	}

	public final void setLvl(int lvl) {
		this.lvl = lvl;
	}

	protected final String getDesc() {
		return desc;
	}

	protected final void setDesc(String desc) {
		this.desc = desc;
	}
}