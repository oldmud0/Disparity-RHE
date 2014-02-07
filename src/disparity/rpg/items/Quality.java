package disparity.rpg.items;

public enum Quality {
	CRAP			(-1, "Crappy"),
	WOOD			(0, "Wooden"),
	STONE			(1, "Stone"),
	IRON			(2, "Iron"),
	GOLD			(3, "Gold"), /* GOLD IS NOT GOOD ARMOR IT WEIGHS LIKE 1 TON PER CUBIC FOOT */
	STEEL           (4, "Steel"),
	DIAMOND			(4, "Diamond"),
	MIRTIS_SPAWN	(9001, "Spawn of Mirtis");	//Now lore friendly!
	
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
	private Quality(int val, String n) {
		this.value = val;
		this.name = n;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
}
