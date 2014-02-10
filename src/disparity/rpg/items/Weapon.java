package disparity.rpg.items;

import disparity.rpg.being.Being;
import disparity.rpg.skills.Skill;
import disparity.rpg.items.weapons.*;

public class Weapon extends Equippable{
	public int baseDmg;
	public Weapon(String n, int baseDmgBonus){
		name = n;
		this.baseDmg += baseDmgBonus;
	}
	
	public Weapon(String n, Quality q) {
		name = q.getName() + " " + n;
		baseDmg += q.getValue();
	}
	
	public Weapon(){
		super();
	}
	
	public void giveName(String mat, String qDesc){
		name = mat + " " + name + " " + qDesc;

	}
	public void applySkill(){
		//Placeholder
	}
	//Get weapon skill
	public Skill getSkill(Being b){
		return new Skill();
	}
	
	public static Weapon getWeapon(String wep, String q){
		switch(wep.toUpperCase()){
			case "SHORTSWORD":
				return new Shortsword(Quality.valueOf(q));
			case "BROADSWORD":
				return new Broadsword(Quality.valueOf(q));
			case "DAGGER":
				return new Dagger(Quality.valueOf(q));
			case "WARHAMMER":
				return new Warhammer(Quality.valueOf(q));
			case "BATTLEAXE":
				return new Battleaxe(Quality.valueOf(q));
			default:
				Weapon w = new Weapon();
				w.name = wep;
				w.baseDmg = Integer.parseInt(q);
				return w;
				
		}
	}
	
}
