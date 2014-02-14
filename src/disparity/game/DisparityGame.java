package disparity.game;

import java.io.FileNotFoundException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import disparity.game.states.StateID;
import disparity.game.states.intro.IntroScene;
import disparity.game.states.menu.GameMenu;

public class DisparityGame extends StateBasedGame {

	
	/**
	 * When we want to start the game, we want to make a new instance of this class.
	 * @param title - the window's title
	 */
	public DisparityGame(String title) {
		super(title);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws FileNotFoundException, SlickException {
		Resources.loadResources();
		getState(StateID.INTRO_SCENE.ordinal()).enter(gc, sbg);
	}
	
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new GameMenu());
		addState(new IntroScene());
	}

}
