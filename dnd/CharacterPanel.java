package dnd;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class CharacterPanel extends JPanel implements ActionListener,
		MouseListener, WindowListener {
	private JLabel lblLevel;
	private JLabel lblSpeed;
	private JPanel goldPanel;
	private JLabel lblGold;
	private JTextField fldGold;
	private JButton btnInventory;
	private JPanel HpPanel;
	private JLabel lblHp;
	private JTextField fldHp;
	private JLabel lblMaxHp;
	private JPanel surgesPanel;
	private JLabel lblSurges;
	private JTextField fldSurges;
	private JLabel lblMaxSurges;
	private JPanel panel_1;
	private JButton btnHeal;
	private JButton btnAttack;
	private JButton btnEditCharacter;
	public Character character;
	private JFrame notesFrame;
	private JTextArea notesDisplay;

	/**
	 * Create the panel.
	 */
	public CharacterPanel(Character character) {
		setBorder(BorderFactory.createTitledBorder(character.getName()));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblLevel = new JLabel("Level: " + character.getLevel());
		GridBagConstraints gbc_lblLevel = new GridBagConstraints();
		gbc_lblLevel.insets = new Insets(0, 0, 5, 5);
		gbc_lblLevel.gridx = 0;
		gbc_lblLevel.gridy = 0;
		add(lblLevel, gbc_lblLevel);

		lblSpeed = new JLabel("Speed: " + character.getSpeed());
		GridBagConstraints gbc_lblSpeed = new GridBagConstraints();
		gbc_lblSpeed.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpeed.gridx = 1;
		gbc_lblSpeed.gridy = 0;
		add(lblSpeed, gbc_lblSpeed);

		goldPanel = new JPanel();
		GridBagConstraints gbc_goldPanel = new GridBagConstraints();
		gbc_goldPanel.insets = new Insets(0, 0, 5, 5);
		gbc_goldPanel.fill = GridBagConstraints.BOTH;
		gbc_goldPanel.gridx = 2;
		gbc_goldPanel.gridy = 0;
		add(goldPanel, gbc_goldPanel);

		lblGold = new JLabel("Gold:");
		goldPanel.add(lblGold);

		fldGold = new JTextField(String.valueOf(character.getGold()), 6);
		fldGold.setHorizontalAlignment(SwingConstants.TRAILING);
		goldPanel.add(fldGold);

		btnInventory = new JButton("Inventory");
		GridBagConstraints gbc_btnInventory = new GridBagConstraints();
		gbc_btnInventory.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInventory.insets = new Insets(0, 0, 5, 0);
		gbc_btnInventory.gridx = 3;
		gbc_btnInventory.gridy = 0;
		add(btnInventory, gbc_btnInventory);

		HpPanel = new JPanel();
		GridBagConstraints gbc_HpPanel = new GridBagConstraints();
		gbc_HpPanel.anchor = GridBagConstraints.WEST;
		gbc_HpPanel.insets = new Insets(0, 0, 0, 5);
		gbc_HpPanel.fill = GridBagConstraints.VERTICAL;
		gbc_HpPanel.gridx = 0;
		gbc_HpPanel.gridy = 1;
		add(HpPanel, gbc_HpPanel);

		lblHp = new JLabel("Hp:");
		HpPanel.add(lblHp);

		fldHp = new JTextField(String.valueOf(character.getCurrentHP()), 3);
		fldHp.setHorizontalAlignment(SwingConstants.TRAILING);
		HpPanel.add(fldHp);

		lblMaxHp = new JLabel("/ " + character.getMaxHP());
		HpPanel.add(lblMaxHp);

		surgesPanel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		add(surgesPanel, gbc_panel);

		lblSurges = new JLabel("Surges:");
		surgesPanel.add(lblSurges);

		fldSurges = new JTextField(
				String.valueOf(character.getCurrentSurges()), 2);
		fldSurges.setHorizontalAlignment(SwingConstants.TRAILING);
		surgesPanel.add(fldSurges);

		lblMaxSurges = new JLabel("/ " + character.getMaxSurges());
		surgesPanel.add(lblMaxSurges);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnAttack = new JButton("Attack");
		panel_1.add(btnAttack);

		btnHeal = new JButton("Heal");
		panel_1.add(btnHeal);

		btnEditCharacter = new JButton("Edit Character");
		GridBagConstraints gbc_btnEditCharacter = new GridBagConstraints();
		gbc_btnEditCharacter.gridx = 3;
		gbc_btnEditCharacter.gridy = 1;
		add(btnEditCharacter, gbc_btnEditCharacter);

		btnAttack.addActionListener(this);
		btnEditCharacter.addActionListener(this);
		btnHeal.addActionListener(this);
		btnInventory.addActionListener(this);
		fldHp.addActionListener(this);
		fldGold.addActionListener(this);
		fldSurges.addActionListener(this);

		this.addMouseListener(this);
		this.character = character;
		setVisible(true);
	}

	public void updateFields() {
		this.setBorder(BorderFactory.createTitledBorder(character.getName()));
		fldHp.setText(String.valueOf(character.getCurrentHP()));
		fldSurges.setText(String.valueOf(character.getCurrentSurges()));
		fldGold.setText(String.valueOf(character.getGold()));
		lblLevel.setText("Level: " + character.getLevel());
		lblSpeed.setText("Speed: " + character.getSpeed());
		lblMaxHp.setText("/ " + character.getMaxHP());
		lblMaxSurges.setText("/ " + character.getMaxSurges());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAttack) {
			AttackFrame atkFrame = new AttackFrame(this);
		}
		else if (e.getSource() == btnEditCharacter) {
			AddCharacterFrame frame = new AddCharacterFrame(this, character);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}
		else if (e.getSource() == btnHeal) {
			HealFrame healFrame = new HealFrame(this);
		}
		else if (e.getSource() == btnInventory) {
			InventoryFrame invFrame = new InventoryFrame(this);
		}
		else if (e.getSource() == fldGold) {
			try {
				int gold = Integer.parseInt(fldGold.getText());
				character.setGold(gold);
			}
			catch (NumberFormatException err) {
				JOptionPane.showMessageDialog(null,
						"Gold field requires an int.", "Error",
						JOptionPane.ERROR_MESSAGE);
				fldGold.setText(String.valueOf(character.getGold()));
			}
		}
		else if (e.getSource() == fldHp) {
			try {
				int hP = Integer.parseInt(fldHp.getText());
				character.setCurrentHP(hP);
			}
			catch (NumberFormatException err) {
				JOptionPane.showMessageDialog(null,
						"Hp field requires an int.", "Error",
						JOptionPane.ERROR_MESSAGE);
				fldHp.setText(String.valueOf(character.getCurrentHP()));
			}
		}
		else if (e.getSource() == fldSurges) {
			try {
				int surges = Integer.parseInt(fldSurges.getText());
				character.setCurrentSurges(surges);
			}
			catch (NumberFormatException err) {
				JOptionPane.showMessageDialog(null,
						"Healing surges field requires an int.", "Error",
						JOptionPane.ERROR_MESSAGE);
				fldSurges.setText(String.valueOf(character.getCurrentSurges()));
			}
		}
	}

	private void displayNotes() {
		notesFrame = new JFrame("Notes on " + character.getName());
		notesFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		notesDisplay = new JTextArea(5, 20);
		notesDisplay.setText(character.getNotes());
		notesFrame.add(notesDisplay);
		notesFrame.pack();
		notesFrame.setLocationRelativeTo(null);
		notesFrame.setVisible(true);
		notesFrame.addWindowListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			displayNotes();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		if (arg0.getSource() == notesFrame) {
			character.setNotes(notesDisplay.getText());
			ManagerFrame.charList.save();
		}
	}

	@Override
	public void windowClosing(WindowEvent arg0) {

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
