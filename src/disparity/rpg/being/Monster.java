package disparity.rpg.being;

import disparity.rpg.items.Weapon;
import disparity.rpg.items.armor.*;
import disparity.rpg.races.Race;
import disparity.rpg.skills.defensiveSkills.HeavyArmor;
import disparity.rpg.skills.defensiveSkills.LightArmor;
import disparity.rpg.skills.offensiveSkills.Archery;
import disparity.rpg.skills.offensiveSkills.Magic;
import disparity.rpg.skills.offensiveSkills.OneHanded;
import disparity.rpg.skills.offensiveSkills.TwoHanded;

public class Monster extends Being{
	
	protected Monster(){
		this.race = new Race();
		
		this.helm = new Helmet();
		this.chest = new Chestplate();
		this.legs = new Leggings();
		this.boots = new Boots();
		this.wep = new Weapon();
		
		this.arc = new Archery();
		this.oneHand = new OneHanded();
		this.twoHand = new TwoHanded();
		this.magic = new Magic();
		this.hArmor = new HeavyArmor();
		this.lArmor = new LightArmor();
	}
	
	public Monster(String name, Race race){
		super(name, race);
	}
}