package disparity.game;

import java.util.HashMap;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Resources { 
	private static HashMap<String, Object> resourceMap = new HashMap<String, Object>();
	
	public static void loadResources() throws SlickException	{
		//addResource("typewriter", "res/typewriter.png");
		addResource("test_img", "res/test_img.png");
	}
	
	protected static Object getResource(String name) {
		try {
			return resourceMap.get(name);
		} catch (NullPointerException e) {
			System.out.println("ERROR: Could not obtain the file " + name + " from the resource map!");
			e.printStackTrace();
			return null;
		}
	}
	
	protected static void addResource(String name, String path) throws SlickException {
		resourceMap.put(name, new Image(path));
	}
}
