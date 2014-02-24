package disparity.characterCreation.GUIresources;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainMenuButton extends JButton {
	private final int width = 50, height = 50;
	public MainMenuButton(){
		super("M");
		try {
			String f = "../res/Buttons/menuButton.png";
			BufferedImage overlay = ImageIO.read(Resources.class.getResource(f));
			BufferedImage surface = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics g = surface.getGraphics();
			g.fillRect(0, 0, width, height);
			g.drawImage((Image)overlay, 0, 0, null);
			setIcon(new ImageIcon(surface));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
