package dnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AddItemFrame extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField fldName;
	private JTextArea areaDescription;
	private JButton btnAdd, btnCancel;
	private JLabel lblName, lblDesc;
	private Character currentChar;

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
					AddItemFrame frame = new AddItemFrame();
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
	public AddItemFrame(Character character)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		fldName = new JTextField();
		areaDescription = new JTextArea(5,30);
		lblDesc = new JLabel("Description:");
		lblName = new JLabel("Name:");
		btnAdd = new JButton("Add Item");
		btnCancel = new JButton("Cancel");
		
		btnAdd.addActionListener(this);
		btnCancel.addActionListener(this);
		
		this.currentChar = character;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			if (!fldName.getText().isEmpty()) {
				currentChar.addItem(fldName.getText(), areaDescription.getText());
				this.dispose();
			}
		}
		else
			if (e.getSource == btnCancel)
				this.dispose();
	}
}
