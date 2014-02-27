package disparity.characterCreation.GUIresources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Component;
import java.util.List;

import javax.swing.SpringLayout;

import disparity.characterCreation.screens.SelectWeaponScreen;

public class InfoPanel extends JPanel {
	private JTextArea info;
	private JFrame main;
	public InfoPanel(final String Title, String Info, String picSrc, JFrame mainFrame, final String nextPanel, final List<String> characterSettings){
		this.main = mainFrame;
		char[] infoAsCharA = Info.toCharArray();
		int ind = 0;
		boolean hasPutLine = false;
		for(int i = 0; i < infoAsCharA.length; i++, ind++){
			while(hasPutLine){
				if(ind > 20 && infoAsCharA[ind] == ' '){
					
				}else{
					do{
						ind++;
					}while(ind > 20 && infoAsCharA[ind] == ' ');
				}
			}
		}
		info = new JTextArea();
		info.setBackground(UIManager.getColor("Button.background"));
		info.setEditable(false);
		info.setColumns(10);
		info.setFont(Resources.getFont());
		info.setText(Info);
		
		JLabel titleText = new JLabel();
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		titleText.setFont(Resources.getFont());
		titleText.setText(Title);	
		
		JLabel pic = new JLabel("");
		ComponentListener picListener = new DisplayImage(pic, "../res/Backgrounds/Title.png");
		pic.addComponentListener(picListener);
		
		MainMenuButton mnmnbtnM = new MainMenuButton(main);
		mnmnbtnM.setToolTipText("return to Main Menu");
	
		ColoredButton selectButton = new ColoredButton("Select", new Color(90, 20, 140));
		selectButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				switch(nextPanel.toUpperCase()){
				case"SELECTWEAPONSCREEN":
					characterSettings.add(Title);
					main.setContentPane(new SelectWeaponScreen(characterSettings, main));
			        main.revalidate();
				}
		}});	
		selectButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		selectButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, titleText, 0, SpringLayout.NORTH, mnmnbtnM);
		springLayout.putConstraint(SpringLayout.WEST, titleText, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, titleText, 0, SpringLayout.WEST, mnmnbtnM);
		springLayout.putConstraint(SpringLayout.NORTH, mnmnbtnM, 18, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, mnmnbtnM, -146, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, mnmnbtnM, 0, SpringLayout.EAST, selectButton);
		springLayout.putConstraint(SpringLayout.NORTH, selectButton, -79, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, selectButton, -193, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, selectButton, -20, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, selectButton, -10, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, info, 52, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, info, 46, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, info, 482, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, info, 336, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, pic, 52, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, pic, 377, SpringLayout.WEST, this);
		setLayout(springLayout);
		add(pic);
		add(info);
		add(titleText);
		add(mnmnbtnM);
		add(selectButton);
		
	}
}
