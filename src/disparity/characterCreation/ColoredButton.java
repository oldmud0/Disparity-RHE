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

	protected ColoredButton(String name, Boolean hasPNG) {
		this.name = name;
		this.setSize(width, height);
		setBorderPainted(false);
		setRolloverEnabled(true);
		setContentAreaFilled(false);
		if(hasPNG == true){
			setIcon(new ImageIcon(getClass().getResource("res/Buttons/"+name+"Normal.png")));
			setRolloverIcon(new ImageIcon(getClass().getResource("res/Buttons/"+name+"Roll.png")));
			setPressedIcon(new ImageIcon(getClass().getResource("res/Buttons/"+name+"Click.png")));
		}else{
		    try{
		        Image overlay = ImageIO.read(ColoredButton.class.getResourceAsStream("res/Buttons/buttonFormat.png"));
		        BufferedImage surface = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		        Graphics mix = surface.getGraphics();
		        mix.setColor(Color.red);
		        mix.drawRect(0, 0, width, height);
				mix.drawImage(overlay, 0, 0, null);
		        this.setIcon(new ImageIcon(surface));
		    }catch(IOException ex){
		        ex.printStackTrace();
		    }
		}
	}
	
	public ImageIcon getRoll(){
		//Image icon = new Image();
		return new ImageIcon();
	}
	
	public String getName(){
		return name;
	}
}
