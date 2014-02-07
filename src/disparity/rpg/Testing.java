package disparity.rpg;

import disparity.rpg.items.Quality;
import disparity.rpg.items.armor.*;
import disparity.rpg.skills.defensiveSkills.*;

public class Testing {
	public static void main(String[] args){
		Chestplate chest = new Chestplate(Quality.MIRTIS_SPAWN, new LightArmor());
		System.out.println(chest.name);
	}
}
