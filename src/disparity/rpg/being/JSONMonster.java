package disparity.rpg.being;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONTokener;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMonster{
	public static Monster readMonster(String monsterName){
		Monster monster = new Monster();
		try{
			JSONObject JSONFile = new JSONObject(new JSONTokener(new FileReader("src/disparity/rpg/JSONfiles/monsters.JSON")));
			//Create temp Var of Monster for reference
			JSONObject JSONMonster = (JSONObject) JSONFile.get(monsterName);
			//Create temp Var of Monster's Objects for reference
			JSONObject JSONHelm = (JSONObject) JSONMonster.get("helm");
			JSONObject JSONChest = (JSONObject) JSONMonster.get("chest");
			JSONObject JSONLegs = (JSONObject) JSONMonster.get("legs");
			JSONObject JSONBoots = (JSONObject) JSONMonster.get("boots");
			JSONObject JSONWep = (JSONObject) JSONMonster.get("wep");
			JSONArray JSONSkills = (JSONArray) JSONMonster.get("skills");
			//Assign Name
			monster.name = (String) JSONMonster.get("name");
			//Assign Armor Values
			monster.helm.name = (String) JSONHelm.getString("name");
			monster.helm.base_def = (int) JSONHelm.getInt("base_def");
			monster.chest.name = (String) JSONChest.getString("name");
			monster.chest.base_def = (int) JSONChest.getInt("base_def");
			monster.legs.name = (String) JSONLegs.getString("name");
			monster.legs.base_def = (int) JSONLegs.getInt("base_def");
			monster.boots.name = (String) JSONBoots.getString("name");
			monster.boots.base_def = (int) JSONBoots.getInt("base_def");
			//Assign Stats
			monster.str = (int) JSONMonster.getInt("str");
			monster.agi = (int) JSONMonster.getInt("agi");
			monster.wis = (int) JSONMonster.getInt("wis");
			monster.con = (int) JSONMonster.getInt("con");
			//Assign Skills
			for(int i=0;i>JSONSkills.length();i++){
				JSONObject skill = (JSONObject) (((JSONObject) JSONSkills.get(i))).get("skill");
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
			
			return monster;
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