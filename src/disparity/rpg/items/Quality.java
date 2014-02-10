package disparity.rpg.items;

public enum Quality {
	CRAP			(-1,	"Crappy",			0),
	WOOD			(0,		"Wooden",			1),
	STONE			(1,		"Stone",			2),
	IRON			(2,		"Iron",				3),
	GOLD			(3,		"Gold",				7), /* GOLD IS NOT GOOD ARMOR IT WEIGHS LIKE 1 TON PER CUBIC FOOT */
	STEEL           (4,		"Steel",			5),
	DIAMOND			(4,		"Diamond",			5),
	MIRTIS_SPAWN	(9001,	"Spawn of Mirtis",	3);	//Now lore friendly!
	
	/*
	 * When we declare a Quality above, we're actually instantiating a new Quality, 
	 * supplying the above number as val below.
	 * 
	 * We can say Quality.WOOD.getValue() as well.
	 * 
	 * A Quality.name is always the Prefix of a item, 
	 * whereas a magical effect is a Suffix
	 */
	private int value; 
	private String name;
	private int weight;
	private Quality(int value, String name, int weight) {
		this.value = value;
		this.name = name;
		this.weight = weight;
	}
	
	
	@Override
	public String toString() {
		return getName();
	}
	
	public int getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public int getWeight() {
		return weight;
	}
}
