package disparity.game.objects;

import java.awt.Font;
import java.util.PriorityQueue;
import java.util.Queue;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class TypewriterTextBox {

	private Image drawBuffer;
	private Font fnt = new Font("Monospaced", Font.PLAIN, 12);
	private TrueTypeFont typeWriterFont = new TrueTypeFont(fnt, false);
	
	private Queue<TypewriterText> textQueue = new PriorityQueue<TypewriterText>();
	private TypewriterText currentText;
	private String writtenText;
	private int textLength, curText = 1;
	
	public int x = 200, y = 100;
	
	public TypewriterTextBox(Queue<TypewriterText> textQueue) {
		try {
			drawBuffer = new Image(200, 100);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.textQueue = textQueue;
		nextText();
	}

	/**
	 * Renders the typewriter panel and text.
	 * Example: 
	 * 		textBox.render(textBox.getGraphics());
			g.drawImage(textBox.getDrawBuffer(), textBox.x, textBox.y);
	 * This would be declared in the game's render function.
	 * 
	 * @param g - Graphics buffer to draw on
	 */
	public void render(Graphics g) {
		g.setLineWidth(5);
		g.setColor(Color.white);
		g.drawRoundRect(10, 500, 200, 100, 5); //starts at (10,500), 200 wide, 100 high
		g.resetLineWidth();
		
		g.setFont(typeWriterFont);
		g.drawString(writtenText.substring(0, 3), 16, 520);
		g.resetFont();
	}
	
	public Image getDrawBuffer() {
		return drawBuffer;
	}
	
	public Graphics getGraphics() {
		try {
			return drawBuffer.getGraphics();
		} catch (SlickException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Reveals a number of characters.
	 * @param numTick - amount of characters to reveal
	 */
	public void tick(int numTick) {
		curText += numTick;
		if(curText > textLength) curText = textLength;
	}
	
	
	/**
	 * Reveals a single character.
	 */
	public void tick() {
		tick(1);
	}
	
	/**
	 * Reveals all the characters, in case the player wants to skip.
	 */
	public void revealAll() {
		
	}
	
	/**
	 * Pops the next piece of text from the stack. If none, do nothing.
	 */
	public void nextText() {
		if(textQueue.peek() == null) return;
		currentText = textQueue.remove();
		curText = 1;
		writtenText = currentText.getText();
		textLength = currentText.getText().length();
	}
	
	/**
	 * Kills the text box. This may occur at any time.
	 * Note that after the last TypewriterText, the text box will not kill itself.
	 */
	public void kill() {
		
	}
}
