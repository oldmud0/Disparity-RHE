package disparity.rpg.being;

import disparity.rpg.items.Quality;
import disparity.rpg.items.armor.*;
import disparity.rpg.items.Type;
import disparity.rpg.races.Race;

public class Character extends Being{
	
	/**
	 * General Character Constructor
	 * @param name
	 * @param race
	 * @param armorType
	 */
	public Character(String name, Race race, Type armorType){
		super(name, race);
		this.setArmor(armorType);
	}
	
	/**
	 * Used to autoSet all of the armors for a generated character.
	 * NOTE: Do not use "this.boots = new Boots();", always call
	 * the "setBoots()", as it has logic 
	 * @param armorType
	 */
	private void setArmor(Type armorType){
		switch(armorType){
		case HEAVY:
			this.setBoots(new Boots(Quality.HARD_WOOD));
			this.setLegs(new Leggings(Quality.HARD_WOOD));
			this.setChest(new Chestplate(Quality.HARD_WOOD));
			this.setHelm(new Helmet(Quality.HARD_WOOD));
			break;
		case MEDIUM:
			break;
		case LIGHT:
			this.setBoots(new Boots(Quality.WOOD));
			this.setLegs(new Leggings(Quality.WOOD));
			this.setChest(new Chestplate(Quality.WOOD));
			this.setHelm(new Helmet(Quality.WOOD));
			break;
		}
	}
	
	/**
	 * Returns general Character Info
	 */
	@Override
	public String getFormStats(){
		return super.getFormStats() + "\n"
				+ "--Armor--" + "\n"
				+ this.helm.getName() + "	" + this.helm.getBonus() + "\n"
				+ this.chest.getName() + "	" + this.chest.getBonus() + "\n"
				+ this.legs.getName() + "	" + this.legs.getBonus() + "\n"
				+ this.boots.getName() + "	" + this.boots.getBonus();
	}
}