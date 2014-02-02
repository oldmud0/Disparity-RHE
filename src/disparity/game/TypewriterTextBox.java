package disparity.game;

import java.util.Stack;

import org.newdawn.slick.Graphics;

import disparity.game.objects.TypewriterText;

public class TypewriterTextBox {

	private Stack<TypewriterText> textStack = new Stack<TypewriterText>();
	
	public TypewriterTextBox() {
		
	}

	/**
	 * Renders the typewriter panel and text.
	 * @param g - Graphics buffer to draw on
	 */
	public void render(Graphics g) {
		
	}
	
	/**
	 * Reveals a number of characters.
	 * @param numTick - amount of characters to reveal
	 */
	public void tick(int numTick) {
		
	}
	
	/**
	 * Reveals a single character.
	 */
	public void tick() {
		
	}
	
	/**
	 * Reveals all the characters, in case the player wants to skip.
	 */
	public void revealAll() {
		
	}
}
