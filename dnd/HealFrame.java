package dnd;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class HealFrame {

	private JFrame frame;
	private JLabel lblHealFor;
	private JLabel lblSurgesUsed;
	private JTextField fldHeal;
	private JTextField fldSurges;
	private JPanel btnPanel;
	private JButton btnHeal;
	private JButton btnCancel;
	private Character character;

	// Constructor for frame
	public HealFrame(EncounterPanel parent) {
		this.character = parent.getCharacter();
		frame = new JFrame("Heal " + character.getName());
		JPanel contentPane = new JPanel();
		frame.setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblHealFor = new JLabel("Heal for:");
		GridBagConstraints gbc_lblHealFor = new GridBagConstraints();
		gbc_lblHealFor.anchor = GridBagConstraints.EAST;
		gbc_lblHealFor.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealFor.gridx = 0;
		gbc_lblHealFor.gridy = 0;
		contentPane.add(lblHealFor, gbc_lblHealFor);

		fldHeal = new JTextField();
		GridBagConstraints gbc_fldHeal = new GridBagConstraints();
		gbc_fldHeal.anchor = GridBagConstraints.WEST;
		gbc_fldHeal.insets = new Insets(0, 0, 5, 0);
		gbc_fldHeal.gridx = 1;
		gbc_fldHeal.gridy = 0;
		contentPane.add(fldHeal, gbc_fldHeal);
		fldHeal.setColumns(3);

		if (character.type == 'P') {
			lblSurgesUsed = new JLabel("Surges used:");
			GridBagConstraints gbc_lblSurgesUsed = new GridBagConstraints();
			gbc_lblSurgesUsed.anchor = GridBagConstraints.EAST;
			gbc_lblSurgesUsed.insets = new Insets(0, 0, 5, 5);
			gbc_lblSurgesUsed.gridx = 0;
			gbc_lblSurgesUsed.gridy = 1;
			contentPane.add(lblSurgesUsed, gbc_lblSurgesUsed);

			fldSurges = new JTextField();
			GridBagConstraints gbc_fldSurges = new GridBagConstraints();
			gbc_fldSurges.anchor = GridBagConstraints.WEST;
			gbc_fldSurges.insets = new Insets(0, 0, 5, 0);
			gbc_fldSurges.gridx = 1;
			gbc_fldSurges.gridy = 1;
			contentPane.add(fldSurges, gbc_fldSurges);
			fldSurges.setColumns(3);
		}

		btnPanel = new JPanel();
		GridBagConstraints gbc_btnPanel = new GridBagConstraints();
		gbc_btnPanel.gridwidth = 2;
		gbc_btnPanel.fill = GridBagConstraints.BOTH;
		gbc_btnPanel.gridx = 0;
		gbc_btnPanel.gridy = 2;
		contentPane.add(btnPanel, gbc_btnPanel);
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnHeal = new JButton("Heal");
		// ActionListener to save and update GUI if fields are valid
		btnHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (verifyFields()) {
					character.changeHP(Integer.parseInt(fldHeal.getText()));
					if (character.type == 'P') 
						((Player) character).changeSurges(-Integer
								.parseInt(fldSurges.getText()));
					parent.updateFields();
					frame.dispose();
				}
				else
					JOptionPane.showMessageDialog(null,
							"Fields require integers.", "Error",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		btnPanel.add(btnHeal);

		btnCancel = new JButton("Cancel");
		// ActionListener to cancel
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnPanel.add(btnCancel);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// Make sure inputs are valid
	private boolean verifyFields() {
		try {
			Integer.parseInt(fldHeal.getText());
			if (character.getType() == 'P')
				Integer.parseInt(fldSurges.getText());
			return true;
		}
		catch (NumberFormatException err) {
			return false;
		}
	}
}
