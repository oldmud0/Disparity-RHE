package genericRPG.races;

import genericRPG.beingTypes.Being;
import genericRPG.items.Dagger;

public class Gnome extends Race{

    public Gnome(Being b) {
    	name = "Gnome";
    	b.agi += 2;
    	b.str += 1;
    	b.tHP -= 1;
    	b.wep = new Dagger(0);
    }
    
    
}