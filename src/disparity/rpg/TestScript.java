package disparity.rpg;

import disparity.rpg.being.Character;
import disparity.rpg.races.player.elfin.*;
import disparity.rpg.races.player.*;

public class TestScript {
	public static void main(String[] arg){
		Character tanis = new Character("Tanis", new Littling());
		System.out.println(tanis.getFormStats());
	}
}
