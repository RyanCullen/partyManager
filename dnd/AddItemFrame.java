package dnd;

import java.awt.EventQueue;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddItemFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Character currentChar;
	private JLabel lblName;
	private JTextField fldName;
	private JLabel lblDesc;
	private JTextArea areaDesc;
	private JPanel btnPanel;
	private JButton btnAdd;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItemFrame frame = new AddItemFrame(null);
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddItemFrame(Character character) {
		setTitle("Add Item");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0,
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
		gbc_fldName.insets = new Insets(0, 0, 5, 0);
		gbc_fldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldName.gridx = 1;
		gbc_fldName.gridy = 0;
		contentPane.add(fldName, gbc_fldName);
		fldName.setColumns(10);

		lblDesc = new JLabel("Description:");
		GridBagConstraints gbc_lblDesc = new GridBagConstraints();
		gbc_lblDesc.anchor = GridBagConstraints.NORTH;
		gbc_lblDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDesc.gridx = 0;
		gbc_lblDesc.gridy = 1;
		contentPane.add(lblDesc, gbc_lblDesc);

		areaDesc = new JTextArea();
		GridBagConstraints gbc_areaDesc = new GridBagConstraints();
		gbc_areaDesc.insets = new Insets(0, 0, 5, 0);
		gbc_areaDesc.fill = GridBagConstraints.BOTH;
		gbc_areaDesc.gridx = 1;
		gbc_areaDesc.gridy = 1;
		areaDesc.setBorder(BorderFactory.createEtchedBorder());
		contentPane.add(areaDesc, gbc_areaDesc);

		btnPanel = new JPanel();
		GridBagConstraints gbc_btnPanel = new GridBagConstraints();
		gbc_btnPanel.anchor = GridBagConstraints.SOUTH;
		gbc_btnPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPanel.gridx = 1;
		gbc_btnPanel.gridy = 2;
		contentPane.add(btnPanel, gbc_btnPanel);

		btnAdd = new JButton("Add Item");
		btnPanel.add(btnAdd);

		btnCancel = new JButton("Cancel");
		btnPanel.add(btnCancel);

		btnAdd.addActionListener(this);
		btnCancel.addActionListener(this);

		this.currentChar = character;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			if (!fldName.getText().isEmpty()) {
				currentChar.addItem(fldName.getText(), areaDesc.getText());
				this.dispose();
			}
			else
				JOptionPane.showMessageDialog(this, "Name field required.",
						"Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (e.getSource() == btnCancel)
			this.dispose();
	}
}
