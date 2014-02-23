package disparity.rpg.races;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import disparity.rpg.being.Being;
import disparity.rpg.races.player.HalfOrc;
import disparity.rpg.races.player.Human;
import disparity.rpg.races.player.Littling;
import disparity.rpg.races.player.Pech;
import disparity.rpg.races.player.elfin.Elf;
import disparity.rpg.races.player.elfin.Nymph;
import disparity.rpg.races.player.elfin.Sprite;

public class Race{
	public String name;
	protected static String desc = "Nobody knows about this race.";
	protected static Color raceColor = new Color(0,0,0);
	
	public static String getDesc(){
		return desc;
	}
	
	public static Color getColor(){
		return raceColor;
	}
	
	public static List<String> getAllRaces() {
		List<String> races = new ArrayList<String>();
		races.add("Human");
		races.add("Littling");
		races.add("Elf");
		races.add("Pech");
		races.add("Half Orc");
		races.add("Nymph");
		races.add("Sprite");
		
		return races;
	}
	
	public static List<String> getCharacterRacesDesc() {
		List<String> races = new ArrayList<String>();
		races.add(Human.getDesc());
		races.add(Littling.getDesc());
		races.add(Elf.getDesc());
		races.add(Pech.getDesc());
		races.add(HalfOrc.getDesc());
		races.add(Nymph.getDesc());
		races.add(Sprite.getDesc());
		
		return races;
	}
	
	public static List<Color> getAllRaceColors(){
		List<Color> colors = new ArrayList<Color>();
		colors.add(Human.getColor());
		colors.add(Littling.getColor());
		colors.add(Elf.getColor());
		colors.add(Pech.getColor());
		colors.add(HalfOrc.getColor());
		colors.add(Nymph.getColor());
		colors.add(Sprite.getColor());
		
		return colors;
	}
	
	public static Race getRace(String rce, Being b) {
		switch (rce.toUpperCase()) {
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
		//MONSTER AND CHARACTER RACES DEFINED IN SAID CLASSES
		default:
			throw new IllegalArgumentException(rce + " is not a valid Race...");
		}
		//return new Class.forName(rce);
	}
}