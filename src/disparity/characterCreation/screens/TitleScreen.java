package disparity.characterCreation.screens;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import disparity.characterCreation.GUIresources.ColoredButton;
import disparity.characterCreation.GUIresources.DisplayImage;

public class TitleScreen extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6197091756601543002L;
	private JFrame main;
		/**
		 * Initialize the contents of the Screen1.
		 * @wbp.parser.entryPoint
		 */
		public TitleScreen(JFrame jf) {
			this.main = jf;
			JPanel titlePanel = new JPanel();
			this.setLayout(new CardLayout(0, 0));
			this.add(titlePanel, "name_10907673180820");
			
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
			
			exitButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
			}});			
			createButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
			        main.setContentPane(new SelectRaceScreen(main));
			        main.revalidate();
				}
			});
			this.setVisible(true);
		}
		

}
