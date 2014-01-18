public class Weapon extends Item{
	public int hand, base_dmg;
	public Weapon(String n, int h){
		super(n, 1);
		hand = h;
	}
	public void giveName(String mat, String qDesc){
		name = mat + " " + name + " " + qDesc;

	}
	public void applySkill(){
		//WILL USE LATER
	}
	//GET SKILL WEAPON DAMAGE BONUS
	public OffensiveSkill getSWDB(Being b){
		return new OffensiveSkill();
	}
}
