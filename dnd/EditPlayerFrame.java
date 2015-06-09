package dnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EditPlayerFrame extends AddPlayerFrame {

	public EditPlayerFrame(PlayerPanel parent, Player player) {
		super();
		this.player = player;
		frame.setTitle("Editting " + player.getName());
		editting = true;

		btnPanel.removeAll();
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (verifyFields()) {
					savePlayer();
					parent.updateFields();
					frame.dispose();
				}
			}
		});
		btnPanel.add(btnSave);
		btnPanel.add(btnCancel);
		
		fldName.setText(player.getName());
		fldExp.setText(String.valueOf(player.getExp()));
		fldHp.setText(String.valueOf(player.getMaxHP()));
		fldSurges.setText(String.valueOf(player.getMaxSurges()));
		fldAc.setText(String.valueOf(player.getAc()));
		fldFort.setText(String.valueOf(player.getFort()));
		fldReflex.setText(String.valueOf(player.getRef()));
		fldWill.setText(String.valueOf(player.getWill()));
		fldSpeed.setText(String.valueOf(player.getSpeed()));
		fldGold.setText(String.valueOf(player.getGold()));
	}

	public void savePlayer() {
		player.setName(fldName.getText());
		player.setExp(Integer.parseInt(fldExp.getText()));
		player.setMaxHP(Integer.parseInt(fldHp.getText()));
		player.setMaxSurges(Integer.parseInt(fldSurges.getText()));
		player.setAc(Integer.parseInt(fldAc.getText()));
		player.setFort(Integer.parseInt(fldFort.getText()));
		player.setRef(Integer.parseInt(fldReflex.getText()));
		player.setWill(Integer.parseInt(fldWill.getText()));
		player.setSpeed(Integer.parseInt(fldSpeed.getText()));
		player.setGold(Integer.parseInt(fldGold.getText()));
		ManagerFrame.playerList.save();
	}

}
