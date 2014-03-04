package disparity.rpg.races.player;

import java.awt.Color;

import disparity.rpg.being.Being;
import disparity.rpg.items.Quality;
import disparity.rpg.items.weapons.Broadsword;
import disparity.rpg.races.Race;

public class HalfOrc extends Race{
	static String desc = "The offspirng of Orcs and Humans, Half Orcs are tall, powerful warriors, known for brute force and skill in meele combat. Although Half Orcs lack wisdom and intelligence, they compensate with their strength.";
	private static Color raceColor = new Color(120, 150, 125);
	public HalfOrc(Being b){
		b.setName("Half-Orc");
		b.setStr(b.getStr() + 2);
		b.setHp(b.getHp() + 2);
		b.setMp(b.getMp() + 3);
		b.setAgi(b.getAgi() + 2);
	}
	public static String getDesc(){
		return desc;
	}
	
	public static Color getColor(){
		return raceColor;
	}
}
