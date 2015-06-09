package dnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class ManagerFrame extends JFrame implements ActionListener,
		WindowListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem loadMenuItem;
	private JMenuItem exitMenuItem;
	public static String dataFileName;
	public static PlayerList playerList;
	private JMenuItem newMenuItem;
	private JMenu partyMenu;
	private JMenuItem addPlayerMenuItem;
	private JMenuItem deletePlayerMenuItem;
	private static JPanel playerPanel;
	private static ManagerFrame frame;
	private JMenuItem startNewEncounterMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ManagerFrame();
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
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);

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

		addPlayerMenuItem = new JMenuItem("Add Player");
		partyMenu.add(addPlayerMenuItem);

		deletePlayerMenuItem = new JMenuItem("Delete Player");
		partyMenu.add(deletePlayerMenuItem);
		partyMenu.setEnabled(false);

		startNewEncounterMenuItem = new JMenuItem("Start New Encounter");
		partyMenu.add(startNewEncounterMenuItem);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		loadMenuItem.addActionListener(this);
		exitMenuItem.addActionListener(this);
		newMenuItem.addActionListener(this);
		addPlayerMenuItem.addActionListener(this);
		deletePlayerMenuItem.addActionListener(this);
		startNewEncounterMenuItem.addActionListener(this);

		playerPanel = new JPanel();
		playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
		contentPane.add(playerPanel, BorderLayout.CENTER);
		addWindowListener(this);
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
				playerList = new PlayerList(dataFileName);
				partyMenu.setEnabled(true);
				drawPlayerPanels();
			}
		}
		else if (arg0.getSource() == exitMenuItem) {
			if (JOptionPane.showConfirmDialog(null, "Exit?", "Confirm",
					JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
				if (playerList != null) {
					playerList.save();
				}
				this.dispose();
			}

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
					playerList = new PlayerList(dataFileName);
					partyMenu.setEnabled(true);
					drawPlayerPanels();
				}
				catch (IOException e) {
					JOptionPane.showMessageDialog(this,
							"Failed to write new file.", "Error",
							JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		}
		else if (arg0.getSource() == addPlayerMenuItem) {
			new AddPlayerFrame();
		}
		else if (arg0.getSource() == deletePlayerMenuItem) {
			if (playerList.getNumPlayers() != 0) {
				Object[] options = new Object[playerList.getNumPlayers()];
				int i = 0;
				for (Character character : playerList.getList())
					options[i++] = character.toString();
				String name = (String) JOptionPane.showInputDialog(this,
						"Choose player to delete.", "Delete Player",
						JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				if (name != null) {
					playerList.deleteCharacter(name);
					ManagerFrame.drawPlayerPanels();
				}
			}
			else
				JOptionPane.showMessageDialog(this,
						"Party is empty. Nothing to delete.", "Error",
						JOptionPane.ERROR_MESSAGE);
		}
		else if (arg0.getSource() == startNewEncounterMenuItem) {
			if (playerList.getNumPlayers() > 0) {
				new CreateEncounterFrame();
			}
			else
				JOptionPane
						.showMessageDialog(
								frame,
								"Party must have at least one member to initiate encounters.",
								"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void drawPlayerPanels() {
		playerPanel.removeAll();
		for (Player player : playerList.getList()) {
			playerPanel.add(new PlayerPanel(player));
		}
		frame.pack();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {

	}

	@Override
	public void windowClosed(WindowEvent arg0) {

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		if (JOptionPane.showConfirmDialog(null, "Exit?", "Confirm",
				JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
			if (playerList != null) {
				playerList.save();
			}
			System.exit(0);
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {

	}

	@Override
	public void windowIconified(WindowEvent arg0) {

	}

	@Override
	public void windowOpened(WindowEvent arg0) {

	}

}
