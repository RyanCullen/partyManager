package dnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EditCharacterFrame extends AddCharacterFrame {

	public EditCharacterFrame(CharacterPanel parent, Character character) {
		super();
		this.character = character;
		frame.setTitle("Editting " + character.getName());
		editting = true;

		btnPanel.removeAll();
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (verifyFields()) {
					saveCharacter();
					parent.updateFields();
					frame.dispose();
				}
			}
		});
		btnPanel.add(btnSave);
		btnPanel.add(btnCancel);
		
		fldName.setText(character.getName());
		fldExp.setText(String.valueOf(character.getExp()));
		fldHp.setText(String.valueOf(character.getMaxHP()));
		fldSurges.setText(String.valueOf(character.getMaxSurges()));
		fldAc.setText(String.valueOf(character.getAc()));
		fldFort.setText(String.valueOf(character.getFort()));
		fldReflex.setText(String.valueOf(character.getRef()));
		fldWill.setText(String.valueOf(character.getWill()));
		fldSpeed.setText(String.valueOf(character.getSpeed()));
		fldGold.setText(String.valueOf(character.getGold()));
	}

	public void saveCharacter() {
		character.setName(fldName.getText());
		character.setExp(Integer.parseInt(fldExp.getText()));
		character.setMaxHP(Integer.parseInt(fldHp.getText()));
		character.setMaxSurges(Integer.parseInt(fldSurges.getText()));
		character.setAc(Integer.parseInt(fldAc.getText()));
		character.setFort(Integer.parseInt(fldFort.getText()));
		character.setRef(Integer.parseInt(fldReflex.getText()));
		character.setWill(Integer.parseInt(fldWill.getText()));
		character.setSpeed(Integer.parseInt(fldSpeed.getText()));
		character.setGold(Integer.parseInt(fldGold.getText()));
		ManagerFrame.charList.save();
	}

}
