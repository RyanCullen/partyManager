package dnd;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCharacterFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private CharacterList charList;
	private JLabel lblName;
	private JTextField fldName;
	private JLabel lblExp;
	private JTextField fldExp;
	private JLabel lblHp;
	private JTextField fldHp;
	private JLabel lblSurges;
	private JTextField fldSurges;
	private JLabel lblAc;
	private JTextField fldAc;
	private JLabel lblFort;
	private JTextField fldFort;
	private JLabel lblReflex;
	private JLabel lblWil;
	private JLabel lblSpeed;
	private JLabel lblGold;
	private JTextField fldReflex;
	private JTextField fldWill;
	private JTextField fldSpeed;
	private JTextField fldGold;
	private JButton btnAdd;
	private JButton btnCancel;
	private JPanel row0, row1, row2, row3, row4, row5;

	/**
	 * Create the frame.
	 */
	public AddCharacterFrame() {
		setTitle("New Character");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 225);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 1));
		row0 = new JPanel();
		row0.setLayout(new GridLayout(1, 4));
		contentPane.add(row0);
		row1 = new JPanel();
		row1.setLayout(new GridLayout(1, 4));
		contentPane.add(row1);
		row2 = new JPanel();
		row2.setLayout(new GridLayout(1, 4));
		contentPane.add(row2);
		row3 = new JPanel();
		row3.setLayout(new GridLayout(1, 4));
		contentPane.add(row3);
		row4 = new JPanel();
		row4.setLayout(new GridLayout(1, 4));
		contentPane.add(row4);
		row5 = new JPanel();
		row5.setLayout(new GridLayout(1, 2));
		contentPane.add(row5);

		lblName = new JLabel("Name:");
		row0.add(lblName);

		fldName = new JTextField();
		row0.add(fldName);
		fldName.setColumns(10);

		lblExp = new JLabel("Experience:");
		row0.add(lblExp);

		fldExp = new JTextField();
		row0.add(fldExp);
		fldExp.setColumns(10);

		lblHp = new JLabel("Hitpoints:");
		row1.add(lblHp);

		fldHp = new JTextField();
		row1.add(fldHp);
		fldHp.setColumns(10);

		lblSurges = new JLabel("Healing Surges:");
		row1.add(lblSurges);

		fldSurges = new JTextField();
		row1.add(fldSurges);
		fldSurges.setColumns(10);

		lblAc = new JLabel("Armor Class:");
		row2.add(lblAc);

		fldAc = new JTextField();
		row2.add(fldAc);
		fldAc.setColumns(10);

		lblFort = new JLabel("Fortitude:");
		row2.add(lblFort);

		fldFort = new JTextField();
		row2.add(fldFort);
		fldFort.setColumns(10);

		lblReflex = new JLabel("Reflex:");
		row3.add(lblReflex);

		fldReflex = new JTextField();
		row3.add(fldReflex);
		fldReflex.setColumns(10);

		lblWil = new JLabel("Wil:");
		row3.add(lblWil);

		fldWill = new JTextField();
		row3.add(fldWill);
		fldWill.setColumns(10);

		lblSpeed = new JLabel("Speed:");
		row4.add(lblSpeed);

		fldSpeed = new JTextField();
		row4.add(fldSpeed);
		fldSpeed.setColumns(10);

		lblGold = new JLabel("Gold:");
		row4.add(lblGold);

		fldGold = new JTextField();
		row4.add(fldGold);
		fldGold.setColumns(10);

		btnAdd = new JButton("Add");
		row5.add(btnAdd);
		btnCancel = new JButton("Cancel");
		row5.add(btnCancel);

		btnCancel.addActionListener(this);
		btnAdd.addActionListener(this);

		charList = ManagerFrame.charList;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			if (verifyFields()) {
				addCharacter();
				ManagerFrame.drawCharPanels();
				this.dispose();
			}
		}
		else if (e.getSource() == btnCancel)
			this.dispose();
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
			JOptionPane.showMessageDialog(this, errorString, "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else
			return true;
	}
}
