package disparity.characterCreation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ColoredButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private ImageIcon image;
	private final int width = 150, height = 50;

	protected ColoredButton(String name, Color color) {
		this.name = name;
		this.setSize(width, height);
		setBorderPainted(false);
		setRolloverEnabled(true);
		setContentAreaFilled(false);
		setIcon(getImageIcon(color, false));
		setRolloverIcon(getImageIcon(color.darker(), false));
		setPressedIcon(getImageIcon(color, true));
	}
	
	public ImageIcon getImageIcon(Color backColor, Boolean isPress){
		try {
			String f;
			if(isPress)
				f = "res/Buttons/buttonPressFormat.png";
			else
				f = "res/Buttons/buttonFormat.png";
			BufferedImage overlay = ImageIO.read(getClass().getResourceAsStream(f));
			BufferedImage surface = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics g = surface.getGraphics();
			g.setColor(backColor);
			g.fillRect(0, 0, width, height);
			g.drawImage((Image)overlay, 0, 0, null);
			return new ImageIcon(surface);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ImageIcon();
	}
	
	public String getName(){
		return name;
	}
}
