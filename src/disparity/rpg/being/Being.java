package disparity.rpg.being;

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
	private static final double DIVISOR = 2;
	
	/**
	 * --Being Object Variables--
	 */
	protected String name;
	protected Race race;

	/**
	 * Stat Variables
	 */
	protected int 
		str = 10, 
		agi = 10,
		dodgeBonus = agi,
		con = 10, 
		wis = 10, 
		hp, 
		mp,	
		tHP = (con / 2) + 10, 
		tMP = (wis / 2) + 10,
		lvl;
	protected double 
		dodge,
		ac;

	/**
	 * Skill Variables
	 */
	protected Archery arc;
	protected OneHanded oneHand;
	protected TwoHanded twoHand;
	protected Magic magic;
	protected Weapon wep;
	protected HeavyArmor hArmor;
	protected LightArmor lArmor;

	/**
	 * Armor Variables
	 */
	protected Helmet helm;
	protected Chestplate chest;
	protected Leggings legs;
	protected Boots boots;

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
		this.name = name;
		this.race = race;
		this.race.applyRacialStats(this);
		this.dodgeBonus = agi;
		this.hp = this.tHP;
		this.mp = this.tMP;
		this.lvl = 1;
		this.addSkills();
		this.dodge = calcDodge();
		this.ac = calcAC();
	}
	
	/**
	 * addSkills() takes the constructed
	 * Being and sets all of the Skill Objects
	 * to new Skills, and allows them to edit
	 * the Being Object
	 */
	private void addSkills(){
		this.arc = new Archery(this);
		this.oneHand = new OneHanded(this);
		this.twoHand = new TwoHanded(this);
		this.magic = new Magic(this);
		this.lArmor = new LightArmor();
		this.hArmor = new HeavyArmor();
	}

	/**
	 * Calculates the AC of a being, with it's
	 * given armor values.
	 */
	public double calcAC() {
		double armorAC = 0;
		if(this.helm != null){
			armorAC += (double)this.helm.getBonus();
		}
		if(this.chest != null){
			armorAC += (double)this.chest.getBonus();
		}
		if(this.legs != null){
			armorAC += (double)this.legs.getBonus();
		}
		if(this.boots != null){
			armorAC += (double)this.boots.getBonus();
		}
		armorAC /= DIVISOR;
		if(armorAC < 1){
			return (double)1;
		}
		return armorAC;
	}

	public int getAgi() {
		return agi;
	}
	
	/**
	 * Calculates the dodge of a being
	 * with it's given dodgeBonus
	 * @return
	 */
	public double calcDodge(){
		if(dodgeBonus / DIVISOR < 1){
			return 1;
		}
		return this.dodgeBonus / DIVISOR;
	}
	
	/**
	 * Arranges the stats of a Being into
	 * an easily read format, mainly
	 * used for debugging
	 * @return
	 */
	public String getFormStats() {
		return "--" + name + "--" + "\n" 
				+ "Race 		" + race.getName() + "\n"
				+ "Level 		" + lvl + "\n" 
				+ "-Defenses-" + "\n" 
				+ "HP 		" + hp + "/" + tHP + "\n" 
				+ "MP		" + mp + "/" + tMP + "\n" 
				+ "Dodge		" + dodge + "\n" 
				+ "AC		" + ac + "\n" 
				+ "-Stats-" + "\n" 
				+ "Strength 	"+ str + "\n" 
				+ "Agility 	" + agi + "\n" 
				+ "Wisdom 		" + wis + "\n"
				+ "Constitution 	" + con;
	}

	@Override
	public String toString() {
		return name;
	}
	
	/*   --Setters for Armor Objects-- */
	/** 
	 *	 @see resetArmorStats
	 *	 @see applyBonus
	 * 	 @see setArmorStats
	 */
	public void setHelm(Helmet helm) {
		this.resetArmorStats(this.helm);
		this.helm = helm;
		this.helm.applyBonus(this);
		this.setArmorStats(this.helm);
	}
	/** 
	 *	 @see resetArmorStats
	 *	 @see applyBonus
	 * 	 @see setArmorStats
	 */
	public void setChest(Chestplate chest) {
		this.resetArmorStats(this.chest);
		this.chest = chest;
		this.chest.applyBonus(this);
		this.setArmorStats(this.chest);
	}
	/** 
	 *	 @see resetArmorStats
	 *	 @see applyBonus
	 * 	 @see setArmorStats
	 */
	public void setLegs(Leggings legs) {
		this.resetArmorStats(this.legs);
		this.legs = legs;
		this.legs.applyBonus(this);
		this.setArmorStats(this.legs);
	}
	/** 
	 *	 @see resetArmorStats
	 *	 @see applyBonus
	 * 	 @see setArmorStats
	 */
	public void setBoots(Boots boots) {
		this.resetArmorStats(this.boots);
		this.boots = boots;
		this.boots.applyBonus(this);
		this.setArmorStats(this.boots);
	}	
	
	/**
	 * If @param armor != null this will reset all 
	 * Armor Stats back to what they
	 * would be without the original Armor Object
	 * Equipped
	 */
	private void resetArmorStats(Armor armor){
		if(armor != null){
			switch(armor.getQuality().getType()){
			case HEAVY:
				this.dodgeBonus -= this.getHeavyArmorAgiBonus();
				break;
			case MEDIUM:
				break;
			case LIGHT:
				this.dodgeBonus -= this.getLightArmorAgiBonus();
				break;
			}
			this.ac -= armor.getBonus();
			this.dodge = this.calcDodge();
		}
		return;
	}
	
	/**
	 * Recalculates ac with {@link #calcAC()}
	 * Then depending on the type of the @param armor,
	 * adds dodgeBonus, then calls {@link #calcDodge()}
	 */
	private void setArmorStats(Armor armor){
		this.ac = calcAC();
		switch(armor.getQuality().getType()){
			case HEAVY:
				this.dodgeBonus = this.dodgeBonus + this.getHeavyArmorAgiBonus();
				break;
			case MEDIUM:
				break;
			case LIGHT:
				this.dodgeBonus = this.dodgeBonus + this.getLightArmorAgiBonus();
				break;
		}
		this.ac = calcAC();
		this.dodge = calcDodge();
	}
	
	/**
	 * Miscellaneous GETTERS/SETTERS
	 */
	public void setAgi(int agi) {
		int agiOrg = this.agi;
		if(agi < 1){
			this.agi = 1;
		}
		this.agi = agi;
		this.dodgeBonus += agiOrg - this.agi;
	}
	
	public void setDodgeBonus(int dodgeBonus){
		if(dodgeBonus < 1){
			this.dodgeBonus = 1;
		}
		this.dodgeBonus = dodgeBonus;
	}
	
	public int getHeavyArmorBonus(){
		return this.hArmor.getBonus();
	}
	
	public int getHeavyArmorAgiBonus(){
		return this.hArmor.getAgiBonus();
	}
	
	public int getLightArmorBonus(){
		return this.lArmor.getBonus();
	}
	
	public int getLightArmorAgiBonus(){
		return this.lArmor.getAgiBonus();
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
		wep.applyBonus(this);
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

	public Chestplate getChest() {
		return chest;
	}

	public Leggings getLegs() {
		return legs;
	}

	public Boots getBoots() {
		return boots;
	}
	
	public int getDodgeBonus(){
		return this.dodgeBonus;
	}
}