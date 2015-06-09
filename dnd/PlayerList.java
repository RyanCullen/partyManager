package dnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PlayerList {
	private static final int NUM_TOKENS = 14;
	private String filename;
	private ArrayList<Player> playerList = new ArrayList<Player>();
	public ArrayList<String> takenNames = new ArrayList<String>();

	public PlayerList(String filename) {
		this.filename = filename;
		load();
	}

	public void addPlayer(Player player) {
		playerList.add(player);
		takenNames.add(player.getName());
	}

	public void load() {
		try {
			Scanner in = new Scanner(new File(filename));
			while (in.hasNext()) {
				String[] tokens = in.nextLine().split("~");
				if (tokens.length != NUM_TOKENS) {
					System.out.println(tokens.length);
					continue;
				}
				if (takenNames.contains(tokens[0])) {
					JOptionPane.showMessageDialog(null, "The name " + tokens[0]
							+ " is already taken. Player not loaded.",
							"Error", JOptionPane.ERROR_MESSAGE);
					continue;
				}
				else {
					addPlayer(new Player(tokens[0],
							Integer.parseInt(tokens[1]),
							Integer.parseInt(tokens[2]),
							Integer.parseInt(tokens[3]),
							Integer.parseInt(tokens[4]),
							Integer.parseInt(tokens[5]),
							Integer.parseInt(tokens[6]),
							Integer.parseInt(tokens[7]),
							Integer.parseInt(tokens[8]),
							Integer.parseInt(tokens[9]),
							Integer.parseInt(tokens[10]), tokens[11].replace(
									"\\n", "\n"), tokens[12],
							Integer.parseInt(tokens[13])));
					takenNames.add(tokens[0]);
				}
			}
			in.close();
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
			for (Player player : playerList) {
				out.write(player.getRecordString() + "\r\n");
			}
			out.close();
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Failed to write data file.",
					"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public int getNumPlayers() {
		return playerList.size();
	}

	public ArrayList<Player> getList() {
		return playerList;
	}

	public void deleteCharacter(String name) {
		for (Player player : playerList) {
			if (player.getName().equalsIgnoreCase(name)) {
				takenNames.remove(player.getName());
				playerList.remove(player);
				break;
			}
		}
		save();
	}
}
