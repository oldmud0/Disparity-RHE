package disparity.rpg.items;

public class Item{
	protected String name;
	protected String desc;
	
	/**
	 * Creates a new, generic item.
	 * @param Name
	 */
	public Item(String name){
		this.name = name;
	}
	
	/**
	 * Creates an empty Item with no name
	 */
	protected Item(){	
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setDesc(String desc){
		this.desc = desc;
	}
	
	public String getDesc(){
		return this.desc;
	}
}