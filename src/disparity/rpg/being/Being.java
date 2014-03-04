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
import disparity.rpg.skills.defensiveSkills.HeavyArmor;
import disparity.rpg.skills.defensiveSkills.LightArmor;
import disparity.rpg.skills.offensiveSkills.Archery;
import disparity.rpg.skills.offensiveSkills.Magic;
import disparity.rpg.skills.offensiveSkills.OneHanded;
import disparity.rpg.skills.offensiveSkills.TwoHanded;

public abstract class Being {
	private String name;
	private Race race;

	/**
	 * Stat Variables
	 */
	private int 
		str = 10, 
		agi = 10, 
		con = 10, 
		wis = 10, 
		hp, 
		mp,	
		tHP = (con / 2) + 10, 
		tMP = (wis / 2) + 10,
		lvl;
	private double 
		dodge;

	/**
	 * Skill Variables
	 */
	private Archery arc;
	private OneHanded oneHand;
	private TwoHanded twoHand;
	private Magic magic;
	private Weapon wep;
	private HeavyArmor hArmor;
	private LightArmor lArmor;

	/**
	 * Armor Variables
	 */
	private Helmet helm;
	private Chestplate chest;
	private Leggings legs;
	private Boots boots;

	/**
	 * Being() no params allows
	 * for generic monster
	 * creation, do not delete
	 */
	public Being() {	
	}

	/**
	 * The main constructor for a Being
	 * this takes String name and Race race
	 * and applies them to a Being.
	 * @param name
	 * @param race
	 */
	public Being(String name, Race race) {
		this.setName(name);
		this.setRace(race);
		this.setHp(this.tHP);
		this.setMp(this.tMP);
		this.setLvl(1);
		this.addSkills();
		this.setDodge((double) (agi) / 50);
	}
	
	/**
	 * addSkills() takes the constructed
	 * Being and sets all of the Skill Objects
	 * to new Skills, and allows them to edit
	 * the Being Object
	 */
	private void addSkills(){
		this.setArc(new Archery(this));
		this.setOneHand(new OneHanded(this));
		this.setTwoHand(new TwoHanded(this));
		this.setMagic(new Magic(this));
	}

	/**
	 * Calculates the AC of a being, with it's
	 * given armor values. 
	 * TODO edit calcAC() so that there is a AC
	 * variables that is being edited. Maybe.
	 * @return
	 */
	public double calcAC() {
		if(helm != null && boots != null && chest != null && legs != null){
			double armorAC = boots.base_def + legs.base_def + chest.base_def
					+ helm.base_def;
			double skillBonus = boots.getSkill(this).getBonus() + legs.getSkill(this).getBonus()
					+ chest.getSkill(this).getBonus() + helm.getSkill(this).getBonus();;
			return (armorAC + skillBonus) / 50;
		}else{
			return 0;
		}
	}

	/**
	 * Summarizes the stats in a HashMap.
	 * 
	 * @return HashMap<String, Object> list
	 */
	public HashMap<String, Object> getStats() {
		HashMap<String, Object> list = new HashMap<String, Object>();

		list.put("name", name);
		list.put("race", race.getName());
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
		return "--" + name + "--" + "\n" + "Race " + race.getName() + "\n"
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getCon() {
		return con;
	}

	public void setCon(int con) {
		this.con = con;
	}

	public int getWis() {
		return wis;
	}

	public void setWis(int wis) {
		this.wis = wis;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int gettHP() {
		return tHP;
	}

	public void settHP(int tHP) {
		this.tHP = tHP;
	}

	public int gettMP() {
		return tMP;
	}

	public void settMP(int tMP) {
		this.tMP = tMP;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public double getDodge() {
		return dodge;
	}

	public void setDodge(double dodge) {
		this.dodge = dodge;
	}

	public Archery getArc() {
		return arc;
	}

	public void setArc(Archery arc) {
		this.arc = arc;
	}

	public OneHanded getOneHand() {
		return oneHand;
	}

	public void setOneHand(OneHanded oneHand) {
		this.oneHand = oneHand;
	}

	public TwoHanded getTwoHand() {
		return twoHand;
	}

	public void setTwoHand(TwoHanded twoHand) {
		this.twoHand = twoHand;
	}

	public Magic getMagic() {
		return magic;
	}

	public void setMagic(Magic magic) {
		this.magic = magic;
	}

	public Weapon getWep() {
		return wep;
	}

	public void setWep(Weapon wep) {
		this.wep = wep;
	}

	public HeavyArmor gethArmor() {
		return hArmor;
	}

	public void sethArmor(HeavyArmor hArmor) {
		this.hArmor = hArmor;
	}

	public LightArmor getlArmor() {
		return lArmor;
	}

	public void setlArmor(LightArmor lArmor) {
		this.lArmor = lArmor;
	}

	public Helmet getHelm() {
		return helm;
	}

	public void setHelm(Helmet helm) {
		this.helm = helm;
	}

	public Chestplate getChest() {
		return chest;
	}

	public void setChest(Chestplate chest) {
		this.chest = chest;
	}

	public Leggings getLegs() {
		return legs;
	}

	public void setLegs(Leggings legs) {
		this.legs = legs;
	}

	public Boots getBoots() {
		return boots;
	}

	public void setBoots(Boots boots) {
		this.boots = boots;
	}

	public void setAgi(int agi) {
		this.agi = agi;
	}
}