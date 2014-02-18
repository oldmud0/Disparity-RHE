package disparity.characterCreation;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainScreen {
	
	public JFrame frmDisparity;
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new TitleScreen();
					window.frmDisparity.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
