package disparity.rpg;

import disparity.rpg.being.Character;
import disparity.rpg.races.player.elfin.*;
import disparity.rpg.races.player.*;
import disparity.rpg.items.Quality;
import disparity.rpg.items.Type;
import disparity.rpg.items.armor.*;

public class TestScript {
	public static void main(String[] arg) {
		Character tanis = new Character("Tanis", new HalfOrc(), Type.HEAVY);
		System.out.println(tanis.getFormStats());
	}
}
