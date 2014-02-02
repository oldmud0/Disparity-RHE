package disparity.rpg.races;

import disparity.rpg.being.Being;
import disparity.rpg.items.weapons.Shortsword;

public class Human extends Race{

    public Human(Being b) {
    	name = "Human";
    	b.wep = new Shortsword(0);
    }
}