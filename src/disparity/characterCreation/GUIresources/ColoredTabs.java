package disparity.characterCreation.GUIresources;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class ColoredTabs extends JTabbedPane {

	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		String[] races = {"Human", "Elf", "Hobbit"};
		Color[] colors = {Color.GREEN, Color.RED, new Color(200, 0, 200)};
		JComponent[] components = {new ColoredButton("Yes", Color.GREEN), new ColoredButton("No", Color.RED), new ColoredButton("Maybe", new Color(200, 0, 200))};
		frame.add(new ColoredTabs("Race Tabs", JTabbedPane.LEFT, races, colors, components));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ColoredTabs.class.getResource("/disparity/characterCreation/res/Backgrounds/DisparityICON.png")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Disparity");
		frame.setBounds(100, 100, 606, 479);
		frame.setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
	private String name;
	private final int width = 150, height = 50;
	public ColoredTabs(String paneName,  int tabPlacement, String[] names, Color[] colors, JComponent[] components){
		super(tabPlacement);
		this.name = paneName;
		if(names.length != components.length || names.length != colors.length || components.length != colors.length){
			throw new IllegalArgumentException("The arguments for COMPONENTS, COLORS, and NAMES do not match up for '"+this.name+"'...");
		}
		setFont(Resources.getFont());
		setBackground(Color.YELLOW);
		for(int i = 0; i < names.length; i++){
			addTab(names[i], components[i]);
			setBackgroundAt(i, colors[i]);
			
		}
	}
	
	
}
