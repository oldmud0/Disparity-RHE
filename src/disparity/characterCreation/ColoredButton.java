package disparity.characterCreation;

import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.*;
import java.net.URL;

public class ColoredButton extends JButton {
	
	
	private Font createFont(){
		try {
			URL fontUrl = getClass().getResource("res/Fonts/aesymatt.ttf");
			Font mFont = Font.createFont(Font.PLAIN, fontUrl.openStream());
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(mFont);
			return mFont;
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static final long serialVersionUID = 1L;
	private String name;
	private final int width = 150, height = 50;

	protected ColoredButton(){
		new ColoredButton("undefined", Color.GRAY);
	}
	public Font aesymatt = createFont()
			.deriveFont(20f);
	protected ColoredButton(String name, Color color) {
		this.name = name;
		setSize(width, height);
		setBorderPainted(false);
		setRolloverEnabled(true);
		setContentAreaFilled(false);
		
		setIcon(getImageIcon(color, false));
		setRolloverIcon(getImageIcon(color.darker(), false));
		setPressedIcon(getImageIcon(color, true));
		
		setFont(aesymatt);
		setForeground(new Color(255,255,255));
		setText(name);
		setHorizontalTextPosition(JButton.CENTER);
	}
	
	public ImageIcon getImageIcon(Color backColor, Boolean isPress){
		try {
			String f;
			if(isPress)
				f = "res/Buttons/buttonFormatPress.png";
			else
				f = "res/Buttons/buttonFormat.png";
			BufferedImage overlay = ImageIO.read(getClass().getResource(f));
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
	
	public String getName(){
		return name;
	}
}
