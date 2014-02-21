package disparity.rpg.races;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import disparity.rpg.being.Being;
import disparity.rpg.races.player.HalfElfin;
import disparity.rpg.races.player.HalfOrc;
import disparity.rpg.races.player.Human;
import disparity.rpg.races.player.Littling;
import disparity.rpg.races.player.Pech;
import disparity.rpg.races.player.elfin.Elf;
import disparity.rpg.races.player.elfin.Nymph;
import disparity.rpg.races.player.elfin.Sprite;

public class Race{
	public String name;
	private static String desc = "Nobody knows about this race.";
	public Race(){
	}
	
	public static String getDesc(){
		return desc;
	}
	
	public static List<String> getAllRaces() {
		List<String> races = new ArrayList<String>();
		races.add("HUMAN");
		races.add("GRYPHON");
		races.add("GNOME");
		races.add("ELF");
		races.add("DWARF");
		
		return races;
	}
	
	public static Map<String, String> getCharacterRaces() {
		Map<String,String> races = new HashMap<String,String>();
		races.put("HUMAN",Human.getDesc());
		races.put("GNOME",Littling.getDesc());
		races.put("ELF",Elf.getDesc());
		races.put("PECH",Pech.getDesc());
		
		return races;
	}
	
	public static Race getRace(String rce, Being b) {
		switch (rce.toUpperCase()) {
		//case "ELF":
		//	return new Elf(b);
		case "PECH":
			return new Pech(b);
		case "HUMAN":
			return new Human(b);
		case "LITTLING":
			return new Littling(b);
		case "HALF ORC":
			return new HalfOrc(b);
		case "ELF":
			return new Elf(b);
		case "NYMPH":
			return new Nymph(b);
		case "SPRITE":
			return new Sprite(b);
		case "HALF ELF":
			return new HalfElfin(b, rce);
		case "HALF NYMPH":
			return new HalfElfin(b, rce);
		case "HALF SPRITE":
			return new HalfElfin(b, rce);
		//MONSTER AND CHARACTER RACES DEFINED IN SAID CLASSES
		default:
			throw new IllegalArgumentException(rce + " is not a valid Race...");
		}
		//return new Class.forName(rce);
	}
}