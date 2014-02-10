package disparity.rpg.being;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONTokener;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import disparity.rpg.items.Weapon;
import disparity.rpg.skills.defensiveSkills.*;
import disparity.rpg.skills.offensiveSkills.*;
import disparity.rpg.items.Equippable;

public class JSONMonster{
	public static Monster readMonster(String monsterName){
		Monster monster = new Monster();
		try{
			JSONObject jsonFile = new JSONObject(new JSONTokener(new FileReader("src/disparity/rpg/JSONfiles/monsters.JSON")));
			//Create temp Var of Monster for reference
			JSONObject jsonMonster = (JSONObject) jsonFile.get(monsterName);
			//Create temp Var of Monster's Objects for reference
			JSONObject jsonHelm = (JSONObject) jsonMonster.get("helm");
			JSONObject jsonChest = (JSONObject) jsonMonster.get("chest");
			JSONObject jsonLegs = (JSONObject) jsonMonster.get("legs");
			JSONObject jsonBoots = (JSONObject) jsonMonster.get("boots");
			JSONObject jsonWep = (JSONObject) jsonMonster.get("wep");
			JSONArray jsonSkills = (JSONArray) jsonMonster.get("skills");
			//Assign Name
			monster.name = (String) jsonMonster.get("name");
			//Assign Armor Values
			monster.helm.name = (String) jsonHelm.getString("name");
			monster.helm.base_def = (int) jsonHelm.getInt("base_def");
			setItemSkill(jsonHelm.getString("skill"), monster.helm);
			monster.chest.name = (String) jsonChest.getString("name");
			monster.chest.base_def = (int) jsonChest.getInt("base_def");
			setItemSkill(jsonChest.getString("skill"), monster.chest);
			monster.legs.name = (String) jsonLegs.getString("name");
			monster.legs.base_def = (int) jsonLegs.getInt("base_def");
			setItemSkill(jsonLegs.getString("skill"), monster.legs);
			monster.boots.name = (String) jsonBoots.getString("name");
			monster.boots.base_def = (int) jsonBoots.getInt("base_def");
			setItemSkill(jsonBoots.getString("skill"), monster.boots);
			//Assign Stats
			monster.str = (int) jsonMonster.getInt("str");
			monster.agi = (int) jsonMonster.getInt("agi");
			monster.wis = (int) jsonMonster.getInt("wis");
			monster.con = (int) jsonMonster.getInt("con");
			//Assign Skills
			for(int i=0;i>jsonSkills.length();i++){
				JSONObject skill = (JSONObject) (((JSONObject) jsonSkills.get(i))).get("skill");
				switch((String) skill.getString("name")){
					//Assign Offensive Skills
					case "oneHanded": monster.oneHand.lvl = (int) skill.get("lvl"); continue;
					case "twoHanded": monster.twoHand.lvl = (int) skill.get("lvl"); continue;
					case "arc": monster.arc.lvl = (int) skill.get("lvl"); continue;
					case "magic": monster.magic.lvl = (int) skill.getInt("lvl"); continue;
					//Assign Defensive Skills
					case "hArmor": monster.hArmor.lvl = (int) skill.get("lvl"); continue;
					case "lArmor": monster.lArmor.lvl = (int) skill.get("lvl"); continue;
					default: continue;
				}
			}
			String jsonWepName = (String) jsonWep.getString("name");
			int base_dam;
					try{
						base_dam = jsonWep.getInt("base_dam");
					}catch(JSONException j){
						int jsonBaseDam = (int) jsonWep.getInt("base_dam");
						monster.wep = Weapon.getWeapon(jsonWepName, Integer.toString(jsonBaseDam));
					} finally {
						String jsonWepQuality = jsonWep.getString("skill");
						monster.wep = Weapon.getWeapon(jsonWepName, jsonWepQuality);
						return monster;
					}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return monster;
	}
	
	public static void main(String[] args){
		Monster m = new Monster();
		m = readMonster("Gryphon");
		System.out.println(m.helm.name);
	}
	
	static void setItemSkill(String s, Equippable i){
		switch(s.toUpperCase()){
		case "LARMOR":
			i.setSkill(new LightArmor());
			break;
		case "HARMOR":
			i.setSkill(new HeavyArmor());
			break;
		case "ARCHERY":
			i.setSkill(new Archery());
			break;
		case "ONEHANDED":
			i.setSkill(new OneHanded());
			break;
		case "TWOHANDED":
			i.setSkill(new TwoHanded());
			break;
		case "MAGIC":
			i.setSkill(new Magic());
			break;
		}
	}
	
}