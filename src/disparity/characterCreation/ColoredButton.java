package disparity.characterCreation;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ColoredButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	protected ColoredButton(String normSrc, String rollSrc, String clickSrc, String name) {
		setBorderPainted(false);
		setContentAreaFilled(false);
		setIcon(new ImageIcon(getClass().getResource(normSrc)));
		setRolloverEnabled(true);
		setRolloverIcon(new ImageIcon(getClass().getResource(rollSrc)));
		setPressedIcon(new ImageIcon(getClass().getResource(clickSrc)));
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
