package disparity.rpg.items;

public enum Quality {
	CRAP			(-1, "Crappy"),
	WOOD			(0, "Wooden"),
	STONE			(1, "Stone"),
	IRON			(2, "Iron"),
	GOLD			(3, "Gold"),
	DIAMOND			(4, "Diamond"),
	MIRTIS_SPAWN	(9001, "Spawn of Mirtis");	//Now lore friendly!
	
	/*
	 * When we declare a Quality above, we're actually instantiating a new Quality, 
	 * supplying the above number as val below.
	 * 
	 * We can say Quality.WOOD.getValue() as well.
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
