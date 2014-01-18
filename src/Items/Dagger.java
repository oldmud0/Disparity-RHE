public class Dagger extends Weapon{
	public Shortsword(int quality){
		super("Dagger", 1);
		base_dmg = 4 + quality;
	}
	//SKILL WEAPON DAMAGE BONUS 
	public OffensiveSkill getSWDB(Being b){
		return b.oneHand;
	}
}
