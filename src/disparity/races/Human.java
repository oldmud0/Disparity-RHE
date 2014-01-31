package disparity.races;

import disparity.being.Being;
import disparity.items.weapons.Shortsword;

public class Human extends Race{

    public Human(Being b) {
    	name = "Human";
    	b.wep = new Shortsword(0);
    }
}