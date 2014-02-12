package disparity.rpg.being;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import disparity.rpg.items.Equippable;
import disparity.rpg.items.Weapon;
import disparity.rpg.skills.defensiveSkills.HeavyArmor;
import disparity.rpg.skills.defensiveSkills.LightArmor;
import disparity.rpg.skills.offensiveSkills.Archery;
import disparity.rpg.skills.offensiveSkills.Magic;
import disparity.rpg.skills.offensiveSkills.OneHanded;
import disparity.rpg.skills.offensiveSkills.TwoHanded;

public class JSONMonster{
	
	public static Monster readMonster(String monsterName){
		Monster monster = new Monster();
		try {
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
			monster.helm.name = jsonHelm.getString("name");
			monster.helm.base_def = jsonHelm.getInt("base_def");
			setItemSkill(jsonHelm.getString("skill"), monster.helm);
			monster.chest.name = jsonChest.getString("name");
			monster.chest.base_def = jsonChest.getInt("base_def");
			setItemSkill(jsonChest.getString("skill"), monster.chest);
			monster.legs.name = jsonLegs.getString("name");
			monster.legs.base_def = jsonLegs.getInt("base_def");
			setItemSkill(jsonLegs.getString("skill"), monster.legs);
			monster.boots.name = jsonBoots.getString("name");
			monster.boots.base_def = jsonBoots.getInt("base_def");
			setItemSkill(jsonBoots.getString("skill"), monster.boots);
			//Assign Stats
			monster.str = jsonMonster.getInt("str");
			monster.agi = jsonMonster.getInt("agi");
			monster.wis = jsonMonster.getInt("wis");
			monster.con = jsonMonster.getInt("con");
			//Assign Skills
			for(int i=0;i>jsonSkills.length();i++){
				JSONObject skill = (JSONObject) (((JSONObject) jsonSkills.get(i))).get("skill");
				switch((String) skill.getString("name")){
					//Assign Offensive Skills
					case "oneHanded": monster.oneHand.lvl = skill.getInt("lvl"); continue;
					case "twoHanded": monster.twoHand.lvl = skill.getInt("lvl"); continue;
					case "arc": monster.arc.lvl = skill.getInt("lvl"); continue;
					case "magic": monster.magic.lvl = skill.getInt("lvl"); continue;
					//Assign Defensive Skills
					case "hArmor": monster.hArmor.lvl = skill.getInt("lvl"); continue;
					case "lArmor": monster.lArmor.lvl = skill.getInt("lvl"); continue;
					default: continue;
				}
			}
			String jsonWepName = jsonWep.getString("name");
			int jsonWepBaseDam = jsonWep.getInt("base_dam");
			String jsonWepQuality = jsonWep.getString("quality");
			monster.wep = Weapon.getWeapon(jsonWepName, jsonWepQuality, jsonWepBaseDam);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		monster.race.name = monster.name;
		//Normal Being calculations:
		monster.hp  = monster.tHP;
		monster.mp = monster.tMP;
		monster.dodge = monster.agi / 50.0;
		monster.lvl = 1;
		return monster;
	}
	
	public static void main(String[] args){
		Monster m = new Monster();
		m = readMonster("Goblin");
		System.out.println(m.wep.baseDmg);
	}
	
	static void setItemSkill(String s, Equippable i){
/*		try {
			Class skillClass = Class.forName(s);
			Constructor c = skillClass.getConstructor();
			
			i.setSkill((Skill) c.newInstance());
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | 
				InstantiationException | IllegalAccessException | IllegalArgumentException | 
				InvocationTargetException e) {
			e.printStackTrace();
		}
		For future use?
		*/
		
		
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