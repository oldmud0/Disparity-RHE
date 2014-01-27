package genericRPG.program;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import genericRPG.program.editor.RPGDevMainWindow;
import genericRPG.program.game.RPGGame;

public class Main {

	private static int windowX = 1024, windowY = 768;
	
	public static void main(final String[] args) {
		
		//Run the actual Slick2D game
		Thread graphicsWindow = new Thread(new Runnable() {
			
			public void run() {
				try {
					AppGameContainer appgc = new AppGameContainer(new RPGGame("RPG Game"));
					appgc.setDisplayMode(windowX, windowY, false);
					appgc.start();
				} catch (SlickException e) {
					Logger.getLogger(RPGGame.class.getName()).log(Level.SEVERE,
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

}
