package disparity.rpg;

import disparity.rpg.being.JSONMonster;
import disparity.rpg.being.Monster;

public class Testing {
	public static void main(String[] args){
		Monster tanis = JSONMonster.readMonster("Gryphon");
		System.out.println(tanis.wep.name);
	}
}
