public class Skill{
	public String name;
	public double exp, lvlXp;
	public int lvl;
	public String desc;

	public void skillStats(){
		System.out.println("-"+name+"-");
		System.out.println(desc);
		System.out.println("Level " + lvl);
		System.out.println("Experience " + exp + "/"+lvlXp);
	}
}