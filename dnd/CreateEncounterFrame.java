package dnd;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class CreateEncounterFrame {

	private JFrame frame;
	private JPanel addNpcPanel, initiativesPanel;
	private JPanel npcPanel;
	private JButton btnCancel;
	private ArrayList<NPC> npcList = new ArrayList<NPC>();
	private ArrayList<JTextField> fldList = new ArrayList<JTextField>();

	public CreateEncounterFrame() {
		frame = new JFrame("Add NPCs");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		addNpcPanel = new JPanel();
		contentPane.add(addNpcPanel);
		addNpcPanel.setLayout(new BoxLayout(addNpcPanel, BoxLayout.Y_AXIS));

		npcPanel = new JPanel();
		addNpcPanel.add(npcPanel);
		npcPanel.setLayout(new GridBagLayout());

		JPanel btnPanel = new JPanel();
		btnPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		CreateEncounterFrame thisObj = this;
		JButton btnAddNpc = new JButton("Add NPC");
		btnAddNpc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNpcFrame addNpcFrame = new AddNpcFrame(thisObj);
			}
		});
		btnPanel.add(btnAddNpc);
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				initiativesPanel = new JPanel();
				drawInitiativesPanel();
				contentPane.add(initiativesPanel);
				frame.setTitle("Enter initiatives");
				frame.pack();
			}
		});
		btnPanel.add(btnDone);
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnPanel.add(btnCancel);
		addNpcPanel.add(btnPanel);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void addNpc(NPC npc) {
		npcList.add(npc);
		drawNpcs();
	}

	private void drawNpcs() {
		npcPanel.removeAll();
		int col = 0;
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 5, 5, 5);
		for (NPC npc : npcList) {
			gbc.gridy = col++;
			npcPanel.add(new JLabel(npc.getName()), gbc);
			npcPanel.add(new JLabel("Lvl: " + String.valueOf(npc.getLevel())),
					gbc);
			npcPanel.add(new JLabel("Exp: " + String.valueOf(npc.getReward())),
					gbc);
			JButton button = new JButton("X");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					npcList.remove(npc);
					drawNpcs();
				}
			});
			npcPanel.add(button, gbc);
		}
		frame.pack();
	}

	private void drawInitiativesPanel() {
		initiativesPanel.setLayout(new BoxLayout(initiativesPanel,
				BoxLayout.Y_AXIS));
		JPanel playerInitPanel = new JPanel();
		playerInitPanel.setBorder(BorderFactory.createTitledBorder("Players"));
		playerInitPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 5, 5, 5);
		int col = 0;
		for (Player player : ManagerFrame.playerList.getList()) {
			gbc.gridy = col++;
			playerInitPanel.add(new JLabel(player.getName()), gbc);
			JTextField field = new JTextField(3);
			fldList.add(field);
			playerInitPanel.add(field, gbc);
		}
		initiativesPanel.add(playerInitPanel);
		JPanel npcInitPanel = new JPanel();
		npcInitPanel.setBorder(BorderFactory.createTitledBorder("NPCs"));
		npcInitPanel.setLayout(new GridBagLayout());
		col = 0;
		for (NPC npc : npcList) {
			gbc.gridy = col++;
			npcInitPanel.add(new JLabel(npc.getName()), gbc);
			JTextField field = new JTextField(3);
			fldList.add(field);
			npcInitPanel.add(field, gbc);
		}
		if (npcList.size() > 0)
			initiativesPanel.add(npcInitPanel);
		JPanel btnPanel = new JPanel();
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (verifyFields()) {
					int i = 0;
					for (Player player : ManagerFrame.playerList.getList()) {
						player.setInitiative(Integer.parseInt(fldList.get(i++).getText()));
					}
					for (NPC npc : npcList) {
						npc.setInitiative(Integer.parseInt(fldList.get(i++).getText()));
					}
				}
				else
					JOptionPane.showMessageDialog(frame, "Enter all initiative rolls.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnPanel.add(btnStart);
		btnPanel.add(btnCancel);
		initiativesPanel.add(btnPanel);
	}

	private boolean verifyFields() {
		boolean valid = true;
		for (JTextField field : fldList) {
			try {
				Integer.parseInt(field.getText());
			}
			catch (NumberFormatException e) {
				valid = false;
				break;
			}
		}
		return valid;
	}
}
