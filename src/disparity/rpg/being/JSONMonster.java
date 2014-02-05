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
			JSONObject JSONMonster = (JSONObject) JSONFile.get(monsterName); 
			JSONObject JSONHelm = (JSONObject) JSONMonster.get("helm");
			JSONObject JSONChest = (JSONObject) JSONMonster.get("chest");
			JSONObject JSONLegs = (JSONObject) JSONMonster.get("legs");
			JSONObject JSONBoots = (JSONObject) JSONMonster.get("boots");
			monster.name = (String) JSONMonster.get("name");
			//monster.chest.name = (St
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