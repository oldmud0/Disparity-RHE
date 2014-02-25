package disparity.characterCreation.GUIresources;

import java.awt.Color;

import javax.swing.JButton;

public class ColoredButton extends JButton {
	
	private static final long serialVersionUID = 1L;
	private String name;

	protected ColoredButton(){
		new ColoredButton("undefined", Color.GRAY);
	}
	public ColoredButton(String name, Color color) {
		this.setName(name);
		setSize(Resources.cbWidth, Resources.cbHeight);
		setBorderPainted(false);
		setRolloverEnabled(true);
		setContentAreaFilled(false);
		
		setIcon(Resources.getImageIcon(color, false, "coloredButton", Resources.cbWidth, Resources.cbHeight));
		setRolloverIcon(Resources.getImageIcon(color.darker(), false, "coloredButton", Resources.cbWidth, Resources.cbHeight));
		setPressedIcon(Resources.getImageIcon(color, true, "coloredButton", Resources.cbWidth, Resources.cbHeight));
		
		setFont(Resources.getFont());
		setForeground(new Color(255,255,255));
		setText(name);
		setHorizontalTextPosition(JButton.CENTER);
	}
}
