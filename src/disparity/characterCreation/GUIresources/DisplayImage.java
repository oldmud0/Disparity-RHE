package disparity.characterCreation.GUIresources;

import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DisplayImage implements ComponentListener {
	private JLabel title = new JLabel("");
	private String src;
	public DisplayImage(JLabel label, String src) {
		label.setText("");
		title = label;
		this.src = src;
	}
	@Override
	public void componentHidden(ComponentEvent e) {}
	@Override
	public void componentMoved(ComponentEvent e) {}
	@Override
	public void componentResized(ComponentEvent e) {setImage();}
	@Override
	public void componentShown(ComponentEvent e) {setImage();}
	private void setImage() {
		try {BufferedImage img = ImageIO.read(getClass().getResource(src));
			title.setIcon(new ImageIcon(img.getScaledInstance(title.getWidth(),-1,Image.SCALE_FAST)));
			title.setHorizontalAlignment(JLabel.CENTER);
		} catch (IOException e) { e.printStackTrace(); }
	}
}
	
