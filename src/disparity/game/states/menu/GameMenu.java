package disparity.game.states.menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import disparity.game.Resources;
import disparity.game.states.StateID;

public class GameMenu extends BasicGameState {

	private Image test_img = Resources.getResource("test_img");
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		
	}


	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException{ 
			//g.drawImage(test_img, 0, 0);
			
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		
	}
	
	@Override
	public int getID() {
		
		return StateID.GAME_MENU.ordinal();
	}

}
