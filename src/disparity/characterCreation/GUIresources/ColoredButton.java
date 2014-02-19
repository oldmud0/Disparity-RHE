package disparity.characterCreation.GUIresources;

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
			URL fontUrl = getClass().getResource("../res/Fonts/aesymatt.ttf");
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

	protected ColoredButton(){
		new ColoredButton("undefined", Color.GRAY);
	}
	public Font aesymatt = createFont()
			.deriveFont(20f);
	public ColoredButton(String name, Color color) {
		this.name = name;
		setSize(Resources.width, Resources.height);
		setBorderPainted(false);
		setRolloverEnabled(true);
		setContentAreaFilled(false);
		
		setIcon(Resources.getImageIcon(color, false));
		setRolloverIcon(Resources.getImageIcon(color.darker(), false));
		setPressedIcon(Resources.getImageIcon(color, true));
		
		setFont(aesymatt);
		setForeground(new Color(255,255,255));
		setText(name);
		setHorizontalTextPosition(JButton.CENTER);
	}
	
	public String getName(){
		return name;
	}
}
