package dnd;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class EncounterFrame implements WindowListener, ActionListener {

	private JFrame frmEncounter;
	private ArrayList<Player> playerList;
	private ArrayList<NPC> npcList;
	private ArrayList<EncounterPanel> panelOrder = new ArrayList<EncounterPanel>();
	private JPanel contentPane;
	private JLabel lblRound;
	private JButton btnNext, btnExit;
	private Color defaultColor;
	private int round = 1, turnIndex = 0;

	public EncounterFrame(ArrayList<Player> playerList, ArrayList<NPC> npcList) {
		frmEncounter = new JFrame();
		frmEncounter.setTitle("Encounter");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmEncounter.setContentPane(contentPane);
		frmEncounter
				.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frmEncounter.setResizable(false);
		frmEncounter.addWindowListener(this);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		this.playerList = playerList;
		this.npcList = npcList;
		drawPanels();
		JPanel btnPanel = new JPanel();
		lblRound = new JLabel("Round: 1");
		btnPanel.add(lblRound);
		btnNext = new JButton("Next");
		btnNext.addActionListener(this);
		btnPanel.add(btnNext);
		btnExit = new JButton("Exit");
		btnExit.addActionListener(this);
		btnPanel.add(btnExit);
		contentPane.add(btnPanel);
		panelOrder.sort(null);
		defaultColor = contentPane.getBackground();
		panelOrder.get(0).getPanel().setBackground(Color.LIGHT_GRAY);

		frmEncounter.pack();
		frmEncounter.setLocationRelativeTo(null);
		frmEncounter.setVisible(true);
	}

	private void drawPanels() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		playerList.sort(null);
		npcList.sort(null);
		JPanel allPlayersPanel = new JPanel();
		allPlayersPanel.setLayout(new BoxLayout(allPlayersPanel,
				BoxLayout.Y_AXIS));
		allPlayersPanel.setBorder(BorderFactory.createTitledBorder("Players"));
		for (Player player : playerList) {
			EncounterPanel encounterPanel = new EncounterPanel(player);
			panelOrder.add(encounterPanel);
			allPlayersPanel.add(encounterPanel.getPanel());
		}
		mainPanel.add(allPlayersPanel);
		if (npcList.size() > 0) {
			JPanel allNpcsPanel = new JPanel();
			allNpcsPanel
					.setLayout(new BoxLayout(allNpcsPanel, BoxLayout.Y_AXIS));
			allNpcsPanel.setBorder(BorderFactory.createTitledBorder("NPCs"));
			for (NPC npc : npcList) {
				EncounterPanel encounterPanel = new EncounterPanel(npc);
				panelOrder.add(encounterPanel);
				allNpcsPanel.add(encounterPanel.getPanel());
			}
			mainPanel.add(allNpcsPanel);
		}
		contentPane.add(mainPanel);
	}

	private void nextTurn() {
		panelOrder.get(turnIndex).getPanel().setBackground(defaultColor);
		if (turnIndex == panelOrder.size() - 1) {
			turnIndex = -1;
			lblRound.setText("Round: " + ++round);
		}
		turnIndex++;
		if (panelOrder.get(turnIndex).getCharacter().getCurrentHP() <= 0
				&& panelOrder.get(turnIndex).getCharacter().getType() == 'N') {
			nextTurn();
			return;
		}
		panelOrder.get(turnIndex).getPanel().setBackground(Color.LIGHT_GRAY);
	}

	private int calcExp() {
		int totalReward = 0;
		for (NPC npc : npcList) {
			if (npc.getCurrentHP() <= 0)
				totalReward += npc.getReward();
		}
		return totalReward / playerList.size();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			exit();
		}
		else if (e.getSource() == btnNext) {
			nextTurn();
		}

	}

	private void exit() {
		if (JOptionPane.showConfirmDialog(frmEncounter, "Exit encounter?",
				"Confirm", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
			int reward = calcExp();
			if (JOptionPane.showConfirmDialog(frmEncounter,
					"Award " + String.valueOf(reward) + " exp to each player?",
					"Distribute Exp?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				for (Player player : playerList)
					player.changeExp(reward);
			}
			frmEncounter.dispose();
			ManagerFrame.drawPlayerPanels();
		}
		else
			return;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		exit();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
