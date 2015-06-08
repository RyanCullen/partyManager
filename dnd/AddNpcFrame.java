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

public class AddNpcFrame {

	private JFrame frame;
	private JLabel lblName;
	private JLabel lblLevel;
	private JLabel lblHitpoints;
	private JLabel lblSpeed;
	private JLabel lblArmorClass;
	private JLabel lblFortitude;
	private JLabel lblReflex;
	private JLabel lblWill;
	private JLabel lblRewardExp;
	private JTextField fldName;
	private JTextField fldHp;
	private JTextField fldAc;
	private JTextField fldRef;
	private JTextField fldReward;
	private JTextField fldLevel;
	private JTextField fldSpeed;
	private JTextField fldFort;
	private JTextField fldWill;
	private JPanel btnPanel;
	private JButton btnAdd;
	private JButton btnCancel;

	public AddNpcFrame(CreateEncounterFrame parent) {
		frame = new JFrame("Add NPC");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
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
		gbc_fldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldName.gridx = 1;
		gbc_fldName.gridy = 0;
		contentPane.add(fldName, gbc_fldName);
		fldName.setColumns(10);

		lblLevel = new JLabel("Level:");
		GridBagConstraints gbc_lblLevel = new GridBagConstraints();
		gbc_lblLevel.anchor = GridBagConstraints.WEST;
		gbc_lblLevel.insets = new Insets(0, 0, 5, 5);
		gbc_lblLevel.gridx = 2;
		gbc_lblLevel.gridy = 0;
		contentPane.add(lblLevel, gbc_lblLevel);

		fldLevel = new JTextField();
		GridBagConstraints gbc_fldLevel = new GridBagConstraints();
		gbc_fldLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldLevel.insets = new Insets(0, 0, 5, 0);
		gbc_fldLevel.gridx = 3;
		gbc_fldLevel.gridy = 0;
		contentPane.add(fldLevel, gbc_fldLevel);
		fldLevel.setColumns(10);

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
		gbc_fldHp.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldHp.gridx = 1;
		gbc_fldHp.gridy = 1;
		contentPane.add(fldHp, gbc_fldHp);
		fldHp.setColumns(10);

		lblSpeed = new JLabel("Speed:");
		GridBagConstraints gbc_lblSpeed = new GridBagConstraints();
		gbc_lblSpeed.anchor = GridBagConstraints.WEST;
		gbc_lblSpeed.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpeed.gridx = 2;
		gbc_lblSpeed.gridy = 1;
		contentPane.add(lblSpeed, gbc_lblSpeed);

		fldSpeed = new JTextField();
		GridBagConstraints gbc_fldSpeed = new GridBagConstraints();
		gbc_fldSpeed.insets = new Insets(0, 0, 5, 0);
		gbc_fldSpeed.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldSpeed.gridx = 3;
		gbc_fldSpeed.gridy = 1;
		contentPane.add(fldSpeed, gbc_fldSpeed);
		fldSpeed.setColumns(10);

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
		gbc_fldAc.fill = GridBagConstraints.HORIZONTAL;
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
		gbc_fldFort.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldFort.gridx = 3;
		gbc_fldFort.gridy = 2;
		contentPane.add(fldFort, gbc_fldFort);
		fldFort.setColumns(10);

		lblReflex = new JLabel("Reflex");
		GridBagConstraints gbc_lblReflex = new GridBagConstraints();
		gbc_lblReflex.anchor = GridBagConstraints.WEST;
		gbc_lblReflex.insets = new Insets(0, 0, 5, 5);
		gbc_lblReflex.gridx = 0;
		gbc_lblReflex.gridy = 3;
		contentPane.add(lblReflex, gbc_lblReflex);

		fldRef = new JTextField();
		GridBagConstraints gbc_fldRef = new GridBagConstraints();
		gbc_fldRef.insets = new Insets(0, 0, 5, 5);
		gbc_fldRef.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldRef.gridx = 1;
		gbc_fldRef.gridy = 3;
		contentPane.add(fldRef, gbc_fldRef);
		fldRef.setColumns(10);

		lblWill = new JLabel("Will:");
		GridBagConstraints gbc_lblWill = new GridBagConstraints();
		gbc_lblWill.anchor = GridBagConstraints.WEST;
		gbc_lblWill.insets = new Insets(0, 0, 5, 5);
		gbc_lblWill.gridx = 2;
		gbc_lblWill.gridy = 3;
		contentPane.add(lblWill, gbc_lblWill);

		fldWill = new JTextField();
		GridBagConstraints gbc_fldWill = new GridBagConstraints();
		gbc_fldWill.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldWill.insets = new Insets(0, 0, 5, 0);
		gbc_fldWill.gridx = 3;
		gbc_fldWill.gridy = 3;
		contentPane.add(fldWill, gbc_fldWill);
		fldWill.setColumns(10);

		lblRewardExp = new JLabel("Reward Exp:");
		GridBagConstraints gbc_lblRewardExp = new GridBagConstraints();
		gbc_lblRewardExp.anchor = GridBagConstraints.WEST;
		gbc_lblRewardExp.insets = new Insets(0, 0, 5, 5);
		gbc_lblRewardExp.gridx = 0;
		gbc_lblRewardExp.gridy = 4;
		contentPane.add(lblRewardExp, gbc_lblRewardExp);

		fldReward = new JTextField();
		GridBagConstraints gbc_fldReward = new GridBagConstraints();
		gbc_fldReward.insets = new Insets(0, 0, 5, 5);
		gbc_fldReward.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldReward.gridx = 1;
		gbc_fldReward.gridy = 4;
		contentPane.add(fldReward, gbc_fldReward);
		fldReward.setColumns(10);

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
					parent.addNpc(new NPC(fldName.getText(), Integer
							.parseInt(fldLevel.getText()), Integer
							.parseInt(fldHp.getText()), Integer
							.parseInt(fldSpeed.getText()), Integer
							.parseInt(fldAc.getText()), Integer
							.parseInt(fldFort.getText()), Integer
							.parseInt(fldRef.getText()), Integer
							.parseInt(fldWill.getText()), Integer
							.parseInt(fldReward.getText())));
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

	public boolean verifyFields() {
		String errorString = "";
		try {
			Integer.parseInt(fldLevel.getText());
		}
		catch (NumberFormatException e) {
			errorString += "The level field requires an integer.\n";
		}
		try {
			Integer.parseInt(fldHp.getText());
		}
		catch (NumberFormatException e) {
			errorString += "The hitpoints field requires an integer.\n";
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
			Integer.parseInt(fldRef.getText());
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
		if (!errorString.isEmpty()) {
			JOptionPane.showMessageDialog(frame, errorString, "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else
			return true;
	}

}
