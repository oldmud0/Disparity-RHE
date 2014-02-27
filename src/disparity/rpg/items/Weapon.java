package disparity.rpg.items;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import disparity.rpg.being.Being;
import disparity.rpg.skills.Skill;
import disparity.rpg.items.weapons.*;

public class Weapon extends Equippable{
	public int baseDmg;
	public Weapon(String n, int baseDmgBonus){
		name = n;
		this.baseDmg += baseDmgBonus;
	}
	
	public static List<String> getWeaponDesc() {
		List<String> desc = new ArrayList<String>();
		desc.add(Dagger.getDesc());
		desc.add(Shortsword.getDesc());
		desc.add(Broadsword.getDesc());
		desc.add(Battleaxe.getDesc());
		desc.add(Warhammer.getDesc());
		return desc;
	}
	public static List<String> getWeaponNames() {
		List<String> name = new ArrayList<String>();
		name.add(Dagger.getName());
		name.add(Shortsword.getName());
		name.add(Broadsword.getName());
		name.add(Battleaxe.getName());
		name.add(Warhammer.getName());
		return name;
	}
	public static List<Color> getWeaponColors() {
		List<Color> colors = new ArrayList<Color>();
		colors.add(Dagger.getColor());
		colors.add(Shortsword.getColor());
		colors.add(Broadsword.getColor());
		colors.add(Battleaxe.getColor());
		colors.add(Warhammer.getColor());
		return colors;
	}
	
	public static Color getColor(){
		return new Color(0,0,0);
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
	
	public static Weapon getWeapon(String wep, String q, int bdmg){
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
				if(q.equals("")){
					Weapon w = new Weapon();
					w.name = wep;
					w.baseDmg = bdmg;
					return w;
				}else{
					Weapon w = new Weapon();
					w.name = wep;
					w.baseDmg = (Quality.valueOf(q)).getValue() + bdmg;
					return w;
				}
		}
	}
}
