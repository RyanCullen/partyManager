package dnd;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class EncounterPanel implements Comparable<EncounterPanel> {

	private JPanel panel;
	private int initiative;
	private Character character;
	private JLabel lblLvl;
	private JLabel lblHp;
	private JLabel lblSurges;
	private JButton btnAttack;
	private JButton btnHeal;

	public EncounterPanel(Character character) {
		this.character = character;
		this.initiative = character.getInitiative();
		EncounterPanel thisObj = this;
		panel = new JPanel();
		panel.setBorder(new TitledBorder(character.getName()));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		
				lblLvl = new JLabel("Lvl: " + String.valueOf(character.getLevel()));
				GridBagConstraints gbc_lblLvl = new GridBagConstraints();
				gbc_lblLvl.anchor = GridBagConstraints.WEST;
				gbc_lblLvl.insets = new Insets(0, 0, 5, 5);
				gbc_lblLvl.gridx = 0;
				gbc_lblLvl.gridy = 0;
				panel.add(lblLvl, gbc_lblLvl);

		lblHp = new JLabel("Hp: "
				+ String.valueOf(character.getCurrentHP() + " / "
						+ String.valueOf(character.getMaxHP())));
		GridBagConstraints gbc_lblHp = new GridBagConstraints();
		gbc_lblHp.anchor = GridBagConstraints.WEST;
		gbc_lblHp.insets = new Insets(0, 0, 5, 5);
		gbc_lblHp.gridx = 1;
		gbc_lblHp.gridy = 0;
		panel.add(lblHp, gbc_lblHp);

		btnAttack = new JButton("Attack");
		btnAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AttackFrame attackFrame = new AttackFrame(thisObj);
			}
		});
		GridBagConstraints gbc_btnAttack = new GridBagConstraints();
		gbc_btnAttack.insets = new Insets(0, 0, 5, 0);
		gbc_btnAttack.gridx = 2;
		gbc_btnAttack.gridy = 0;
		panel.add(btnAttack, gbc_btnAttack);

		if (character.getType() == 'P')
			lblSurges = new JLabel("Surges: "
					+ ((Player) character).getCurrentSurges());
		else
			lblSurges = new JLabel("Reward: "
					+ String.valueOf(((NPC) character).getReward()));
		GridBagConstraints gbc_lblSurges = new GridBagConstraints();
		gbc_lblSurges.anchor = GridBagConstraints.WEST;
		gbc_lblSurges.insets = new Insets(0, 0, 0, 5);
		gbc_lblSurges.gridx = 1;
		gbc_lblSurges.gridy = 1;
		panel.add(lblSurges, gbc_lblSurges);

		btnHeal = new JButton("Heal");
		btnHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HealFrame healFrame = new HealFrame(thisObj);
			}
		});
		GridBagConstraints gbc_btnHeal = new GridBagConstraints();
		gbc_btnHeal.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHeal.gridx = 2;
		gbc_btnHeal.gridy = 1;
		panel.add(btnHeal, gbc_btnHeal);

		panel.setVisible(true);
		panel.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2)
					displayNotes();
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}
			
		});;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void updateFields() {

	}

	public Character getCharacter() {
		return this.character;
	}

	public int getInitiative() {
		return initiative;
	}

	private void displayNotes() {
		JFrame notesFrame = new JFrame("Notes on " + character.getName());
		notesFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		JTextArea notesDisplay = new JTextArea(5, 20);
		notesDisplay.setText(character.getNotes());
		notesFrame.getContentPane().add(notesDisplay);
		notesFrame.pack();
		notesFrame.setLocationRelativeTo(null);
		notesFrame.setVisible(true);
		notesFrame.addWindowListener(new WindowListener() {

			public void windowActivated(WindowEvent arg0) {
			}

			public void windowClosed(WindowEvent arg0) {
				character.setNotes(notesDisplay.getText());
				if (character.getType() == 'P')
					ManagerFrame.playerList.save();
			}

			public void windowClosing(WindowEvent arg0) {
			}

			public void windowDeactivated(WindowEvent arg0) {
			}

			public void windowDeiconified(WindowEvent arg0) {
			}

			public void windowIconified(WindowEvent arg0) {
			}

			public void windowOpened(WindowEvent arg0) {
			}

		});
	}

	@Override
	public int compareTo(EncounterPanel o) {
		return o.getInitiative() - this.initiative;
	}

}
