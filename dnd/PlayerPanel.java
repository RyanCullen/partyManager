package dnd;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel implements ActionListener,
		MouseListener, WindowListener {
	private JLabel lblLevel;
	private JLabel lblSpeed;
	private JPanel goldPanel;
	private JLabel lblGold;
	private JTextField fldGold;
	private JButton btnInventory;
	private JPanel HpPanel;
	private JLabel lblHp;
	private JTextField fldHp;
	private JLabel lblMaxHp;
	private JPanel surgesPanel;
	private JLabel lblSurges;
	private JTextField fldSurges;
	private JLabel lblMaxSurges;
	private JPanel speedPanel;
	private JButton btnEditplayer;
	public Player player;
	private JFrame notesFrame;
	private JTextArea notesDisplay;

	/**
	 * Create the panel.
	 */
	public PlayerPanel(Player player) {
		setBorder(BorderFactory.createTitledBorder(player.getName()));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblLevel = new JLabel("Level: " + player.getLevel());
		GridBagConstraints gbc_lblLevel = new GridBagConstraints();
		gbc_lblLevel.insets = new Insets(0, 0, 5, 5);
		gbc_lblLevel.gridx = 0;
		gbc_lblLevel.gridy = 0;
		add(lblLevel, gbc_lblLevel);

		HpPanel = new JPanel();
		GridBagConstraints gbc_HpPanel = new GridBagConstraints();
		gbc_HpPanel.anchor = GridBagConstraints.EAST;
		gbc_HpPanel.insets = new Insets(0, 0, 5, 5);
		gbc_HpPanel.fill = GridBagConstraints.VERTICAL;
		gbc_HpPanel.gridx = 1;
		gbc_HpPanel.gridy = 0;
		add(HpPanel, gbc_HpPanel);

		lblHp = new JLabel("Hp:");
		HpPanel.add(lblHp);

		fldHp = new JTextField(String.valueOf(player.getCurrentHP()), 2);
		fldHp.setHorizontalAlignment(SwingConstants.TRAILING);
		HpPanel.add(fldHp);

		lblMaxHp = new JLabel("/ " + player.getMaxHP());
		HpPanel.add(lblMaxHp);
		fldHp.addActionListener(this);

		goldPanel = new JPanel();
		GridBagConstraints gbc_goldPanel = new GridBagConstraints();
		gbc_goldPanel.anchor = GridBagConstraints.WEST;
		gbc_goldPanel.insets = new Insets(0, 0, 5, 5);
		gbc_goldPanel.fill = GridBagConstraints.VERTICAL;
		gbc_goldPanel.gridx = 2;
		gbc_goldPanel.gridy = 0;
		add(goldPanel, gbc_goldPanel);

		lblGold = new JLabel("Gold:");
		goldPanel.add(lblGold);

		fldGold = new JTextField(String.valueOf(player.getGold()), 4);
		fldGold.setHorizontalAlignment(SwingConstants.TRAILING);
		goldPanel.add(fldGold);

		btnInventory = new JButton("Inventory");
		GridBagConstraints gbc_btnInventory = new GridBagConstraints();
		gbc_btnInventory.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInventory.insets = new Insets(0, 0, 5, 0);
		gbc_btnInventory.gridx = 3;
		gbc_btnInventory.gridy = 0;
		add(btnInventory, gbc_btnInventory);

		surgesPanel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		add(surgesPanel, gbc_panel);

		lblSurges = new JLabel("Surges:");
		surgesPanel.add(lblSurges);

		fldSurges = new JTextField(String.valueOf(player.getCurrentSurges()), 2);
		fldSurges.setHorizontalAlignment(SwingConstants.TRAILING);
		surgesPanel.add(fldSurges);

		lblMaxSurges = new JLabel("/ " + player.getMaxSurges());
		surgesPanel.add(lblMaxSurges);

		speedPanel = new JPanel();
		GridBagConstraints gbc_speedPanel = new GridBagConstraints();
		gbc_speedPanel.anchor = GridBagConstraints.WEST;
		gbc_speedPanel.insets = new Insets(0, 0, 0, 5);
		gbc_speedPanel.fill = GridBagConstraints.VERTICAL;
		gbc_speedPanel.gridx = 2;
		gbc_speedPanel.gridy = 1;
		add(speedPanel, gbc_speedPanel);
		speedPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblSpeed = new JLabel("Speed: " + player.getSpeed());
		speedPanel.add(lblSpeed);

		btnEditplayer = new JButton("Edit player");
		GridBagConstraints gbc_btnEditplayer = new GridBagConstraints();
		gbc_btnEditplayer.gridx = 3;
		gbc_btnEditplayer.gridy = 1;
		add(btnEditplayer, gbc_btnEditplayer);
		btnEditplayer.addActionListener(this);
		btnInventory.addActionListener(this);
		fldGold.addActionListener(this);
		fldSurges.addActionListener(this);

		this.addMouseListener(this);
		this.player = player;
		setVisible(true);
	}

	public void updateFields() {
		this.setBorder(BorderFactory.createTitledBorder(player.getName()));
		fldHp.setText(String.valueOf(player.getCurrentHP()));
		fldSurges.setText(String.valueOf(player.getCurrentSurges()));
		fldGold.setText(String.valueOf(player.getGold()));
		lblLevel.setText("Level: " + player.getLevel());
		lblSpeed.setText("Speed: " + player.getSpeed());
		lblMaxHp.setText("/ " + player.getMaxHP());
		lblMaxSurges.setText("/ " + player.getMaxSurges());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEditplayer) {
			new EditPlayerFrame(this, player);
		}
		else if (e.getSource() == btnInventory) {
			new InventoryFrame(this);
		}
		else if (e.getSource() == fldGold) {
			try {
				int gold = Integer.parseInt(fldGold.getText());
				player.setGold(gold);
			}
			catch (NumberFormatException err) {
				JOptionPane.showMessageDialog(null,
						"Gold field requires an int.", "Error",
						JOptionPane.ERROR_MESSAGE);
				fldGold.setText(String.valueOf(player.getGold()));
			}
		}
		else if (e.getSource() == fldHp) {
			try {
				int hP = Integer.parseInt(fldHp.getText());
				player.setCurrentHP(hP);
			}
			catch (NumberFormatException err) {
				JOptionPane.showMessageDialog(null,
						"Hp field requires an int.", "Error",
						JOptionPane.ERROR_MESSAGE);
				fldHp.setText(String.valueOf(player.getCurrentHP()));
			}
		}
		else if (e.getSource() == fldSurges) {
			try {
				int surges = Integer.parseInt(fldSurges.getText());
				player.setCurrentSurges(surges);
			}
			catch (NumberFormatException err) {
				JOptionPane.showMessageDialog(null,
						"Healing surges field requires an int.", "Error",
						JOptionPane.ERROR_MESSAGE);
				fldSurges.setText(String.valueOf(player.getCurrentSurges()));
			}
		}
	}

	private void displayNotes() {
		notesFrame = new JFrame("Notes on " + player.getName());
		notesFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		notesDisplay = new JTextArea(5, 20);
		notesDisplay.setText(player.getNotes());
		notesFrame.getContentPane().add(notesDisplay);
		notesFrame.pack();
		notesFrame.setLocationRelativeTo(null);
		notesFrame.setVisible(true);
		notesFrame.addWindowListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			displayNotes();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		if (arg0.getSource() == notesFrame) {
			player.setNotes(notesDisplay.getText());
			ManagerFrame.playerList.save();
		}
	}

	@Override
	public void windowClosing(WindowEvent arg0) {

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
