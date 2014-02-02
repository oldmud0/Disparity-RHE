package disparity.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import disparity.game.states.intro.IntroScene;
import disparity.game.states.menu.*;

public class DisparityGame extends StateBasedGame {

	
	/**
	 * When we want to start the game, we want to make a new instance of this class.
	 * @param title - the window's title
	 */
	public DisparityGame(String title) {
		super(title);
	}
	

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new GameMenu());
		addState(new IntroScene());
		
		
	}

}
