package genericRPG.races;

import genericRPG.being.Being;
import genericRPG.items.weapons.Shortsword;

public class Human extends Race{

    public Human(Being b) {
    	name = "Human";
    	b.wep = new Shortsword(0);
    }
}