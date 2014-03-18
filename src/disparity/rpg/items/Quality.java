package disparity.rpg.items;

import java.util.Map;
import java.util.HashMap;

public enum Quality {
	//Armors
	/**
	 * Light Armors
	 * Will have lower AC bonus
	 * less other penalties
	 */
	CRAP			(-1,	"Crappy",			Type.LIGHT),
	WOOD			(0,		"Wooden",			Type.LIGHT),
	SILVER			(2,		"Silver",			Type.LIGHT),
	STEEL          (4,		"Steel",			Type.LIGHT),
	DIAMOND		(4,		"Diamond",			Type.LIGHT),
	/**
	 * Heavy Armors
	 * Will have higher AC bonus
	 * more other penalties
	 */
	HARD_WOOD		(0,		"Hard Wooden",		Type.HEAVY),
	STONE			(1,		"Stone",			Type.HEAVY),
	IRON			(2,		"Iron",				Type.HEAVY),
	GOLD			(3,		"Gold",				Type.HEAVY), /* GOLD IS NOT GOOD ARMOR IT WEIGHS LIKE 1 TON PER CUBIC FOOT */
	MIRTIS_SPAWN	(9001,	"Spawn of Mirtis",	Type.HEAVY);	//Now lore friendly!
	
	/**
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
	private Type type;
	
	/**
	 * Create a hashmap, then store all possible
	 * enum evaluations into it with corresponding
	 * String variables, then we can use the 
	 * stringToQuality(String qualityAsString) to
	 * return the Quality enum
	 */
	private static Map<String, Quality> qualityMap;
	static{
		qualityMap = new HashMap<String, Quality>();
		qualityMap.put("CRAP", Quality.CRAP);
		qualityMap.put("WOOD", Quality.WOOD);
		qualityMap.put("STONE", Quality.STONE);
		qualityMap.put("IRON", Quality.IRON);
		qualityMap.put("GOLD", Quality.GOLD);
		qualityMap.put("STEEL", Quality.STEEL);
		qualityMap.put("DIAMOND", Quality.DIAMOND);
		qualityMap.put("MIRTIS_SPAWN", Quality.MIRTIS_SPAWN);
	}
	
	/**
	 * Used for JSON being creation, allows
	 * us to retrieve a String quality and 
	 * get a enum Quality back
	 * @param qualityAsString
	 * @return
	 */
	public static Quality stringToQuality(String qualityAsString){
		return qualityMap.get(qualityAsString);
	}
	
	/**
	 * We are using Type type to tell what the
	 * weight of an equippable item is. @see Type
	 */
	private Quality(int value, String name, Type type) {
		this.value = value;
		this.name = name;
		this.type = type;
	}
	
	
	@Override
	public String toString() {
		return this.getName();
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Type getType(){
		return type;
	}
}
