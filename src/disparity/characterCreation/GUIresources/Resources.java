package disparity.characterCreation.GUIresources;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Resources {
	private static Font createFont(){
		try {
			java.net.URL fontUrl = Resources.class.getResource("../res/Fonts/aesymatt.ttf");
			Font mFont = Font.createFont(Font.PLAIN, fontUrl.openStream());
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(mFont);
			return mFont;
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	private static Font aesymatt = createFont().deriveFont(20f);
	
	public static Font getFont(){
		return aesymatt;
	}
	public static final int width = 150, height = 50;
	
	public static ImageIcon getImageIcon(Color backColor, Boolean isPress){
		try {
			String f;
			if(isPress)
				f = "../res/Buttons/buttonFormatPress.png";
			else
				f = "../res/Buttons/buttonFormat.png";
			BufferedImage overlay = ImageIO.read(Resources.class.getResource(f));
			BufferedImage surface = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics g = surface.getGraphics();
			g.setColor(backColor);
			g.fillRect(0, 0, width, height);
			g.drawImage((Image)overlay, 0, 0, null);
			return new ImageIcon(surface);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ImageIcon();
	}
}
