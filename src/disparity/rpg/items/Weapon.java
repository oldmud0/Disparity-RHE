package disparity.rpg.items;

public class Weapon extends Equippable{
	protected Type type;
	/**
	 * Creates generic Weapon using Quality as a damage modifier
	 * Sets name and damage to be consistent with Quality
	 * @param name
	 * @param quality
	 */
	protected Weapon(String name, Quality qal, Type type, int baseDamage) {
		this.name = quality.getName() + " " + name;
		this.bonus = qal.getValue() + baseDamage;
		this.type = type;
	}

	/**
	 * Creates an empty Weapon
	 * @See disparity.rpg.being.Monster.Monster
	 */
	public Weapon(){
		super();
	}
	
	public Type getType(){
		return this.type;
	}
}