package disparity.program;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import disparity.program.editor.RPGDevMainWindow;
import disparity.program.game.DisparityGame;

public class Main {

	private static int windowX = 640, windowY = 480;
	
	public static void main(final String[] args) {
		
		//Run the actual Slick2D game
		Thread graphicsWindow = new Thread(new Runnable() {
			
			public void run() {
				try {
					AppGameContainer appgc = new AppGameContainer(new DisparityGame("RPG Game"));
					appgc.setDisplayMode(windowX, windowY, false);
					appgc.setVSync(true);
					appgc.start();
				} catch (SlickException e) {
					Logger.getLogger(DisparityGame.class.getName()).log(Level.SEVERE,
							"An error has occurred.", e);
				}
			}
			
		});
		graphicsWindow.start();
		
		//Open the editor window
		Thread editorWindow = new Thread(new Runnable() {
			
			public void run() {
				RPGDevMainWindow.run(args);
			}
			
		});
		editorWindow.start();


	}
	
	/*public static void main(String[] args){
		Character tanis = new Character("Tanis", "Gnome");
		System.out.println(tanis.printStats());
	}*/

}
