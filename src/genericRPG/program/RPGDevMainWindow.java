package genericRPG.program;

import genericRPG.beingTypes.Being;
import genericRPG.beingTypes.Character;
import genericRPG.races.Race;

import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RPGDevMainWindow {

	private JFrame frmJustAnotherRpg;
	private JList<?> list = new JList<Object>();
	private DefaultListModel listModel = new DefaultListModel();
	
	private HashMap<JTextField,GhostText> textBoxes = new HashMap<JTextField,GhostText>();
	private HashMap<String,Character> characters = new HashMap<String,Character>();
	
	/**
	 * Launch the application.
	 */
	public static void run(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RPGDevMainWindow window = new RPGDevMainWindow();
					window.frmJustAnotherRpg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RPGDevMainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frmJustAnotherRpg = new JFrame();
		frmJustAnotherRpg.setTitle("Just Another RPG Editor");
		frmJustAnotherRpg.setBounds(100, 100, 525, 565);
		frmJustAnotherRpg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, list, -379, SpringLayout.SOUTH, frmJustAnotherRpg.getContentPane());
		frmJustAnotherRpg.getContentPane().setLayout(springLayout);
		
		list.addListSelectionListener(new ListSelectionListener() { //Change when character is selected
			public void valueChanged(ListSelectionEvent arg0) {
				
				if(list.getSelectedValue() == null) { //Prevent an exception by not doing anything if we somehow un-selected an item
					for(Entry<JTextField,GhostText> textBox : textBoxes.entrySet()) {
						textBox.getValue().focusGained(new FocusEvent(new Canvas(), 0));
						textBox.getKey().setText("");
						textBox.getValue().focusLost(new FocusEvent(new Canvas(), 1));
					}
				} else 
					for(Entry<JTextField,GhostText> textBox : textBoxes.entrySet()) {
					try {
						textBox.getValue().focusGained(new FocusEvent(new Canvas(), 0)); //We have to fake a FocusEvent in order for this to work.
						textBox.getKey().setText( characters.get( list.getSelectedValue().toString() ).getStat( getKeyFromValue(textBox.getValue().ghostText) ).toString() ); //Get the values of each stat
						textBox.getValue().focusLost(new FocusEvent(new Canvas(), 1));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, list, 10, SpringLayout.NORTH, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.WEST, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list, -10, SpringLayout.EAST, frmJustAnotherRpg.getContentPane());
		list.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Character select", TitledBorder.LEFT, TitledBorder.BOTTOM, null, null));
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		list.setModel(listModel);
		frmJustAnotherRpg.getContentPane().add(list);
		
		
		JButton btnNewCharacter = new JButton("New character");
		btnNewCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name;
				name = JOptionPane.showInputDialog(null, "Character name:","Player",JOptionPane.PLAIN_MESSAGE);
				if(name == null || name.length() == 0) return;
				
				Object[] races = Race.getRaces().toArray();
				String race = (String)JOptionPane.showInputDialog(null, "Race:", "Select race",JOptionPane.PLAIN_MESSAGE,null,races,"HUMAN");
				
				addCharacter(new Character(name, race));
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewCharacter, -33, SpringLayout.SOUTH, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewCharacter, 10, SpringLayout.WEST, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewCharacter, -10, SpringLayout.SOUTH, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewCharacter, -10, SpringLayout.EAST, frmJustAnotherRpg.getContentPane());
		frmJustAnotherRpg.getContentPane().add(btnNewCharacter);
		
		JButton btnUpdateCharacter = new JButton("Update character");
		springLayout.putConstraint(SpringLayout.NORTH, btnUpdateCharacter, -29, SpringLayout.NORTH, btnNewCharacter);
		springLayout.putConstraint(SpringLayout.WEST, btnUpdateCharacter, 10, SpringLayout.WEST, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnUpdateCharacter, -6, SpringLayout.NORTH, btnNewCharacter);
		springLayout.putConstraint(SpringLayout.EAST, btnUpdateCharacter, -10, SpringLayout.EAST, frmJustAnotherRpg.getContentPane());
		
		btnUpdateCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //Update our character stats
				Character c = (Character)list.getSelectedValue(); //Apparently we have to cast our Object into a Character first
				String oldName = c.name;
				
				try {
					for(Entry<JTextField,GhostText> textBox : textBoxes.entrySet()) {
							c.setStat( getKeyFromValue(textBox.getValue().ghostText), textBox.getKey().getText() );
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "An error occured while updating the character; see console for details.","Update Character",JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
				
				String newName = c.name; //We're assuming that this changed after the loop.
				
				listModel.setElementAt(c, list.getSelectedIndex());
				characters.put(newName, characters.remove(oldName) );
			}
		});
		frmJustAnotherRpg.getContentPane().add(btnUpdateCharacter);
		
		JPanel statsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, statsPanel, 6, SpringLayout.SOUTH, list);
		springLayout.putConstraint(SpringLayout.WEST, statsPanel, 10, SpringLayout.WEST, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, statsPanel, -10, SpringLayout.EAST, frmJustAnotherRpg.getContentPane());
		frmJustAnotherRpg.getContentPane().add(statsPanel);
		statsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnShowStats = new JButton("Show me the stats");
		btnShowStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //When "Show me the stats" button is pressed
				if(list.getSelectedValue() == null || !characters.containsKey( list.getSelectedValue().toString() ))JOptionPane.showMessageDialog(null, "No character was selected.","Character Stats",JOptionPane.ERROR_MESSAGE);
				else JOptionPane.showMessageDialog(null, characters.get(list.getSelectedValue().toString()).printStats(), "Character Stats", JOptionPane.INFORMATION_MESSAGE); 
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnShowStats, 10, SpringLayout.WEST, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnShowStats, -8, SpringLayout.NORTH, btnUpdateCharacter);
		springLayout.putConstraint(SpringLayout.EAST, btnShowStats, -10, SpringLayout.EAST, frmJustAnotherRpg.getContentPane());
		frmJustAnotherRpg.getContentPane().add(btnShowStats);
		
		JButton btnNewButton = new JButton("Delete character");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeCharacter((Character)list.getSelectedValue());
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, statsPanel, -18, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnShowStats, 6, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, -124, SpringLayout.SOUTH, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -99, SpringLayout.SOUTH, frmJustAnotherRpg.getContentPane());
		frmJustAnotherRpg.getContentPane().add(btnNewButton);
		
		
		//Let's add some text boxes, shall we?
		//For each stat field, make a text box for it
		
		JTextField tempTextBox;
		for(Entry<String,String> field : Being.getStatFields().entrySet()) {
			tempTextBox = new JTextField();
			tempTextBox.setColumns(15);
			textBoxes.put( tempTextBox, new GhostText(tempTextBox,field.getValue()) );
			statsPanel.add(tempTextBox);
		}
		
		
	}
	
	public void addCharacter(Character c) {
		listModel.addElement(c);
		characters.put(c.name,c);
	}
	
	public void removeCharacter(Character c) {
		listModel.removeElement(c);
		characters.remove(c.name);
	}
	
	public String getKeyFromValue(String val) {
		for(Entry<String, String> keyval : Being.getStatFields().entrySet()) {
			if(val.equals(keyval.getValue()))return keyval.getKey();
		}
		return null;
	}
	
}
