package dnd;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class CreateEncounterFrame {

	private JFrame frame;
	private JPanel addNpcPanel, initiativesPanel;
	private JPanel npcPanel;
	private JButton btnAddNpc;
	private ArrayList<NPC> npcList = new ArrayList<NPC>();

	public CreateEncounterFrame() {
		frame = new JFrame("New Encounter");
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
		btnAddNpc = new JButton("Add NPC");
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
				drawInitiativesPanel();
				contentPane.add(initiativesPanel);
				frame.pack();
			}
		});
		btnPanel.add(btnDone);
		JButton btnCancel = new JButton("Cancel");
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
		initiativesPanel = new JPanel();
		
	}
	
}
