package disparity.characterCreation.screens;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import disparity.characterCreation.GUIresources.ColoredButton;
import disparity.characterCreation.GUIresources.DisplayImage;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import net.miginfocom.swing.MigLayout;

import javax.swing.SpringLayout;

public class TitleScreen {
	
	/*public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TitleScreen window = new TitleScreen();
					window.frmDisparity.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

		/**
		 * Initialize the contents of the Screen1.
		 * @wbp.parser.entryPoint
		 */
		public TitleScreen() {
			
			JFrame frmDisparity = new JFrame();
			frmDisparity.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/disparity/characterCreation/res/Backgrounds/DisparityICON.png")));
			frmDisparity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmDisparity.setTitle("Disparity");
			frmDisparity.setBounds(100, 100, 606, 479);
			
			JPanel titlePanel = new JPanel();
			
			frmDisparity.getContentPane().setLayout(new CardLayout(0, 0));
			frmDisparity.getContentPane().add(titlePanel, "name_10907673180820");
			
			JLabel disparityLogoLabel =new JLabel("");
			disparityLogoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			ComponentListener disparityLogoListener = new DisplayImage(disparityLogoLabel, "../res/Backgrounds/Title.png");
			disparityLogoLabel.addComponentListener(disparityLogoListener);
			SpringLayout sl_titlePanel = new SpringLayout();
			sl_titlePanel.putConstraint(SpringLayout.NORTH, disparityLogoLabel, 42, SpringLayout.NORTH, titlePanel);
			sl_titlePanel.putConstraint(SpringLayout.WEST, disparityLogoLabel, 10, SpringLayout.WEST, titlePanel);
			sl_titlePanel.putConstraint(SpringLayout.SOUTH, disparityLogoLabel, -216, SpringLayout.SOUTH, titlePanel);
			sl_titlePanel.putConstraint(SpringLayout.EAST, disparityLogoLabel, -10, SpringLayout.EAST, titlePanel);
			titlePanel.setLayout(sl_titlePanel);
			titlePanel.add(disparityLogoLabel);
			
			ColoredButton createButton = new ColoredButton("Create", Color.GREEN);
			sl_titlePanel.putConstraint(SpringLayout.NORTH, createButton, -165, SpringLayout.SOUTH, titlePanel);
			sl_titlePanel.putConstraint(SpringLayout.WEST, createButton, 196, SpringLayout.WEST, titlePanel);
			sl_titlePanel.putConstraint(SpringLayout.SOUTH, createButton, -106, SpringLayout.SOUTH, titlePanel);
			sl_titlePanel.putConstraint(SpringLayout.EAST, createButton, -211, SpringLayout.EAST, titlePanel);
			titlePanel.add(createButton);
			ColoredButton exitButton = new ColoredButton("Exit", Color.RED);
			sl_titlePanel.putConstraint(SpringLayout.NORTH, exitButton, -100, SpringLayout.SOUTH, titlePanel);
			sl_titlePanel.putConstraint(SpringLayout.WEST, exitButton, 196, SpringLayout.WEST, titlePanel);
			sl_titlePanel.putConstraint(SpringLayout.SOUTH, exitButton, -41, SpringLayout.SOUTH, titlePanel);
			sl_titlePanel.putConstraint(SpringLayout.EAST, exitButton, -211, SpringLayout.EAST, titlePanel);
			titlePanel.add(exitButton);
			
			ColoredButton[] buttons = {createButton, exitButton};
			
			ActionListener buttonListener = new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ColoredButton b = (ColoredButton)e.getSource();
					switch(b.getName()){
					case "Create":
						new SelectRaceScreen().getFrame().setVisible(true);
						break;
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
			
			frmDisparity.setVisible(true);
		}
		

}
