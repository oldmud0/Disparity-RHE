package genericRPG.beingTypes;

import java.util.HashMap;

import genericRPG.items.Weapon;
import genericRPG.races.Dwarf;
import genericRPG.races.Elf;
import genericRPG.races.Gnome;
import genericRPG.races.Gryphon;
import genericRPG.races.Human;
import genericRPG.races.Race;
import genericRPG.skills.Archery;
import genericRPG.skills.Magic;
import genericRPG.skills.OneHanded;
import genericRPG.skills.TwoHanded;

public abstract class Being{
	public String name;
	public Race race;
	public int str = 10, agi = 10, con = 10, wis = 10, hp, mp, tHP = (con/2) + 10, tMP = (wis/2) + 10, lvl;
	public double dodge, ac;
	public Archery arc;
	public OneHanded oneHand;
	public TwoHanded twoHand;
	public Magic magic;
	public Weapon wep;
	
	//Object Creator

	public Being(String n, String rce){
		name = n;
		race = getRace(rce, this);
		hp = tHP;
		mp = tMP;
		lvl = 1;
		arc = new Archery(this);
		oneHand = new OneHanded(this);
		twoHand = new TwoHanded(this);
		magic = new Magic(this);
		ac = 0;
		dodge = (double)(agi) / 100;
		}

	public Race getRace(String rce, Being b){
		switch(rce.toUpperCase()){
			case "ELF":
				return new Elf(b);
			case "DWARF":
				return new Dwarf(b);
			case "HUMAN":
				return new Human(b);
			case "GNOME":
				return new Gnome(b);
			case "GRYPHON":
				return new Gryphon((Monster)b); //Just a little hack until somebody tells me what I should do
			default:
				throw new IllegalArgumentException(rce + " is not a valid Race...");
		}
	}

	//DO NOT ERASE NEED FOR MONSTERS
	public Being(){
		
	}



	/**
	 * Summarizes the stats in a HashMap.
	 * @return HashMap<String, Object> list
	 */
	public HashMap<String, Object> getStats(){
		HashMap<String, Object> list = new HashMap<String, Object>();
		
		list.put("name", name);
		list.put("race", race.name);
		list.put("level", lvl);
		list.put("hp", hp);
		list.put("total_hp", tHP);
		list.put("mp", mp);
		list.put("total_mp", tMP);
		list.put("dodge", dodge);
		list.put("ac", ac);
		list.put("strength", str);
		list.put("agility", agi);
		list.put("constitution", con);
		list.put("wisdom", wis);
		
		return list;
		
	}
	
	public Object getStat(String ident) {
		if(!getStats().containsKey(ident)) return null;
		else return getStats().get(ident);
	}
	
	/**
	 * Sets a stat based on its string. Until all of the stats can be placed in a HashMap, this is the way to go.
	 * @param ident
	 * @param stat
	 */
	
	public void setStat(String ident, Object stat) throws Exception {
		if(!getStats().containsKey(ident)) return;
		else
			switch(ident) {
			case "name": name=stat.toString(); break;
			case "race": race=(Race)stat; break;
			case "level": lvl=Integer.valueOf( (String)stat ); break; //You could actually do (int)stat, but that's only for Java 7.
			case "hp": hp=Integer.valueOf( (String)stat ); break;
			case "total_hp": tHP=Integer.valueOf( (String)stat ); break;
			case "mp": mp=Integer.valueOf( (String)stat ); break;
			case "total_mp": tMP=Integer.valueOf( (String)stat ); break;
			case "dodge": dodge=Double.valueOf( (String)stat ); break;
			case "ac": ac=Double.valueOf( (String)stat ); break;
			case "strength": str=Integer.valueOf( (String)stat ); break;
			case "agility": agi=Integer.valueOf( (String)stat ); break;
			case "constitution": con=Integer.valueOf( (String)stat ); break;
			case "wisdom": wis=Integer.valueOf( (String)stat ); break;
			}
	}
	
	/**
	 * Returns all valid stat fields and their friendly names.
	 * @return HashMap<String, Object> list
	 */
	public static HashMap<String, String> getStatFields() {
		HashMap<String, String> list = new HashMap<String, String>();
		
		list.put("name", "name");
		list.put("level", "level");
		list.put("hp", "health");
		list.put("total_hp", "max health");
		list.put("mp", "magic points");
		list.put("total_mp", "max magic points");
		list.put("dodge", "dodge");
		list.put("ac", "AC");
		list.put("strength", "strength");
		list.put("agility", "agility");
		list.put("constitution", "constitution");
		list.put("wisdom", "wisdom");
		
		return list;
	}
	
	public String printStats() {
		return "--"+name+"--" + "\n" +
		"Race " + race.name + "\n" +
		"Level " + lvl + "\n" +
		"---" + "\n" +
		"HP " + hp + "/" + tHP + "\n" +
		"MP " + mp + "/" + tMP + "\n" +
		"Dodge " + dodge + "\n" +
		"AC " + ac + "\n" +
		"---" + "\n" +
		"Strength " + str + "\n" +
		"Agility " + agi + "\n" +
		"Constitution " + con + "\n" +
		"Wisdom " + wis;
	}
	
	public String toString() {
		return name;
	}

	//LEVELING

	/**
	 * Summarizes all skills in a HashMap.
	 * @return HashMap<String, Object> list
	 */
	public HashMap<String, Object> getAllSkills() {
		HashMap<String, Object> list = new HashMap<String, Object>();
		
		list.put(arc.name,arc.lvl);
		list.put(oneHand.name,oneHand.lvl);
		list.put(twoHand.name,twoHand.lvl);
		list.put(magic.name,magic.lvl);
		
		return list;
	}
	
	public void printAllSkills(){
		System.out.println(arc.name + " " + arc.lvl);
		System.out.println(oneHand.name + " " + oneHand.lvl);
		System.out.println(twoHand.name + " " + twoHand.lvl);
		System.out.println(magic.name + " " + magic.lvl);
	}
}