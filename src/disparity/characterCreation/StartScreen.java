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
import javax.swing.JLabel;
import javax.swing.ImageIcon;

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
	
	private JFrame frmDisparity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen window = new StartScreen();
					window.frmDisparity.setVisible(true);
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
		
		frmDisparity = new JFrame();
		frmDisparity.setTitle("Disparity");
		frmDisparity.setBounds(100, 100, 606, 479);
		frmDisparity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ColoredButton createButton = new ColoredButton("createButton", Color.BLUE, 5);
		ColoredButton exitButton = new ColoredButton("exitButton", Color.RED, 5);
		ColoredButton[] buttons = {createButton, exitButton};
		
		for(ColoredButton c : buttons){
			c.addActionListener(buttonListener);
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(StartScreen.class.getResource("/disparity/characterCreation/res/Title.png")));
		
		GroupLayout groupLayout = new GroupLayout(frmDisparity.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(190)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(exitButton, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addComponent(createButton, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
					.addGap(217))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(140, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(55, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(createButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(56))
		);
		frmDisparity.getContentPane().setLayout(groupLayout);
	}
}
