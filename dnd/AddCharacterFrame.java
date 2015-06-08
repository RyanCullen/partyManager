package dnd;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class AddCharacterFrame {

	protected JFrame frame;
	protected CharacterList charList = ManagerFrame.charList;
	protected boolean editting = false;
	protected Character character;
	private JLabel lblName;
	private JLabel lblHitpoints;
	private JLabel lblArmorClass;
	private JLabel lblReflex;
	private JLabel lblSpeed;
	private JLabel lblExperience;
	private JLabel lblHealingSurges;
	private JLabel lblFortitude;
	private JLabel lblWill;
	private JLabel lblGold;
	protected JTextField fldName;
	protected JTextField fldHp;
	protected JTextField fldAc;
	protected JTextField fldReflex;
	protected JTextField fldSpeed;
	protected JTextField fldExp;
	protected JTextField fldSurges;
	protected JTextField fldFort;
	protected JTextField fldWill;
	protected JTextField fldGold;
	protected JPanel btnPanel;
	protected JButton btnAdd;
	protected JButton btnCancel;

	public AddCharacterFrame() {
		frame = new JFrame("New Character");
		JPanel contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		contentPane.add(lblName, gbc_lblName);

		fldName = new JTextField();
		GridBagConstraints gbc_fldName = new GridBagConstraints();
		gbc_fldName.insets = new Insets(0, 0, 5, 5);
		gbc_fldName.gridx = 1;
		gbc_fldName.gridy = 0;
		contentPane.add(fldName, gbc_fldName);
		fldName.setColumns(10);

		lblExperience = new JLabel("Experience:");
		GridBagConstraints gbc_lblExperience = new GridBagConstraints();
		gbc_lblExperience.anchor = GridBagConstraints.WEST;
		gbc_lblExperience.insets = new Insets(0, 0, 5, 5);
		gbc_lblExperience.gridx = 2;
		gbc_lblExperience.gridy = 0;
		contentPane.add(lblExperience, gbc_lblExperience);

		fldExp = new JTextField();
		GridBagConstraints gbc_fldExp = new GridBagConstraints();
		gbc_fldExp.insets = new Insets(0, 0, 5, 0);
		gbc_fldExp.gridx = 3;
		gbc_fldExp.gridy = 0;
		contentPane.add(fldExp, gbc_fldExp);
		fldExp.setColumns(10);

		lblHitpoints = new JLabel("Hitpoints:");
		GridBagConstraints gbc_lblHitpoints = new GridBagConstraints();
		gbc_lblHitpoints.anchor = GridBagConstraints.WEST;
		gbc_lblHitpoints.insets = new Insets(0, 0, 5, 5);
		gbc_lblHitpoints.gridx = 0;
		gbc_lblHitpoints.gridy = 1;
		contentPane.add(lblHitpoints, gbc_lblHitpoints);

		fldHp = new JTextField();
		GridBagConstraints gbc_fldHp = new GridBagConstraints();
		gbc_fldHp.insets = new Insets(0, 0, 5, 5);
		gbc_fldHp.gridx = 1;
		gbc_fldHp.gridy = 1;
		contentPane.add(fldHp, gbc_fldHp);
		fldHp.setColumns(10);

		lblHealingSurges = new JLabel("Healing Surges:");
		GridBagConstraints gbc_lblHealingSurges = new GridBagConstraints();
		gbc_lblHealingSurges.anchor = GridBagConstraints.WEST;
		gbc_lblHealingSurges.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealingSurges.gridx = 2;
		gbc_lblHealingSurges.gridy = 1;
		contentPane.add(lblHealingSurges, gbc_lblHealingSurges);

		fldSurges = new JTextField();
		GridBagConstraints gbc_fldSurges = new GridBagConstraints();
		gbc_fldSurges.insets = new Insets(0, 0, 5, 0);
		gbc_fldSurges.gridx = 3;
		gbc_fldSurges.gridy = 1;
		contentPane.add(fldSurges, gbc_fldSurges);
		fldSurges.setColumns(10);

		lblArmorClass = new JLabel("Armor Class:");
		GridBagConstraints gbc_lblArmorClass = new GridBagConstraints();
		gbc_lblArmorClass.anchor = GridBagConstraints.WEST;
		gbc_lblArmorClass.insets = new Insets(0, 0, 5, 5);
		gbc_lblArmorClass.gridx = 0;
		gbc_lblArmorClass.gridy = 2;
		contentPane.add(lblArmorClass, gbc_lblArmorClass);

		fldAc = new JTextField();
		GridBagConstraints gbc_fldAc = new GridBagConstraints();
		gbc_fldAc.insets = new Insets(0, 0, 5, 5);
		gbc_fldAc.gridx = 1;
		gbc_fldAc.gridy = 2;
		contentPane.add(fldAc, gbc_fldAc);
		fldAc.setColumns(10);

		lblFortitude = new JLabel("Fortitude:");
		GridBagConstraints gbc_lblFortitude = new GridBagConstraints();
		gbc_lblFortitude.anchor = GridBagConstraints.WEST;
		gbc_lblFortitude.insets = new Insets(0, 0, 5, 5);
		gbc_lblFortitude.gridx = 2;
		gbc_lblFortitude.gridy = 2;
		contentPane.add(lblFortitude, gbc_lblFortitude);

		fldFort = new JTextField();
		GridBagConstraints gbc_fldFort = new GridBagConstraints();
		gbc_fldFort.insets = new Insets(0, 0, 5, 0);
		gbc_fldFort.gridx = 3;
		gbc_fldFort.gridy = 2;
		contentPane.add(fldFort, gbc_fldFort);
		fldFort.setColumns(10);

		lblReflex = new JLabel("Reflex:");
		GridBagConstraints gbc_lblReflex = new GridBagConstraints();
		gbc_lblReflex.anchor = GridBagConstraints.WEST;
		gbc_lblReflex.insets = new Insets(0, 0, 5, 5);
		gbc_lblReflex.gridx = 0;
		gbc_lblReflex.gridy = 3;
		contentPane.add(lblReflex, gbc_lblReflex);

		fldReflex = new JTextField();
		GridBagConstraints gbc_fldReflex = new GridBagConstraints();
		gbc_fldReflex.insets = new Insets(0, 0, 5, 5);
		gbc_fldReflex.gridx = 1;
		gbc_fldReflex.gridy = 3;
		contentPane.add(fldReflex, gbc_fldReflex);
		fldReflex.setColumns(10);

		lblWill = new JLabel("Will:");
		GridBagConstraints gbc_lblWill = new GridBagConstraints();
		gbc_lblWill.anchor = GridBagConstraints.WEST;
		gbc_lblWill.insets = new Insets(0, 0, 5, 5);
		gbc_lblWill.gridx = 2;
		gbc_lblWill.gridy = 3;
		contentPane.add(lblWill, gbc_lblWill);

		fldWill = new JTextField();
		GridBagConstraints gbc_fldWill = new GridBagConstraints();
		gbc_fldWill.insets = new Insets(0, 0, 5, 0);
		gbc_fldWill.gridx = 3;
		gbc_fldWill.gridy = 3;
		contentPane.add(fldWill, gbc_fldWill);
		fldWill.setColumns(10);

		lblSpeed = new JLabel("Speed:");
		GridBagConstraints gbc_lblSpeed = new GridBagConstraints();
		gbc_lblSpeed.anchor = GridBagConstraints.WEST;
		gbc_lblSpeed.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpeed.gridx = 0;
		gbc_lblSpeed.gridy = 4;
		contentPane.add(lblSpeed, gbc_lblSpeed);

		fldSpeed = new JTextField();
		GridBagConstraints gbc_fldSpeed = new GridBagConstraints();
		gbc_fldSpeed.insets = new Insets(0, 0, 5, 5);
		gbc_fldSpeed.gridx = 1;
		gbc_fldSpeed.gridy = 4;
		contentPane.add(fldSpeed, gbc_fldSpeed);
		fldSpeed.setColumns(10);

		lblGold = new JLabel("Gold:");
		GridBagConstraints gbc_lblGold = new GridBagConstraints();
		gbc_lblGold.insets = new Insets(0, 0, 5, 5);
		gbc_lblGold.anchor = GridBagConstraints.WEST;
		gbc_lblGold.gridx = 2;
		gbc_lblGold.gridy = 4;
		contentPane.add(lblGold, gbc_lblGold);

		fldGold = new JTextField();
		GridBagConstraints gbc_fldGold = new GridBagConstraints();
		gbc_fldGold.insets = new Insets(0, 0, 5, 0);
		gbc_fldGold.gridx = 3;
		gbc_fldGold.gridy = 4;
		contentPane.add(fldGold, gbc_fldGold);
		fldGold.setColumns(10);

		btnPanel = new JPanel();
		btnPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_btnPanel = new GridBagConstraints();
		gbc_btnPanel.gridwidth = 4;
		gbc_btnPanel.fill = GridBagConstraints.BOTH;
		gbc_btnPanel.gridx = 0;
		gbc_btnPanel.gridy = 5;
		contentPane.add(btnPanel, gbc_btnPanel);
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (verifyFields()) {
					addCharacter();
					ManagerFrame.drawCharPanels();
					frame.dispose();
				}
			}
		});
		btnPanel.add(btnAdd);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnPanel.add(btnCancel);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setResizable(false);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void addCharacter() {
		charList.addCharacter(new Character(fldName.getText(), Integer
				.parseInt(fldExp.getText()), Integer.parseInt(fldHp.getText()),
				Integer.parseInt(fldSurges.getText()), Integer.parseInt(fldAc
						.getText()), Integer.parseInt(fldFort.getText()),
				Integer.parseInt(fldReflex.getText()), Integer.parseInt(fldWill
						.getText()), Integer.parseInt(fldSpeed.getText()),
				Integer.parseInt(fldGold.getText())));
		charList.save();
	}

	public boolean verifyFields() {
		String errorString = "";
		if (fldName.getText().isEmpty())
			errorString += "Name is a required field.\n";
		else if (editting) {
			if (!fldName.getText().equals(character.getName())
					&& charList.takenNames.contains(fldName.getText())) {
				System.out.println(fldName.getText() + " = "
						+ character.getName());
				errorString += "Name " + fldName.getText()
						+ " is already taken.\n";
			}
		}
		else if (charList.takenNames.contains(fldName.getText()))
			errorString += "Name " + fldName.getText() + " is already taken.\n";
		try {
			Integer.parseInt(fldExp.getText());
		}
		catch (NumberFormatException e) {
			errorString += "The experience field requires an integer.\n";
		}
		try {
			Integer.parseInt(fldHp.getText());
		}
		catch (NumberFormatException e) {
			errorString += "The hitpoints field requires an integer.\n";
		}
		try {
			Integer.parseInt(fldSurges.getText());
		}
		catch (NumberFormatException e) {
			errorString += "The healing surges field requires an integer.\n";
		}
		try {
			Integer.parseInt(fldAc.getText());
		}
		catch (NumberFormatException e) {
			errorString += "The armor class field requires an integer.\n";
		}
		try {
			Integer.parseInt(fldFort.getText());
		}
		catch (NumberFormatException e) {
			errorString += "The fortitude field requires an integer.\n";
		}
		try {
			Integer.parseInt(fldReflex.getText());
		}
		catch (NumberFormatException e) {
			errorString += "The reflex field requires an integer.\n";
		}
		try {
			Integer.parseInt(fldWill.getText());
		}
		catch (NumberFormatException e) {
			errorString += "The will field requires an integer.\n";
		}
		try {
			Integer.parseInt(fldSpeed.getText());
		}
		catch (NumberFormatException e) {
			errorString += "The speed field requires an integer.\n";
		}
		try {
			Integer.parseInt(fldGold.getText());
		}
		catch (NumberFormatException e) {
			errorString += "The gold field requires an integer.\n";
		}
		if (!errorString.isEmpty()) {
			JOptionPane.showMessageDialog(frame, errorString, "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else
			return true;
	}
}
