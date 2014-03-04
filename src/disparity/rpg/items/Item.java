package disparity.rpg.items;

public class Item{
	private String name;
	private String desc;
	
	/**
	 * Creates a new, generic item.
	 * @param Name
	 */
	public Item(String n){
		name = n;
	}
	/**
	 * Creates an empty Item with no name
	 */
	public Item(){
		
	}
	/**
	 * Sets Item name to given String
	 * @param n
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * Sets Item description to given String
	 * @param d
	 */
	public void setDesc(String desc){
		this.desc = desc;
	}
	public String getName(){
		return this.name;
	}
}