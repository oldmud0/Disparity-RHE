package disparity.rpg.being;

import disparity.rpg.items.Weapon;
import disparity.rpg.items.armor.*;
import disparity.rpg.skills.defensiveSkills.HeavyArmor;
import disparity.rpg.skills.defensiveSkills.LightArmor;
import disparity.rpg.skills.offensiveSkills.Archery;
import disparity.rpg.skills.offensiveSkills.Magic;
import disparity.rpg.skills.offensiveSkills.OneHanded;
import disparity.rpg.skills.offensiveSkills.TwoHanded;

public class Monster extends Being{
	public Monster(){
		helm = new Helmet();
		chest = new Chestplate();
		legs = new Leggings();
		boots = new Boots();
		wep = new Weapon();
		
		arc = new Archery();
		oneHand = new OneHanded();
		twoHand = new TwoHanded();
		magic = new Magic();
		hArmor = new HeavyArmor();
		lArmor = new LightArmor();
	}
}