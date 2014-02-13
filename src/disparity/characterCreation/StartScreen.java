package disparity.characterCreation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

public class StartScreen {
	
    private Font getFont(int size){
    	// Avg size is about 24 (for reference)
    	if(size == 0){
    		size = 24;
    	}

		try {
			GraphicsEnvironment.getLocalGraphicsEnvironment().
				registerFont(Font.createFont(Font.PLAIN, new File("res/Fonts/AESYSMAT.FON")));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
    	Font font = new Font("AESYSMAT", Font.PLAIN, size);
        return font;
    }
	
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
				//frame.setContentPane(CharacterCreationScreen.getScreen());
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
		
		ColoredButton createButton = new ColoredButton("createButton", Color.MAGENTA);
		ColoredButton exitButton = new ColoredButton("exitButton", Color.RED);
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
