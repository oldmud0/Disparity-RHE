package disparity.characterCreation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class StartScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen window = new StartScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartScreen() {
		initialize();
	}
	
	ActionListener buttonListener = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			ColoredButton b = (ColoredButton)e.getSource();
			switch(b.getName()){
			case "createButton":
				frame.setContentPane(CharacterCreationScreen.getScreen());
				break;
			case "exitButton":
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null,  "Button event not found...","Error",JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		
	};

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 606, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ColoredButton createButton = new ColoredButton("res/createButtonNormal.png", "res/createButtonClick.png", "res/createButtonRoll.png", "createButton");
		ColoredButton exitButton = new ColoredButton("res/exitButtonNormal.png", "res/exitButtonRoll.png", "res/exitButtonClick.png", "exitButton");
		ColoredButton[] buttons = {createButton, exitButton};
		for(ColoredButton c : buttons){
			c.addActionListener(buttonListener);
		}
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(181)
					.addComponent(createButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(226, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(299, Short.MAX_VALUE)
					.addComponent(createButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(0))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
