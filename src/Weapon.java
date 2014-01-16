public class Weapon extends Item{
	int dam;
	byte hand;
	public Weapon(String n, int a, int d, byte h){
		super(n, a);
		dam = d;
		hand = h;
	}
}