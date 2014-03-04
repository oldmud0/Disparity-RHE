package disparity.rpg.items;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import disparity.rpg.being.Being;
import disparity.rpg.skills.Skill;
import disparity.rpg.items.weapons.*;

public class Weapon extends Equippable{
	private int baseDmg;
	/**
	 * Creates generic Weapon
	 * @param name
	 * @param baseDmgBonus
	 */
	public Weapon(String name, int baseDmgBonus){
		this.setName(name);
		this.setBaseDmg(this.getBaseDmg() + baseDmgBonus);
	}
	/**
	 * Creates generic Weapon using Quality as a damage modifier
	 * Sets name and damage to be consistent with Quality
	 * @param n
	 * @param q
	 */
	public Weapon(String name, Quality qal) {
		name = qal.getName() + " " + name;
		baseDmg += qal.getValue();
	}
	/**
	 * Creates an empty Weapon
	 */
	public Weapon(){
		super();
	}
	/**
	 * Reassigns name given material and Quality
	 * @param mat
	 * @param qDesc
	 */
	public void giveName(String mat, Quality qal){
		this.setName(mat + " " + this.getName() + " " + qal.getName());
	}
	/**
	 * Returns Weapon baseDmg
	 * @return
	 */
	public int getBaseDmg(){
		return this.baseDmg;
	}
	/**
	 * Sets Weapon baseDmg
	 * @param dmg
	 */
	public void setBaseDmg(int dmg){
		this.baseDmg = dmg;
	}
}

