package disparity.characterCreation;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import disparity.characterCreation.screens.TitleScreen;

public class MainScreen extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2104323466287453385L;

	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen screen = new MainScreen();
					screen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainScreen(){
		setAlwaysOnTop(true);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/disparity/characterCreation/res/Backgrounds/DisparityICON.png")));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Disparity");
		this.setBounds(100, 100, 606, 479);
		
		JPanel panel = new JPanel();
		panel = new TitleScreen(this);
		this.setContentPane(panel);
	}
}
