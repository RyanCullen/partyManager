package dnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ManagerFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem loadMenuItem;
	private JMenuItem exitMenuItem;
	public static String dataFileName;
	public static CharacterList charList;
	private JMenuItem newMenuItem;
	private JMenu partyMenu;
	private JMenuItem addCharacterMenuItem;
	private JMenuItem deleteCharacterMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerFrame frame = new ManagerFrame();
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
	public ManagerFrame() {
		setTitle("D&D Party Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		newMenuItem = new JMenuItem("New Party");
		fileMenu.add(newMenuItem);

		loadMenuItem = new JMenuItem("Load Party");

		fileMenu.add(loadMenuItem);

		exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(exitMenuItem);

		partyMenu = new JMenu("Party");
		menuBar.add(partyMenu);

		addCharacterMenuItem = new JMenuItem("Add Character");
		partyMenu.add(addCharacterMenuItem);

		deleteCharacterMenuItem = new JMenuItem("Delete Character");
		partyMenu.add(deleteCharacterMenuItem);
		partyMenu.setEnabled(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		loadMenuItem.addActionListener(this);
		exitMenuItem.addActionListener(this);
		newMenuItem.addActionListener(this);
		addCharacterMenuItem.addActionListener(this);
		deleteCharacterMenuItem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == loadMenuItem) {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.setDialogTitle("Load party data file");
			chooser.setCurrentDirectory(new File(System.getenv("UserProfile")
					+ "\\Desktop"));
			chooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				dataFileName = chooser.getSelectedFile().toString();
				charList = new CharacterList(dataFileName);
				partyMenu.setEnabled(true);
			}
		}
		else if (arg0.getSource() == exitMenuItem) {
			this.dispose();
		}
		else if (arg0.getSource() == newMenuItem) {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.setCurrentDirectory(new File(System.getenv("UserProfile")
					+ "\\Desktop"));
			chooser.setDialogTitle("Save party data file");
			chooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
			if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				try {
					File temp = new File(chooser.getSelectedFile() + ".txt");
					temp.createNewFile();
					dataFileName = temp.toString();
					charList = new CharacterList(dataFileName);
					partyMenu.setEnabled(true);
				}
				catch (IOException e) {
					JOptionPane.showMessageDialog(this,
							"Failed to write new file.", "Error",
							JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		}
		else if (arg0.getSource() == addCharacterMenuItem) {
			AddCharacterFrame frame = new AddCharacterFrame();
			frame.setVisible(true);
		}
		else if (arg0.getSource() == deleteCharacterMenuItem) {
			if (charList.getNumChars() != 0) {
				Object[] options = new Object[charList.getNumChars()];
				int i = 0;
				for (Character character : charList.getList())
					options[i++] = character.toString();
				String name = (String) JOptionPane.showInputDialog(this,
						"Choose character to delete.", "Delete Character",
						JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				if (name != null)
					charList.deleteCharacter(name);
			}
			else
				JOptionPane.showMessageDialog(this, "Party is empty. Nothing to delete.", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
