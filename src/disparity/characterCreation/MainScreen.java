package disparity.characterCreation;

import java.awt.EventQueue;

import javax.swing.JFrame;

import disparity.characterCreation.screens.TitleScreen;

public class MainScreen {
	
	public JFrame frmDisparity;
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TitleScreen window = new TitleScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getFrame() {
		return frmDisparity;
	}
}
