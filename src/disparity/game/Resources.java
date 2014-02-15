package disparity.game;

import java.util.HashMap;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Resources { 
	private static HashMap<String, Object> resourceMap = new HashMap<String, Object>();
	
	public static void loadResources() throws SlickException	{
		//addResource("typewriter", "res/typewriter.png");
		addResource("test_img", new Image("src/disparity/game/res/test_img.png"));
		
	}
	
	@SuppressWarnings("unchecked") //I tend not to suppress warnings, but there's really no practical solution to check the cast.
	public static <T> T getResource(String name) {
		try {
			return (T) resourceMap.get(name);
		} catch (NullPointerException e) {
			System.out.println("ERROR: Could not obtain the file " + name + " from the resource map!");
			e.printStackTrace();
			return null;
		} catch (ClassCastException e) {
			System.out.println("ERROR: couldn't cast from Object!");
			e.printStackTrace();
			return null;
		}
	}
	
	public static void addResource(String name, Object content) throws SlickException {
		resourceMap.put(name, content);
	}
}
