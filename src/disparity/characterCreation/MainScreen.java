package disparity.characterCreation;

import java.awt.EventQueue;

public class MainScreen {
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screens window = new Screens("Title");
					window.frmDisparity.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
