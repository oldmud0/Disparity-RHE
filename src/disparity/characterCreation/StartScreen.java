package disparity.characterCreation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		
		ColoredButton createButton = new ColoredButton("createButton", Color.MAGENTA, 5);
		ColoredButton exitButton = new ColoredButton("exitButton", Color.RED, 5);
		ColoredButton[] buttons = {createButton, exitButton};
		
		for(ColoredButton c : buttons){
			c.addActionListener(buttonListener);
		}
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(189)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(exitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(createButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(218))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap(117, Short.MAX_VALUE)
					.addComponent(createButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(199))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
