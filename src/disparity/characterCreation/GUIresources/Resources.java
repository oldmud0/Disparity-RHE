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
	
	
	public static int smallSize = 50, cbHeight = 50, cbWidth = 150;
	
	public static ImageIcon getImageIcon(Color backColor, Boolean isPress, String whatButton, int w, int h){
		try {
			String f;
			if(!isPress)
				f = "../res/Buttons/" + whatButton + ".png";
			else
				f = "../res/Buttons/" + whatButton + "Press.png";
			BufferedImage overlay = ImageIO.read(Resources.class.getResource(f));
			BufferedImage surface = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			Graphics g = surface.getGraphics();
			g.setColor(backColor);
			g.fillRect(0, 0, w, h);
			g.drawImage((Image)overlay, 0, 0, null);
			return new ImageIcon(surface);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ImageIcon();
	}
	//adapted from 'http://stackoverflow.com/questions/4212675/wrap-the-string-after-a-number-of-character-word-wise-in-java'
	public static String addEndl(String st){
		StringBuilder s = new StringBuilder(st);
		int i = 0;
		while (i + 25 < s.length() && (i = s.lastIndexOf(" ", i + 25)) != -1) {
		    s.replace(i, i + 1, "\n");
		}
		return s.toString();
	}
} 
