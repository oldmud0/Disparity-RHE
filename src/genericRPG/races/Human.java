package genericRPG.races;

import genericRPG.beingTypes.Being;
import genericRPG.items.Shortsword;

public class Human extends Race{

    public Human(Being b) {
    	name = "Human";
    	b.wep = new Shortsword(0);
    }
}