package disparity.characterCreation.GUIresources;

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

public class InfoPanel extends JPanel {
	private JTextArea info;
	
	public InfoPanel(String Title, String Info, String picSrc){
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
		

		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(213)
							.addComponent(titleText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(307, Short.MAX_VALUE)
							.addComponent(pic)))
					.addGap(178))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(info, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(114, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(titleText)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(info, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
						.addComponent(pic)))
		);
		setLayout(groupLayout);
		
	}
}
