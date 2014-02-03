package disparity.rpg.being;

import java.io.*;
import org.json.JSONTokener;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONString;

public class JSONMonster{
	public Monster readMonster(String monsterName){
		File f = new File(monsterName + ".JSON");
		JSONArray a = (JSONArray) parser.parse(new FileReader(f));

		for(JSONObject m : a){
			JSONObject monster = (JSONObject) m;

			String name = (String) m.get("name");
			for(Object r : m.get("race")){
				String raceName = r.get("race");
			}
			int str = m.get("str");
			int agi = m.get("agi");
			int wis = m.get("wis");
			int con = m.get("con";)
			for(Object h : m.get("helm")){
				String helmName = h.get("name");
				int helmBaseDef = h.get("base_def");
			for(Object c : m.get("chest")){
				String chestName = c.get("name");
				int chestBaseDef = c.get("base_def");
			for(Object l : m.get("legs")){
				String legsName = m.get("name");
				int legsBaseDef = m.get
			}
						
			}
			}
			}
		}
	}
}