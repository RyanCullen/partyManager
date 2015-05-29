package dnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CharacterList {
	private static final int NUM_TOKENS = 14;
	private String filename;
	private ArrayList<Character> charList = new ArrayList<Character>();
	public ArrayList<String> takenNames = new ArrayList<String>();

	public CharacterList(String filename) {
		this.filename = filename;
		load();
	}

	public void addCharacter(Character character) {
		charList.add(character);
		takenNames.add(character.getName());
	}

	public void load() {
		try {
			Scanner in = new Scanner(new File(filename));
			while (in.hasNext()) {
				String[] tokens = in.nextLine().split("~");
				if (tokens.length != NUM_TOKENS) {
					continue;
				}
				if (takenNames.contains(tokens[0])) {
					JOptionPane.showMessageDialog(null, "The name " + tokens[0]
							+ " is already taken. Character not loaded.",
							"Error", JOptionPane.ERROR_MESSAGE);
					continue;
				}
				else {
					addCharacter(new Character(tokens[0],
							Integer.parseInt(tokens[1]),
							Integer.parseInt(tokens[2]),
							Integer.parseInt(tokens[3]),
							Integer.parseInt(tokens[4]),
							Integer.parseInt(tokens[5]),
							Integer.parseInt(tokens[6]),
							Integer.parseInt(tokens[7]),
							Integer.parseInt(tokens[8]),
							Integer.parseInt(tokens[9]),
							Integer.parseInt(tokens[10]),
							Integer.parseInt(tokens[11]), tokens[12],
							tokens[13]));
					takenNames.add(tokens[0]);
				}
			}
		}
		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found.", "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			FileWriter out = new FileWriter(new File(filename));
			for (Character aChar : charList) {
				out.write(aChar.getRecordString() + "\r\n");
			}
			out.close();
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Failed to write data file.",
					"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public int getNumChars() {
		return charList.size();
	}

	public ArrayList<Character> getList() {
		return charList;
	}

	public Character getCharacter(String name) {
		for (Character aChar : charList) {
			if (aChar.getName().equalsIgnoreCase(name))
				return aChar;
		}
		return null;
	}

	public void deleteCharacter(String name) {
		for (Character aChar : charList) {
			if (aChar.getName().equalsIgnoreCase(name)) {
				takenNames.remove(aChar.getName());
				charList.remove(aChar);
				break;
			}
		}
		save();
	}
}
