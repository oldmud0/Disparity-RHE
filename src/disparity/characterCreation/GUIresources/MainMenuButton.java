package disparity.characterCreation.GUIresources;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import disparity.characterCreation.screens.TitleScreen;

public class MainMenuButton extends JButton {
	private final int width = 50, height = 50;
	private JFrame container;
	public MainMenuButton(JFrame jframe){
		super("M");
		this.container = jframe;
		setFont(Resources.getFont());
		setForeground(new Color(255,255,255));
		setBorderPainted(false);
		setRolloverEnabled(true);
		setContentAreaFilled(false);
		setHorizontalTextPosition(JButton.CENTER);
		setIcon(Resources.getImageIcon(Color.BLUE, false, "smallColoredButton", Resources.smallSize, Resources.smallSize));
		setRolloverIcon(Resources.getImageIcon(Color.BLUE.darker(), false, "smallColoredButton", Resources.smallSize, Resources.smallSize));
		setPressedIcon(Resources.getImageIcon(Color.BLUE, true, "smallColoredButton", Resources.smallSize, Resources.smallSize));
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				container.setContentPane(new TitleScreen(container));
				container.revalidate();
		}});			
	}
}
