package disparity.rpg.being;

import java.util.HashMap;
import java.util.Map.Entry;

import disparity.rpg.items.Armor;
import disparity.rpg.items.Weapon;
import disparity.rpg.items.armor.Boots;
import disparity.rpg.items.armor.Chestplate;
import disparity.rpg.items.armor.Helmet;
import disparity.rpg.items.armor.Leggings;
import disparity.rpg.races.Race;
import disparity.rpg.races.player.Human;
import disparity.rpg.races.player.Littling;
import disparity.rpg.races.player.Pech;
import disparity.rpg.skills.defensiveSkills.HeavyArmor;
import disparity.rpg.skills.defensiveSkills.LightArmor;
import disparity.rpg.skills.offensiveSkills.Archery;
import disparity.rpg.skills.offensiveSkills.Magic;
import disparity.rpg.skills.offensiveSkills.OneHanded;
import disparity.rpg.skills.offensiveSkills.TwoHanded;

public abstract class Being {
	public String name;
	public Race race;

	// Stats
	public int str = 10, agi = 10, con = 10, wis = 10, hp, mp,
			tHP = (con / 2) + 10, tMP = (wis / 2) + 10, lvl;
	public double dodge;

	// Skills
	public Archery arc;
	public OneHanded oneHand;
	public TwoHanded twoHand;
	public Magic magic;
	public Weapon wep;
	public HeavyArmor hArmor;
	public LightArmor lArmor;

	// Armor
	public Helmet helm;
	public Chestplate chest;
	public Leggings legs;
	public Boots boots;

	// DO NOT ERASE NEED FOR MONSTERS
	public Being() {
		
	}

	//Object Creator
	public Being(String n, String rce) {
		name = n;
		race = getRace(rce, this);
		hp = tHP;
		mp = tMP;
		lvl = 1;
		arc = new Archery(this);
		oneHand = new OneHanded(this);
		twoHand = new TwoHanded(this);
		magic = new Magic(this);
		dodge = (double) (agi) / 50;
		helm = new Helmet(-1, lArmor);
		chest = new Chestplate(-1, lArmor);
		legs = new Leggings(-1, lArmor);
		boots = new Boots(-1, lArmor);
		agi += agiArmorChange();
	}
	
	public int agiArmorChange(){
		Armor[] body = {helm, chest, legs, boots};
		int h = 0, l = 0;
		for(Armor armor : body){
			if(armor.getSADB(this) instanceof LightArmor)
				l++;
			if(armor.getSADB(this) instanceof HeavyArmor)
				h++;
		}
		if(l == 4)
			return lArmor.agiChange;
		else if(h == 4)
			return hArmor.agiChange;
		return 0;
			
		
	}

	public Race getRace(String rce, Being b) {
		switch (rce.toUpperCase()) {
		//case "ELF":
		//	return new Elf(b);
		case "PECH":
			return new Pech(b);
		case "HUMAN":
			return new Human(b);
		case "LITTLING":
			return new Littling(b);
		//MONSTER AND CHARACTER RACES DEFINED IN SAID CLASSES
		default:
			throw new IllegalArgumentException(rce + " is not a valid Race...");
		}
		//return new Class.forName(rce);
	}

	public double calcAC() {
		double armorAC = boots.base_def + legs.base_def + chest.base_def
				+ helm.base_def;
		double skillBonus = this.getDefenseBonus();
		return (armorAC + skillBonus) / 50;
	}

	public double getDefenseBonus() {
		return boots.getSADB(this).defBonus + legs.getSADB(this).defBonus
				+ chest.getSADB(this).defBonus + helm.getSADB(this).defBonus;
	}

	/**
	 * Summarizes the stats in a HashMap.
	 * 
	 * @return HashMap<String, Object> list
	 */
	public HashMap<String, Object> getStats() {
		HashMap<String, Object> list = new HashMap<String, Object>();

		list.put("name", name);
		list.put("race", race.name);
		list.put("level", lvl);
		list.put("hp", hp);
		list.put("total_hp", tHP);
		list.put("mp", mp);
		list.put("total_mp", tMP);
		list.put("dodge", dodge);
		list.put("ac", calcAC());
		list.put("strength", str);
		list.put("agility", agi);
		list.put("constitution", con);
		list.put("wisdom", wis);

		return list;

	}

	public Object getStat(String ident) {
		if (!getStats().containsKey(ident))
			return null;
		else
			return getStats().get(ident);
	}

	/**
	 * Sets a stat based on its string. Until all of the stats can be placed in
	 * a HashMap, this is the way to go.
	 * 
	 * @param ident
	 * @param stat
	 */

	public void setStat(String ident, Object stat) throws Exception {
		if (!getStats().containsKey(ident))
			return;
		else
			switch (ident.toLowerCase()) {
			case "name":
				name = stat.toString();
				break;
			case "race":
				race = (Race) stat;
				break;
			case "level":
				lvl = Integer.valueOf((String) stat);
				break; // You could actually do (int)stat, but that's only for
						// Java 7.
			case "hp":
				hp = Integer.valueOf((String) stat);
				break;
			case "total_hp":
				tHP = Integer.valueOf((String) stat);
				break;
			case "mp":
				mp = Integer.valueOf((String) stat);
				break;
			case "total_mp":
				tMP = Integer.valueOf((String) stat);
				break;
			case "dodge":
				dodge = Double.valueOf((String) stat);
				break;
			case "strength":
				str = Integer.valueOf((String) stat);
				break;
			case "agility":
				agi = Integer.valueOf((String) stat);
				break;
			case "constitution":
				con = Integer.valueOf((String) stat);
				break;
			case "wisdom":
				wis = Integer.valueOf((String) stat);
				break;
			}
	}

	public int getAgi() {
		return agi;
	}

	/**
	 * Returns all valid stat fields and their friendly names.
	 * 
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
		return "--" + name + "--" + "\n" + "Race " + race.name + "\n"
				+ "Level " + lvl + "\n" + "---" + "\n" + "HP " + hp + "/" + tHP
				+ "\n" + "MP " + mp + "/" + tMP + "\n" + "Dodge " + dodge
				+ "\n" + "AC " + calcAC() + "\n" + "---" + "\n" + "Strength "
				+ str + "\n" + "Agility " + agi + "\n" + "Constitution " + con
				+ "\n" + "Wisdom " + wis;
	}

	@Override
	public String toString() {
		return name;
	}

	// LEVELING

	/**
	 * Summarizes all skills in a HashMap.
	 * 
	 * @return HashMap<String, Object> list
	 */
	public HashMap<String, Object> getAllSkills() {
		HashMap<String, Object> list = new HashMap<String, Object>();

		list.put(arc.name, arc.lvl);
		list.put(oneHand.name, oneHand.lvl);
		list.put(twoHand.name, twoHand.lvl);
		list.put(magic.name, magic.lvl);
		list.put(lArmor.name, lArmor.lvl);
		list.put(hArmor.name, hArmor.lvl);

		return list;
	}

	
	public String printAllSkills() {
		String out = "";
		
		for(Entry<String, Object> skill : getAllSkills().entrySet()) {
			out += skill.getKey() + "-" + skill.getValue() + "\n";
		}
		
		return out; 
	}
}