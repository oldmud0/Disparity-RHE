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
		setSize(Resources.width, Resources.height);
		setBorderPainted(false);
		setRolloverEnabled(true);
		setContentAreaFilled(false);
		
		setIcon(Resources.getImageIcon(color, false));
		setRolloverIcon(Resources.getImageIcon(color.darker(), false));
		setPressedIcon(Resources.getImageIcon(color, true));
		
		setFont(Resources.getFont());
		setForeground(new Color(255,255,255));
		setText(name);
		setHorizontalTextPosition(JButton.CENTER);
	}
}
