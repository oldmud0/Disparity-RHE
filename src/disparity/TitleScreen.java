package disparity;


public class TitleScreen extends MainScreen {


	import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

	import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Toolkit;

	public class Screens extends MainScreen{
		
		public JFrame frmDisparity;

		/**
		 * Initialize the contents of the Sc @wbp.parser.entryPoint
		 *reen1.
		 * @wbp.parser.entryPoint
		 */
		private void Title() {
			
			frmDisparity = new JFrame();
			frmDisparity.setIconImage(Toolkit.getDefaultToolkit().getImage(Screens.class.getResource("/disparity/characterCreation/res/Backgrounds/DisparityICON.png")));
			frmDisparity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmDisparity.setTitle("Disparity");
			frmDisparity.setBounds(100, 100, 606, 479);
			
			ColoredButton createButton = new ColoredButton("Create", Color.GREEN);
			ColoredButton exitButton = new ColoredButton("Exit", Color.RED);
			exitButton.setVerticalAlignment(SwingConstants.BOTTOM);
			ColoredButton[] buttons = {createButton, exitButton};
			
			ActionListener buttonListener = new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ColoredButton b = (ColoredButton)e.getSource();
					switch(b.getName()){
					case "Create":
						JOptionPane.showMessageDialog(null,  "Your name must be Grayson, in that case, I'll throw an exception.","Error",JOptionPane.ERROR_MESSAGE);
					case "Exit":
						System.exit(0);
						break;
					default:
						JOptionPane.showMessageDialog(null,  "Button event not found...","Error",JOptionPane.ERROR_MESSAGE);
						break;
					}
				}
				
			};
			

			
			for(ColoredButton c : buttons){
				c.addActionListener(buttonListener);
			}
			
			JLabel disparityLogoLabel =new JLabel("");
			disparityLogoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			ComponentListener disparityLogoListener = new DisparityTitle(disparityLogoLabel);
			disparityLogoLabel.addComponentListener(disparityLogoListener);
			
			GroupLayout groupLayout = new GroupLayout(frmDisparity.getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(106)
						.addComponent(disparityLogoLabel, GroupLayout.PREFERRED_SIZE, 387, Short.MAX_VALUE)
						.addGap(105))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(204)
						.addComponent(createButton, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addGap(203))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(204)
						.addComponent(exitButton, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
						.addGap(202))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(52)
						.addComponent(disparityLogoLabel, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
						.addGap(39)
						.addComponent(createButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(56))
			);
			frmDisparity.getContentPane().setLayout(groupLayout);
		}
		
		public void RaceSelectionScreen(){
			
		}
		
		private final class DisparityTitle implements ComponentListener {
			private JLabel title = new JLabel("");
			
			protected DisparityTitle(JLabel label) {
				label.setText("");
				title = label;
			}

			@Override
			public void componentHidden(ComponentEvent e) {
			}

			@Override
			public void componentMoved(ComponentEvent e) {
			}

			@Override
			public void componentResized(ComponentEvent e) {
				setImage();
			}

			@Override
			public void componentShown(ComponentEvent e) {
				setImage();
			}
			
			private void setImage() {
				try {
					BufferedImage img = ImageIO.read(getClass().getResource("res/Backgrounds/Title.png"));
					title.setIcon(
							new ImageIcon(
								img.getScaledInstance(
									title.getWidth(),
									-1,
									Image.SCALE_FAST
								)
							)	
					);
					title.setHorizontalAlignment(JLabel.CENTER);
				} catch (IOException e) { e.printStackTrace(); }
			}
			
		}
}
