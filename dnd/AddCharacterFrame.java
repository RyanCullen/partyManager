package dnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AddCharacterFrame extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField fldName, fldLevel, fldExp, fldHp, fldSurges, fldAc, fldFort, fldRef, fldWill, fldSpeed, fldGold;
	private JLabel lblName, lblLevel, lblExp, lblHp, lblSurges, lblAc, lblFort, lblRef, lblWill, lblSpeed, lblGold;
	private JButton btnAdd, btnCancel;
	private CharacterList charList;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AddCharacterFrame frame = new AddCharacterFrame();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddCharacterFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		charList = new CharacterList(ManagerFrame.dataFileName);
		
		lblName = new JLabel("Name:");
		lblLevel = new JLabel("Level:");
		lblExp = new JLabel("Experience:");
		lblHp = new JLabel("Hitpoints:");
		lblSurges = new JLabel("Healing Surges:");
		lblAc = new JLabel("Armor Class:");
		lblFort = new JLabel("Fortitude:");
		lblRef = new JLabel("Reflex:");
		lblWill = new JLabel("Will:");
		lblSpeed = new JLabel("Speed:");
		lblGold = new JLabel("Gold:");
		
		fldName = new JTextField();
		fldLevel = new JTextField();
		fldExp = new JTextField();
		fldHp = new JTextField();
		fldSurges = new JTextField();
		fldAc = new JTextField();
		fldFort = new JTextField();
		fldRef = new JTextField();
		fldWill = new JTextField();
		fldSpeed = new JTextField();
		fldGold = new JTextField();
		
		btnAdd = new JButton("Add Character");
		btnCancel = new JButton("Cancel");
		btnAdd.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			if (verifyFields())
				addCharacter();
		}
		else
			if (e.getSource() == btnCancel) 
				this.dispose();
	}
	
	public void addCharacter() {
		
	}
	
	public boolean verifyFields() {
		String errorString = "";
		if (charList.contains(fldName.getValue())
			errorString += "Name " + fldName.getValue() + " is already taken.\n";
		if (fldName.getValue().isEmpty())
			errorString += "Name is a required field.\n";
		
	}
}
