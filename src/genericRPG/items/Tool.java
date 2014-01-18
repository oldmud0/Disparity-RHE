package genericRPG.items;

public class Tool extends Item{
	String quality;
	public Tool(String n, String qal){
		super(n, 1);
		quality = qal;
	}
}