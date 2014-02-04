package disparity.rpg.being;
import java.io.File;
import java.io.FileReader;
import org.json.JSONTokener;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMonster{
	public static Monster readMonster(String monsterName){
		File file = new File(monsterName + ".JSON");
		
		JSONArray monsters = new JSONArray(new JSONTokener(new FileReader("disparity/rpg/JSONfiles/monsters.JSON")));

		for(int i = 0; i < monsters.length(); i++){
			JSONObject m = monsters.getJSONObject(i);
			
			
		}
	}
}