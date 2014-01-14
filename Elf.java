public class Elf extends Race{

    public Elf(being b) {
    	name = "Elf";
    	b.wis += 2;
    	b.tMP += 5;
    	b.tHP -= 2;
    }
    
    
}