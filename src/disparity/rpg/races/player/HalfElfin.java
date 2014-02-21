package disparity.rpg.races.player;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Dagger;
import disparity.rpg.races.Race;

public class HalfElfin extends Race{
	String desc = "To be replaced with an actual description";
	public HalfElfin(Being b, String rce){
		switch(rce.toUpperCase()){
		case "HALF ELF":
			name = "Half Elf";
			b.wis += 1;
			b.tHP += 1;
			b.tMP -= 2;
			b.agi -= 1;
			b.wep = new Dagger(Quality.CRAP);
			break;
		case "HALF NYMPH":
			name = "Half Nymph";
			b.con += 1;
			b.tHP += 1;
			b.tMP -= 2;
			b.agi -= 1;
			b.wep = new Dagger(Quality.CRAP);
			break;
		case "HALF SPRITE":
			name = "Half Sprite";
			b.agi += 1;
			b.tHP += 1;
			b.tMP -= 2;
			b.con -= 1;
			b.wep = new Dagger(Quality.CRAP);
			break;
		}
	}
}
