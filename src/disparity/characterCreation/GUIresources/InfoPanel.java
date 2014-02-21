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
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Disparity");
		frame.setBounds(100, 100, 606, 479);
		frame.getContentPane().add(new InfoPanel(
				"Human", Resources.addEndl(
				"The Humans are one of the " + 
				"most versatile of all the " + 
				"races of Saulis. Also being " + 
				"one of the newest, the Humans " + 
				"were able to create many amazing " + 
				"diverse, large, and important " + 
				"colonies to the World of Saulis, " + 
				"although they are currently under " + 
				"the dark control of Mirtis," + 
				"They have completed much. " + 
				"Humans are generally disliked" + 
				"by the other races..."),
				"../res/Races/Example.png"));
	
		frame.setVisible(true);
	}
	
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
		info.setLineWrap(true);
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
