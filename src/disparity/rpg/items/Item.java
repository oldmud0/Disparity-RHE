package disparity.rpg.items;

public class Item{
	public String name;
	public int qnt;
	public String desc;
	Quality quality;
	
	/**
	 * Creates a new, generic item.
	 * @param Name
	 * @param Quantity
	 */
	public Item(String n, int a){
		name = n;
		qnt = a;
	}
	
	public Item(){
		
	}
}