package disparity.game.editor;

import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Stack;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import disparity.rpg.being.Being;
import disparity.rpg.being.Character;
import disparity.rpg.races.Race;

public class RPGDevMainWindow {

	private JFrame frmJustAnotherRpg;
	private JList<?> list = new JList<Object>();
	@SuppressWarnings("rawtypes")
	private DefaultListModel listModel = new DefaultListModel();
	
	private HashMap<JTextField,GhostText> textBoxes = new HashMap<JTextField,GhostText>();
	private Stack<JLabel> labels = new Stack<JLabel>();
	private HashMap<String,Character> characters = new HashMap<String,Character>();
	
	/**
	 * Launch the application.
	 */
	public static void run(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		
		//Set look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		frmJustAnotherRpg = new JFrame();
		frmJustAnotherRpg.setTitle("Just Another RPG Editor");
		frmJustAnotherRpg.setBounds(100, 100, 525, 565);
		frmJustAnotherRpg.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmJustAnotherRpg.getContentPane().setLayout(springLayout);
		
		list.addListSelectionListener(new ListSelectionListener() { //Change when character is selected
			@Override
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
						e.printStackTrace();
					}
				}
				
			}
		});
		
		list.getInputMap().put( KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0), "delete" );
		list.getActionMap().put("delete", new AbstractAction() {
			private static final long serialVersionUID = 1L; //required

			@Override
			public void actionPerformed(ActionEvent e) {
				removeCharacter((Character)list.getSelectedValue());
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
		springLayout.putConstraint(SpringLayout.NORTH, btnNewCharacter, -33, SpringLayout.SOUTH, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewCharacter, 10, SpringLayout.WEST, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewCharacter, -10, SpringLayout.SOUTH, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewCharacter, -10, SpringLayout.EAST, frmJustAnotherRpg.getContentPane());
		btnNewCharacter.addActionListener(new ActionListener() { //Character creation menu
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name;
				name = (String)JOptionPane.showInputDialog(null, "Character name:","New character",JOptionPane.PLAIN_MESSAGE,null,null,"Player");
				while(characters.containsKey(name)) {
					name = (String)JOptionPane.showInputDialog(null, "That name is already used.\nCharacter name:","New character",JOptionPane.ERROR_MESSAGE,null,null,"Player");
				}
				if(name == null || name.length() == 0) return;
				
				Object[] races = Race.getCharacterRaces().values().toArray();
				String race = (String)JOptionPane.showInputDialog(null, "Race:", "Select race",JOptionPane.PLAIN_MESSAGE,null,races,"HUMAN");
				
				addCharacter(new Character(name, race));
			}
		});
		frmJustAnotherRpg.getContentPane().add(btnNewCharacter);
		
		JButton btnUpdateCharacter = new JButton("Update character");
		springLayout.putConstraint(SpringLayout.NORTH, btnUpdateCharacter, -29, SpringLayout.NORTH, btnNewCharacter);
		springLayout.putConstraint(SpringLayout.WEST, btnUpdateCharacter, 10, SpringLayout.WEST, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnUpdateCharacter, -6, SpringLayout.NORTH, btnNewCharacter);
		springLayout.putConstraint(SpringLayout.EAST, btnUpdateCharacter, -10, SpringLayout.EAST, frmJustAnotherRpg.getContentPane());
		
		btnUpdateCharacter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { //Update our character stats
				if(list.isSelectionEmpty())return;
				
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
		springLayout.putConstraint(SpringLayout.NORTH, statsPanel, 208, SpringLayout.NORTH, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, list, -6, SpringLayout.NORTH, statsPanel);
		springLayout.putConstraint(SpringLayout.WEST, statsPanel, 10, SpringLayout.WEST, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, statsPanel, -10, SpringLayout.EAST, frmJustAnotherRpg.getContentPane());
		frmJustAnotherRpg.getContentPane().add(statsPanel);
		statsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnShowStats = new JButton("Show me the stats");
		springLayout.putConstraint(SpringLayout.WEST, btnShowStats, 10, SpringLayout.WEST, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnShowStats, -10, SpringLayout.EAST, frmJustAnotherRpg.getContentPane());
		btnShowStats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { //When "Show me the stats" button is pressed
				if(list.getSelectedValue() == null || !characters.containsKey( list.getSelectedValue().toString() ))JOptionPane.showMessageDialog(null, "No character was selected.","Character Stats",JOptionPane.ERROR_MESSAGE);
				else JOptionPane.showMessageDialog(null, characters.get(list.getSelectedValue().toString()).printStats(), "Character Stats", JOptionPane.INFORMATION_MESSAGE); 
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnShowStats, -8, SpringLayout.NORTH, btnUpdateCharacter);
		frmJustAnotherRpg.getContentPane().add(btnShowStats);
		
		
		JButton btnDeleteCharacter = new JButton("Delete character");
		springLayout.putConstraint(SpringLayout.WEST, btnDeleteCharacter, 10, SpringLayout.WEST, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnDeleteCharacter, -10, SpringLayout.EAST, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, statsPanel, -6, SpringLayout.NORTH, btnDeleteCharacter);
		springLayout.putConstraint(SpringLayout.NORTH, btnShowStats, 6, SpringLayout.SOUTH, btnDeleteCharacter);
		springLayout.putConstraint(SpringLayout.NORTH, btnDeleteCharacter, -124, SpringLayout.SOUTH, frmJustAnotherRpg.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnDeleteCharacter, -99, SpringLayout.SOUTH, frmJustAnotherRpg.getContentPane());
		btnDeleteCharacter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeCharacter((Character)list.getSelectedValue());
			}
		});
		frmJustAnotherRpg.getContentPane().add(btnDeleteCharacter);
		
		
		//Let's add some text boxes, shall we?
		//For each stat field, make a text box for it
		
		JTextField tempTextBox;
		JLabel tempLabel;
		for(Entry<String,String> field : Being.getStatFields().entrySet()) {
			tempLabel = new JLabel(field.getValue());
			labels.push(tempLabel);
			
			tempTextBox = new JTextField();
			tempTextBox.setColumns(15);
			tempTextBox.setToolTipText(String.valueOf(field.getValue().toCharArray()[0]).toUpperCase() + field.getValue().substring(1)); //Make first letter uppercase
			textBoxes.put( tempTextBox, new GhostText(tempTextBox,field.getValue()) );
			
			statsPanel.add(tempLabel);
			statsPanel.add(tempTextBox);
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public void addCharacter(Character c) {
		listModel.addElement(c);
		characters.put(c.name,c);
		list.setSelectedValue(characters.get(c.name), true); //Select our new character
	}
	
	public void removeCharacter(Character c) {
		if(list.isSelectionEmpty())return;
		
		if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete \""+c.name+"\"?","Character Stats",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			listModel.removeElement(c);
			characters.remove(c.name);
		}
	}
	
	public String getKeyFromValue(String val) {
		for(Entry<String, String> keyval : Being.getStatFields().entrySet()) {
			if(val.equals(keyval.getValue()))return keyval.getKey();
		}
		return null;
	}

	
}