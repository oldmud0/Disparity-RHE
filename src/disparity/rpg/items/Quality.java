package disparity.rpg.items;

public enum Quality {
	CRAP			(-1),
	WOOD			(0),
	STONE			(1),
	IRON			(2),
	GOLD			(3),
	DIAMOND			(4),
	MIRTIS_SPAWN	(9001);	//Now lore friendly!
	
	/*
	 * When we declare a Quality above, we're actually instantiating a new Quality, 
	 * supplying the above number as val below.
	 * 
	 * We can say Quality.WOOD.getValue() as well.
	 */
	private int value; 
	private Quality(int val) {
		this.value = val;
	}
	
	public int getValue() {
		return value;
	}
	
}
