package dnd;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AttackFrame implements ActionListener {

	private JFrame frame;
	private JPanel contentPane;
	private JLabel lblDefense;
	private JTextField fldAttackRoll;
	private JRadioButton rdbtnArmorClass;
	private JRadioButton rdbtnFortitude;
	private JRadioButton rdbtnReflex;
	private JRadioButton rdbtnWill;
	private JCheckBox chkbxHalfOnMiss;
	private JPanel buttonPanel;
	private JButton btnAttack;
	private JButton btnCancel;
	private JLabel lblAttackRoll;
	private JPanel rdbtnPanel;
	private Character character;
	private ButtonGroup btnGroup;
	private JTextField fldDamage;

	public AttackFrame(CharacterPanel parent) {
		character = parent.character;
		frame = new JFrame("Attack " + character.getName());
		frame.setResizable(false);
		JPanel contentPane = new JPanel();
		frame.setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		lblDefense = new JLabel("Defense:");
		GridBagConstraints gbc_lblDefense = new GridBagConstraints();
		gbc_lblDefense.insets = new Insets(0, 0, 5, 5);
		gbc_lblDefense.gridx = 0;
		gbc_lblDefense.gridy = 0;
		contentPane.add(lblDefense, gbc_lblDefense);

		lblAttackRoll = new JLabel("Attack Roll:");
		GridBagConstraints gbc_lblAttackRoll = new GridBagConstraints();
		gbc_lblAttackRoll.insets = new Insets(0, 0, 5, 0);
		gbc_lblAttackRoll.gridx = 1;
		gbc_lblAttackRoll.gridy = 0;
		contentPane.add(lblAttackRoll, gbc_lblAttackRoll);

		rdbtnPanel = new JPanel();
		GridBagConstraints gbc_rdbtnPanel = new GridBagConstraints();
		gbc_rdbtnPanel.gridheight = 3;
		gbc_rdbtnPanel.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnPanel.fill = GridBagConstraints.BOTH;
		gbc_rdbtnPanel.gridx = 0;
		gbc_rdbtnPanel.gridy = 1;
		contentPane.add(rdbtnPanel, gbc_rdbtnPanel);
		rdbtnPanel.setLayout(new BoxLayout(rdbtnPanel, BoxLayout.Y_AXIS));
		rdbtnPanel.setBorder(BorderFactory.createLoweredBevelBorder());

		rdbtnArmorClass = new JRadioButton("Armor Class");
		rdbtnArmorClass.setSelected(true);
		rdbtnPanel.add(rdbtnArmorClass);

		rdbtnFortitude = new JRadioButton("Fortitude");
		rdbtnPanel.add(rdbtnFortitude);

		rdbtnReflex = new JRadioButton("Reflex");
		rdbtnPanel.add(rdbtnReflex);

		rdbtnWill = new JRadioButton("Will");
		rdbtnPanel.add(rdbtnWill);

		btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnArmorClass);
		btnGroup.add(rdbtnFortitude);
		btnGroup.add(rdbtnReflex);
		btnGroup.add(rdbtnWill);

		fldAttackRoll = new JTextField();
		GridBagConstraints gbc_fldAttackRoll = new GridBagConstraints();
		gbc_fldAttackRoll.insets = new Insets(0, 0, 5, 0);
		gbc_fldAttackRoll.gridx = 1;
		gbc_fldAttackRoll.gridy = 1;
		contentPane.add(fldAttackRoll, gbc_fldAttackRoll);
		fldAttackRoll.setColumns(3);

		chkbxHalfOnMiss = new JCheckBox("Hit for half on miss");
		GridBagConstraints gbc_chkbxHalfOnMiss = new GridBagConstraints();
		gbc_chkbxHalfOnMiss.insets = new Insets(0, 0, 5, 0);
		gbc_chkbxHalfOnMiss.gridx = 1;
		gbc_chkbxHalfOnMiss.gridy = 2;
		contentPane.add(chkbxHalfOnMiss, gbc_chkbxHalfOnMiss);

		buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 1;
		gbc_buttonPanel.gridy = 3;
		contentPane.add(buttonPanel, gbc_buttonPanel);

		btnAttack = new JButton("Attack");
		buttonPanel.add(btnAttack);

		btnCancel = new JButton("Cancel");
		buttonPanel.add(btnCancel);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		btnCancel.addActionListener(this);
		btnAttack.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAttack) {
			if (!fldAttackRoll.getText().isEmpty()) {
				try {
					Integer.parseInt(fldAttackRoll.getText());
					if (rdbtnArmorClass.isSelected()) {
						didItHit(0);
					}
					else if (rdbtnFortitude.isSelected()) {
						didItHit(1);
					}
					else if (rdbtnReflex.isSelected()) {
						didItHit(2);
					}
					else if (rdbtnWill.isSelected()) {
						didItHit(3);
					}
				}
				catch (NumberFormatException err) {
					JOptionPane.showMessageDialog(frame,
							"Attack roll is a required field.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			else
				JOptionPane.showMessageDialog(frame,
						"Attack roll must be an int.", "Error",
						JOptionPane.ERROR_MESSAGE);
		} // end btnAttack
		else if (e.getSource() == btnCancel) {
			frame.dispose();
		} // end btnCancel

	}

	private void didItHit(int option) {
		switch (option) {
		case 0:
			if (character.getAc() < Integer.parseInt(fldAttackRoll.getText()))
				hit(Integer.parseInt(fldAttackRoll.getText()));
			else
				miss(Integer.parseInt(fldAttackRoll.getText()));
			break;
		case 1:
			if (character.getFort() < Integer.parseInt(fldAttackRoll.getText()))
				hit(Integer.parseInt(fldAttackRoll.getText()));
			else
				miss(Integer.parseInt(fldAttackRoll.getText()));
			break;
		case 2:
			if (character.getRef() < Integer.parseInt(fldAttackRoll.getText()))
				hit(Integer.parseInt(fldAttackRoll.getText()));
			else
				miss(Integer.parseInt(fldAttackRoll.getText()));
			break;
		case 3:
			if (character.getWill() < Integer.parseInt(fldAttackRoll.getText()))
				hit(Integer.parseInt(fldAttackRoll.getText()));
			else
				miss(Integer.parseInt(fldAttackRoll.getText()));
		}
	}

	private void hit(int atkRoll) {

		frame.dispose();
	}

	private void miss(int atkRoll) {

		frame.dispose();
	}
}