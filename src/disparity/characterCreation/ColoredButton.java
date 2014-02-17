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
			URL fontUrl = getClass().getClassLoader().getResource("res/Fonts/aesysmatt.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
			return font;
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return font;
	}
	
	private static final long serialVersionUID = 1L;
	private String name;
	private final int width = 150, height = 50;

	protected ColoredButton(){
		new ColoredButton("undefined", Color.GRAY, 1);
	}
	public Font font;
	protected ColoredButton(String name, Color color, int resize) {
		name = name;
		setSize(width * resize, height * resize);
		setBorderPainted(false);
		setRolloverEnabled(true);
		setContentAreaFilled(false);
		setIcon(getImageIcon(color, false, resize));
		setRolloverIcon(getImageIcon(color.darker(), false, resize));
		setPressedIcon(getImageIcon(color, true, resize));
		font = createFont();
		setFont(font);
		setText(name);
		setHorizontalTextPosition(JButton.CENTER);
	}
	
	public ImageIcon getImageIcon(Color backColor, Boolean isPress, int resize){
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
			g.fillRect(0, 0, width * resize, height * resize);
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
