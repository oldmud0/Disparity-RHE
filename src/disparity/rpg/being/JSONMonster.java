package disparity.rpg.being;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONTokener;
import org.json.JSONArray;
import org.json.JSONObject;

import disparity.rpg.items.Weapon;

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
			monster.chest.name = (String) jsonChest.getString("name");
			monster.chest.base_def = (int) jsonChest.getInt("base_def");
			monster.legs.name = (String) jsonLegs.getString("name");
			monster.legs.base_def = (int) jsonLegs.getInt("base_def");
			monster.boots.name = (String) jsonBoots.getString("name");
			monster.boots.base_def = (int) jsonBoots.getInt("base_def");
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
			String jsonWepName = jsonWep.getString("name");
			
			if(jsonWep.getInt("base_dam") != 0){
				int jsonBaseDam = (int) jsonWep.getInt("base_dam");
				monster.wep = Weapon.getWeapon(jsonWepName, jsonBaseDam);
			}
			else{
				String jsonWepQuality = jsonWep.getString("SWDB");
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
}