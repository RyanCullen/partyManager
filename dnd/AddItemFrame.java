package dnd;

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
import javax.swing.border.EmptyBorder;

public class AddItemFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Character currentChar;
	private JLabel lblName;
	private JTextField fldName;
	private JLabel lblDesc;
	private JPanel btnPanel;
	private JButton btnAdd;
	private JButton btnCancel;
	private JLabel lblValue;
	private JTextField fldValue;
	private JTextField fldDesc;

	/**
	 * Create the frame.
	 */
	public AddItemFrame(Character character) {
		setTitle("Add Item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 355, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		contentPane.add(lblName, gbc_lblName);

		fldName = new JTextField();
		GridBagConstraints gbc_fldName = new GridBagConstraints();
		gbc_fldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldName.insets = new Insets(0, 0, 5, 5);
		gbc_fldName.gridx = 1;
		gbc_fldName.gridy = 0;
		contentPane.add(fldName, gbc_fldName);
		fldName.setColumns(10);

		lblValue = new JLabel("Value:");
		GridBagConstraints gbc_lblValue = new GridBagConstraints();
		gbc_lblValue.anchor = GridBagConstraints.EAST;
		gbc_lblValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblValue.gridx = 2;
		gbc_lblValue.gridy = 0;
		contentPane.add(lblValue, gbc_lblValue);

		fldValue = new JTextField();
		GridBagConstraints gbc_fldValue = new GridBagConstraints();
		gbc_fldValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldValue.insets = new Insets(0, 0, 5, 0);
		gbc_fldValue.gridx = 3;
		gbc_fldValue.gridy = 0;
		contentPane.add(fldValue, gbc_fldValue);
		fldValue.setColumns(10);

		lblDesc = new JLabel("Description:");
		GridBagConstraints gbc_lblDesc = new GridBagConstraints();
		gbc_lblDesc.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDesc.gridx = 0;
		gbc_lblDesc.gridy = 1;
		contentPane.add(lblDesc, gbc_lblDesc);

		fldDesc = new JTextField();
		GridBagConstraints gbc_fldDesc = new GridBagConstraints();
		gbc_fldDesc.gridwidth = 3;
		gbc_fldDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldDesc.insets = new Insets(0, 0, 5, 0);
		gbc_fldDesc.gridx = 1;
		gbc_fldDesc.gridy = 1;
		contentPane.add(fldDesc, gbc_fldDesc);
		fldDesc.setColumns(10);

		btnPanel = new JPanel();
		GridBagConstraints gbc_btnPanel = new GridBagConstraints();
		gbc_btnPanel.gridwidth = 4;
		gbc_btnPanel.anchor = GridBagConstraints.SOUTH;
		gbc_btnPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPanel.gridx = 0;
		gbc_btnPanel.gridy = 2;
		contentPane.add(btnPanel, gbc_btnPanel);

		btnAdd = new JButton("Add Item");
		btnPanel.add(btnAdd);

		btnCancel = new JButton("Cancel");
		btnPanel.add(btnCancel);

		btnAdd.addActionListener(this);
		btnCancel.addActionListener(this);

		this.currentChar = character;
		pack();
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			if (!fldName.getText().isEmpty() && !fldValue.getText().isEmpty()) {
				try {
					currentChar.addItem(fldName.getText(), fldDesc.getText(),
							Integer.parseInt(fldValue.getText()));
					ManagerFrame.charList.save();
					this.dispose();
				}
				catch (NumberFormatException err) {
					JOptionPane.showMessageDialog(this,
							"Value field requires in int.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			else
				JOptionPane.showMessageDialog(this,
						"Name and value fields required.", "Error",
						JOptionPane.ERROR_MESSAGE);
		}
		else if (e.getSource() == btnCancel)
			this.dispose();
	}
}
