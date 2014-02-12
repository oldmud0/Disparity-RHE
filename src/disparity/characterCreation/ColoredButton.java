package disparity.characterCreation;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ColoredButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private ImageIcon image;

	protected ColoredButton(String name) {
		setBorderPainted(false);
		setContentAreaFilled(false);
		image = new ImageIcon(getClass().getResource("res/Buttons/"+name+"Normal.png"));
		setIcon(image);
		setRolloverEnabled(true);
		setRolloverIcon(new ImageIcon(getClass().getResource("res/Buttons/"+name+"Roll.png")));
		setPressedIcon(new ImageIcon(getClass().getResource("res/Buttons/"+name+"Click.png")));
		this.name = name;
	}
	
	public ImageIcon getRoll(){
		//Image icon = new Image();
		return new ImageIcon();
	}
	
	public String getName(){
		return name;
	}
}
