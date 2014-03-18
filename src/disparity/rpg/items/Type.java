package disparity.rpg.items;

public enum Type {
	/**
	 * Used to determine what skill accompanies
	 * A piece of equipment
	 * light, medium, or heavy. For
	 * example, Iron armor is Heavy
	 * so if I call new Amor(Quality.IRON).getType();
	 * it will return Type.HEAVY
	 */
	//Armor
	HEAVY	("Heavy"),
	MEDIUM	("Medium"),
	LIGHT	("Light"),
	//Weapons
	ONE_HANDED 	("One Handed"),
	TWO_HANDED	("Two Handed"),
	ARCHERY		("Archery");
	
	private String name;
	
	private Type(String name){
		this.name = name;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
}
