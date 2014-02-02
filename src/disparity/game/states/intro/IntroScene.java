package disparity.game.states.intro;

import java.util.Stack;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import disparity.game.objects.TypewriterTextBox;

public class IntroScene extends BasicGameState {
	
	//Unlike a simple stack that holds TypewriterText, we can actually show a text box, 
	//then after that shows, we can do an animation, then show another text box.
	private Stack<TypewriterTextBox> textBoxStack = new Stack<TypewriterTextBox>(); 

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		
	}

	@Override
	public int getID() {
		return 0;
	}

}
