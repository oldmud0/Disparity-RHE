public class Weapon extends Item{
	int hand;
	public Weapon(String n, int a, int h){
		super(n, a);
		hand = h;
	}
	public void giveName(String mat, String qDesc){
		mat + " " + name + " " + qDesc;

	}
	public applySkill(){
		//WILL USE LATER
	}
}

// Example of calling and naming a new Weapon-extending object:
// Shortsword s = new Shortsword(1, 3);
// s.giveName("Steel", "of Fire");
// NO spaces before or after material or descriptions