public class Shortsword extends Weapon{
	int base_dmg = 5;
	public Shortsword(int qnt,  int quality){
		super("Shortsword", qnt, 1, base_dmg);
		base_dmg += quality;
	}
}
