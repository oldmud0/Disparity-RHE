package disparity.rpg.races.player.elfin;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Dagger;
import disparity.rpg.races.Elfin;

public class Elf extends Elfin{
	String desc = "The elven people are either light or dark skinned, red eyed people who inhabit SOME PLACE WHERE ELVES LIVE. Their intellect and agility combined with their repect to nature makes them powerful wizards and archers.";
	public Elf(Being b){
		name = "Elf";
		b.wis += 2;
		b.tHP += 2;
		b.tMP -= 3;
		b.agi -= 2;
		b.wep = new Dagger(Quality.CRAP);
	}
}
